package women.fashion.compare.clothes.shop.womenshopping.offers.di.module

import androidx.lifecycle.LifecycleRegistry
import dagger.Module
import dagger.Provides
import women.fashion.compare.clothes.shop.womenshopping.offers.di.ViewModelScope
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseItemViewHolder

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}