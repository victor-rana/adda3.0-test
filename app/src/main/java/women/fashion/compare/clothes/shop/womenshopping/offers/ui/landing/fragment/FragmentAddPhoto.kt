package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.fragment

import android.view.View
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.FragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.viewmodel.AddPhotoViewModel

class FragmentAddPhoto: BaseFragment<AddPhotoViewModel>() {
    override fun provideLayoutId(): Int {
        return R.layout.fragment_photo
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
       fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {

    }
}