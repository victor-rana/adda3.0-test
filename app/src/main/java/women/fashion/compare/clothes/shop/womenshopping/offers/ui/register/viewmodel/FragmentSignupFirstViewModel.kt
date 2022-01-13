package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import io.reactivex.disposables.CompositeDisposable
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.UserRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.*
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider

class FragmentSignupFirstViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val userRepository: UserRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val validationsList: MutableLiveData<List<Validation>> = MutableLiveData()

    val emailField: MutableLiveData<String> = MutableLiveData()
    val passwordField: MutableLiveData<String> = MutableLiveData()
    val cnfPasswordField: MutableLiveData<String> = MutableLiveData()

    val changeFragment: MutableLiveData<Boolean> = MutableLiveData()

    val emailValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.EMAIL)
    val passwordValidation: LiveData<Resource<Int>> = filterValidation(Validation.Field.PASSWORD)

    private fun filterValidation(field: Validation.Field) =
        Transformations.map(validationsList) {
            it.find { validation -> validation.field == field }
                ?.run { return@run this.resource }
                ?: Resource.unknown()
        }

    override fun onCreate() {}

    fun onEmailChange(email: String) {
        emailField.postValue(email)
    }

    fun onPasswordChange(email: String) = passwordField.postValue(email)

    fun onCnfPasswordChange(email: String) = cnfPasswordField.postValue(email)

    fun doChangeFragment(){
        val email = emailField.value
        val password = passwordField.value
        val cnfPassword = cnfPasswordField.value

        val validations = Validator.validateSignupFields(email, password, cnfPassword)
        validationsList.postValue(validations)

        if (validations.isNotEmpty() && email != null && password != null) {
            val successValidation = validations.filter { it.resource.status == Status.SUCCESS }
            if (successValidation.size == validations.size && checkInternetConnectionWithMessage()) {
                if(cnfPassword.equals(password, false)){
                    changeFragment.postValue(true)
                }
            }
        }

    }
}