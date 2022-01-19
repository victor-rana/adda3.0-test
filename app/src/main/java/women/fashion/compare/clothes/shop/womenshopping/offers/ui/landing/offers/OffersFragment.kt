package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.offers

import android.os.Bundle
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.offers.OffersFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.FragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.viewmodel.GlobalFeedViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [OffersFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class OffersFragment :  BaseFragment<GlobalFeedViewModel>() {
    override fun provideLayoutId(): Int {
        return R.layout.fragment_offers
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {

    }

    override fun setupObservers() {
        super.setupObservers()

    }
}