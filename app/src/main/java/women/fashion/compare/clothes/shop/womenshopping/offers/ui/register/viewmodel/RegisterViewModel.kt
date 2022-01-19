package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.util.HalfSerializer.onError
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.User
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.register.RegisterRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.RegisterResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.UserRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Event
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Validator
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider
import javax.inject.Inject


class RegisterViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val userRepository: UserRepository,
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper)  {



    override fun onCreate() {

    }

    val launchMain: MutableLiveData<String> = MutableLiveData()
    val googleLiveData: MutableLiveData<GoogleSignInAccount> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessageView: MutableLiveData<Int> = MutableLiveData()

    var emailMutableLiveData: MutableLiveData<String> = MutableLiveData()
    var phoneNumberMutableLiveData: MutableLiveData<String> = MutableLiveData()
    var passwordMutableLiveData: MutableLiveData<String> = MutableLiveData()
    var dayMutableLiveData: MutableLiveData<String> = MutableLiveData()
    var monthMutableLiveData: MutableLiveData<String> = MutableLiveData()
    var yearMutableLiveData: MutableLiveData<String> = MutableLiveData()
    var genderMutableLiveData: MutableLiveData<String> = MutableLiveData()


    fun setEmail(email : String){
        emailMutableLiveData = MutableLiveData<String>(email)
    }

    fun getEmail(): LiveData<String>{
        return emailMutableLiveData
    }

    fun setPhoneNumber(phoneNumber : String){
        phoneNumberMutableLiveData = MutableLiveData<String>(phoneNumber)
    }

    fun getPhoneNumber(): LiveData<String>{
        return phoneNumberMutableLiveData
    }

    fun setPassword(password : String){
        passwordMutableLiveData.postValue(password)
    }

    fun getPassword(): LiveData<String>{
        return passwordMutableLiveData
    }

    fun setGender(gender : String){
        genderMutableLiveData.postValue(gender)
    }

    fun getGender(): LiveData<String>{
        return genderMutableLiveData
    }

    fun setDay(day : String){
        dayMutableLiveData.postValue(day)
    }

    fun getDay(): LiveData<String>{
        return dayMutableLiveData
    }

    fun setMonth(month : String){
        monthMutableLiveData.postValue(month)
    }

    fun getMonth(): LiveData<String>{
        return monthMutableLiveData
    }

    fun setYear(year : String){
        yearMutableLiveData.postValue(year)
    }

    fun getYear(): LiveData<String>{
        return yearMutableLiveData
    }

    fun registerUser(registerRequest: RegisterRequest){
        if(!Validator.validateEmail(getEmail().value.toString())){
            errorMessageView.postValue(R.string.email_field_invalid)
        } else if(!Validator.validatePhoneNumber(getPhoneNumber().value.toString())){
            errorMessageView.postValue(R.string.phone_number_field_error)
        } else if(!Validator.validatePassword(getPassword().value.toString())){
            errorMessageView.postValue(R.string.password_field_small_length)
        } else if(Validator.validateEmpty(getGender().value.toString())){
            errorMessageView.postValue(R.string.gender_not_selected)
        } else if(Validator.validateEmpty(getDay().value.toString())){
            errorMessageView.postValue(R.string.select_day)
        } else if(Validator.validateEmpty(getMonth().value.toString())){
            errorMessageView.postValue(R.string.select_month)
        } else if(Validator.validateEmpty(getYear().value.toString())){
            errorMessageView.postValue(R.string.select_year)
        } else {
            if (checkInternetConnectionWithMessage()) {
                compositeDisposable.addAll(
                    userRepository.doUserRegister(registerRequest).toObservable()
                        .firstOrError()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<RegisterResponse?>() {
                            override fun onSuccess(response: RegisterResponse) {
                                if (response.statusCode == 200) {
                                    launchMain.postValue(response.statusMessage)
                                } else {
                                  errorMessage.postValue(response.statusMessage)
                                }
                                loader.postValue(true)
                            }

                            override fun onError(e: Throwable) {
                                Log.d("TAG", "onError :   " + e.message)
                                handleNetworkError(e);

                            } })) } }}

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
}