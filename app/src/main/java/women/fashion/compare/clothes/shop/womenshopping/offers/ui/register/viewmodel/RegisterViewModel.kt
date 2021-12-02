package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel

import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import io.reactivex.disposables.CompositeDisposable
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.User
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.register.RegisterRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.GoogleKeys.Companion.EMAIL
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.GoogleKeys.Companion.FAMILY_NAME
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.GoogleKeys.Companion.NAME
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.GoogleKeys.Companion.PROFILE_IMG
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.UserRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Event
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider

class RegisterViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val userRepository: UserRepository,

) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper)  {

    val launchMain: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val googleLiveData: MutableLiveData<GoogleSignInAccount> = MutableLiveData()
    val loggingIn: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    override fun onCreate() {

    }

    fun handleLoginResponse(data: Any?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data as Intent)
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
            googleLiveData.postValue(account)

            Log.d(LoginActivity.TAG,"handleLoginResponse ok")

        } catch (e: Exception) {
            Log.d(LoginActivity.TAG,"handleLoginResponse error: ${e.message}")
            e.message?.let { errorMessage.postValue(it) }
        }
    }


    fun doRegister(registerRequest: RegisterRequest){
        if (checkInternetConnectionWithMessage()) {
            loggingIn.postValue(true)
            compositeDisposable.addAll(
                userRepository.doUserRegister(registerRequest)
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        {
                            val user = User(it.data.id, it.data.name, it.data.email, "it.data.token", it.data.profileImg)
                            loggingIn.postValue(false)
                            if(it.statusMessage == Networking.REGISTER_USER_CHECK){
                                launchMain.postValue(Event(emptyMap()))
                                userRepository.saveCurrentUser(user)
                            }
                            else{
                               errorMessage.postValue(it.statusMessage)
                            }
                        },
                        {
                            handleNetworkError(it)
                            loggingIn.postValue(false)
                        }
                    )
            )
        }

    }
}