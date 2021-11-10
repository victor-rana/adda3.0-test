package women.fashion.compare.clothes.shop.womenshopping.offers.di.component

import dagger.Component
import women.fashion.compare.clothes.shop.womenshopping.offers.di.ActivityScope
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.ActivityModule
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummy.DummyActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.splash.SplashActivity

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: SplashActivity)

    fun inject(activity: LoginActivity)

    fun inject(activity: DummyActivity)


}