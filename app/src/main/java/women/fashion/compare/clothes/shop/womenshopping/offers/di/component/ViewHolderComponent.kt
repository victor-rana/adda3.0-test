package women.fashion.compare.clothes.shop.womenshopping.offers.di.component


import dagger.Component
import women.fashion.compare.clothes.shop.womenshopping.offers.di.ViewModelScope
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.ViewHolderModule
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies.DummyItemViewHolder

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: DummyItemViewHolder)


}