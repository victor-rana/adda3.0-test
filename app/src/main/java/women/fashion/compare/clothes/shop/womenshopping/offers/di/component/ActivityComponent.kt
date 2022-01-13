package women.fashion.compare.clothes.shop.womenshopping.offers.di.component

import dagger.Component
import women.fashion.compare.clothes.shop.womenshopping.offers.di.ActivityScope
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.ActivityModule
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.AppTourActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummy.DummyActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.LandingActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.loginsignup.LoginSignupActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.RegisterFirstActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.RegisterSecondActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.splash.SplashActivity

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class], modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: SplashActivity)

    fun inject(activity: LoginActivity)

    fun inject(activity: RegisterFirstActivity)

    fun inject(activity: LandingActivity)

    fun inject(activity: DummyActivity)

    fun inject(activity: LoginSignupActivity)

    fun inject(activity: RegisterSecondActivity)

    fun inject(activity: AppTourActivity)


}