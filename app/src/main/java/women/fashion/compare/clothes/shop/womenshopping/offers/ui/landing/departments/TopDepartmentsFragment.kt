package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.departments

import android.view.View
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.FragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.viewmodel.ProfileViewModel

class TopDepartmentsFragment: BaseFragment<ProfileViewModel>() {
    override fun provideLayoutId(): Int {
        return R.layout.fragment_profile
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {

    }
}