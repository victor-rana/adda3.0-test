package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel

import android.content.Intent
import android.util.Log
import android.widget.Toast
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
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.User
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.register.RegisterRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.RegisterResponse
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
                    .subscribe({
                            val user = User(it.data.id, it.data.name, it.data.email, "it.data.token", it.data.profileImg)
                            loggingIn.postValue(false)
                            if(it.statusMessage == Networking.REGISTER_USER_CHECK){
                                launchMain.postValue(Event(emptyMap()))
                              //  userRepository.saveCurrentUser(user)
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


    fun registerUser(registerRequest: RegisterRequest){
        if (checkInternetConnectionWithMessage()) {
            loggingIn.postValue(true)
            compositeDisposable.addAll(userRepository.doUserRegister(registerRequest).toObservable()
                    .firstOrError()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<RegisterResponse?>() {
                        override fun onSuccess(response: RegisterResponse) {

                            Log.d("TAG", "onSuccess  :   "+response.toString())
                        }
                        override fun onError(e: Throwable) {
                            Log.d("TAG", "onError :   "+e.message)
                        }
                    })
            )

        }



    }
}