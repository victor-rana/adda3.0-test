package women.fashion.compare.clothes.shop.womenshopping.offers.di.component


import dagger.Component
import women.fashion.compare.clothes.shop.womenshopping.offers.di.FragmentScope
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.FragmentModule
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies.DummiesFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.FragmentAddPhoto
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.fragment.FragmentGlobalFeed
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.home.FragmentHome
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.profile.FragmentProfile
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.FragmentSignupFirst
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.FragmentSignupSecond

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: DummiesFragment)

    fun inject(fragment: FragmentSignupFirst)

    fun inject(fragment: FragmentSignupSecond)

    fun inject(fragment: FragmentHome)

    fun inject(fragment: FragmentAddPhoto)

    fun inject(fragment: FragmentProfile)

    fun inject(fragment: FragmentGlobalFeed)


}