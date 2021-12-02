package women.fashion.compare.clothes.shop.womenshopping.offers.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.gson.Gson

import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.User
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking.LOGIN_USER_EXIST_CHECK
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.UserRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.*
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider

class LoginViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val userRepository: UserRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val validationsList: MutableLiveData<List<Validation>> = MutableLiveData()

    val launchMain: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val launchSignup: MutableLiveData<GoogleSignInAccount> = MutableLiveData()

    val emailField: MutableLiveData<String> = MutableLiveData()
    val passwordField: MutableLiveData<String> = MutableLiveData()
    val loggingIn: MutableLiveData<Boolean> = MutableLiveData()

    val emailValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.EMAIL)
    val passwordValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.PASSWORD)

    private fun filterValidation(field: Validation.Field) =
        Transformations.map(validationsList) {
            it.find { validation -> validation.field == field }
                ?.run { return@run this.resource }
                ?: Resource.unknown()
        }

    override fun onCreate() {}

    fun onEmailChange(email: String) = emailField.postValue(email)

    fun onPasswordChange(email: String) = passwordField.postValue(email)

    fun onLogin() {
        val email = emailField.value
        val password = passwordField.value

        val validations = Validator.validateLoginFields(email, password)
        validationsList.postValue(validations)

        if (validations.isNotEmpty() && email != null && password != null) {
            val successValidation = validations.filter { it.resource.status == Status.SUCCESS }
            if (successValidation.size == validations.size && checkInternetConnectionWithMessage()) {
                loggingIn.postValue(true)
                compositeDisposable.addAll(
                    userRepository.doUserLogin(email, password, null, null)
                        .subscribeOn(schedulerProvider.io())
                        .subscribe(
                            {
                                Timber.tag("Login").d(Gson().toJson(it))
                                val user = User(it.data.id, it.data.name, it.data.email, it.data.token, it.data.profileImg)
                                userRepository.saveCurrentUser(user)
                                loggingIn.postValue(false)
                                launchMain.postValue(Event(emptyMap()))
                            },
                            {
                                Timber.tag("Login").d(it)
                                handleNetworkError(it)
                                loggingIn.postValue(false)
                            }
                        )
                )
            }
        }
    }

    fun onGoogleLogin(account: GoogleSignInAccount) {

//        val validations = Validator.validateLoginFields(email, password)
//        validationsList.postValue(validations)

        if (checkInternetConnectionWithMessage()) {
            loggingIn.postValue(true)
            compositeDisposable.addAll(
                userRepository.doUserLogin(account.email,null, account.idToken, null)
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        {
                            Timber.tag("Login").d(Gson().toJson(it))
                            loggingIn.postValue(false)
                            if(it.statusMessage == LOGIN_USER_EXIST_CHECK){
                                launchSignup.postValue(account)
                            }
                            else{
                                val user = User(it.data.id, it.data.name, it.data.email, it.data.token, it.data.profileImg)
                                launchMain.postValue(Event(emptyMap()))
                                userRepository.saveCurrentUser(user)
                            }
                        },
                        {
                            Timber.tag("Login").d(it)
                            handleNetworkError(it)
                            loggingIn.postValue(false)
                            launchSignup.value
                        }
                    )
            )
        }
    }

}