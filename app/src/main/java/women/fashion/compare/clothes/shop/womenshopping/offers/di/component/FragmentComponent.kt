package women.fashion.compare.clothes.shop.womenshopping.offers.di.component


import dagger.Component
import women.fashion.compare.clothes.shop.womenshopping.offers.di.FragmentScope
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.FragmentModule
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies.DummiesFragment

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: DummiesFragment)


}