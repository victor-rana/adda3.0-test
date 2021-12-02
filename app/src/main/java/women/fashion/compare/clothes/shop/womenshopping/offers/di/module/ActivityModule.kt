package women.fashion.compare.clothes.shop.womenshopping.offers.di.module
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager


import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.DummyRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.UserRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummy.DummyViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.LandingViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel.FragmentSignupFirstViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel.FragmentSignupSecondViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel.RegisterViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.splash.SplashViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.ViewModelProviderFactory
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository)
            //this lambda creates and return SplashViewModel
        }).get(SplashViewModel::class.java)

    @Provides
    fun provideDummyViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        dummyRepository: DummyRepository
    ): DummyViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(DummyViewModel::class) {
            DummyViewModel(schedulerProvider, compositeDisposable, networkHelper, dummyRepository)
        }).get(DummyViewModel::class.java)


    @Provides
    fun provideLoginViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository
    ): LoginViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(LoginViewModel::class) {
            LoginViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository)
        }).get(LoginViewModel::class.java)

    @Provides
    fun provideRegisterViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository
    ): RegisterViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(RegisterViewModel::class) {
            RegisterViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository)
        }).get(RegisterViewModel::class.java)

    @Provides
    fun provideLandingViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository
    ): LandingViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(LandingViewModel::class) {
            LandingViewModel(schedulerProvider, compositeDisposable, networkHelper, userRepository)
        }).get(LandingViewModel::class.java)


}