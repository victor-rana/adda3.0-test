package women.fashion.compare.clothes.shop.womenshopping.offers.di.component


import dagger.Component
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.offers.OffersFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.di.FragmentScope
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.FragmentModule
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.introfragment.IntroSliderFour
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.introfragment.IntroSliderOne
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.introfragment.IntroSliderThree
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies.DummiesFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.cart.CartFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.FragmentAddPhoto
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.fragment.GlobalFeedFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.home.HomeFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.departments.TopDepartmentsFragment
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

    fun inject(fragment: HomeFragment)

    fun inject(fragment: FragmentAddPhoto)

    fun inject(fragment: TopDepartmentsFragment)

    fun inject(fragment: GlobalFeedFragment)

    fun inject(fragment: IntroSliderOne)

    fun inject(fragment: IntroSliderThree)

    fun inject(fragment: IntroSliderFour)

    fun inject(fragment: CartFragment)

    fun inject(fragment: OffersFragment)


}