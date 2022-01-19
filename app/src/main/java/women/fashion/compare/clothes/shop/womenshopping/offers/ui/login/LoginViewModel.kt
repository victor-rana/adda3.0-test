package women.fashion.compare.clothes.shop.womenshopping.offers.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.gson.Gson

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import timber.log.Timber
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.User
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking.LOGIN_USER_EXIST_CHECK
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.login.LoginResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.RegisterResponse
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

    var logIn: MutableLiveData<Boolean> = MutableLiveData()

    override fun onCreate() {}

    fun onLogin(email: String, password: String) {

        if (checkInternetConnectionWithMessage()) {
            compositeDisposable.addAll(userRepository.doUserLogin(email, password, null, null)
                .toObservable()
                .firstOrError()
                .subscribeOn(schedulerProvider.io())
                .subscribeWith(object : DisposableSingleObserver<LoginResponse?>() {
                    override fun onSuccess(t: LoginResponse) {
                        if (t.statusCode == 200) {
                            if (t.data != null) {
                                userRepository.saveCurrentUser(t.data)
                                logIn.postValue(true)
                            } else {
                                logIn.postValue(false)
                            }
                        } else {
                            logIn.postValue(false)
                        }
                        loader.postValue(true)
                    }

                    override fun onError(e: Throwable) {
                        Log.d("TAG", "onError: " + e.printStackTrace())
                        handleNetworkError(e)
                        loader.postValue(true)
                    }

                }

                )
            )
        }
    }

    fun onGoogleLogin(account: GoogleSignInAccount) {
        if (checkInternetConnectionWithMessage()) {
            compositeDisposable.addAll(
                userRepository.doUserLogin(account.email, null, account.idToken, null)
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        {
                            Timber.tag("Login").d(Gson().toJson(it))
                            if (it.statusMessage == LOGIN_USER_EXIST_CHECK) {
                                logIn.postValue(true)
                            } else {
                                val user = User(
                                    it.data.id,
                                    it.data.name,
                                    it.data.email,
                                    it.data.token,
                                    it.data.profileImg
                                )

                            }
                        },
                        {
                            Timber.tag("Login").d(it)
                            handleNetworkError(it)
                            //   loggingIn.postValue(false)
                            //   launchSignup.value
                        }
                    )
            )
        }
    }

}