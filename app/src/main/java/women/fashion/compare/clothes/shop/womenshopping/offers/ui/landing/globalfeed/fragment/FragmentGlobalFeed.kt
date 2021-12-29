package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.fragment

import android.view.View
import androidx.lifecycle.Observer
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.FragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.viewmodel.GlobalFeedViewModel

class FragmentGlobalFeed: BaseFragment<GlobalFeedViewModel>() {
    override fun provideLayoutId(): Int {
        return R.layout.fragment_global_feed
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {
        viewModel.fetchGlobalFeed()
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.feedList.observe(this, Observer {

        })
    }
}