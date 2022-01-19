package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.fragment

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_global_feed.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse.Data
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.FragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.GlobalFeedAdapterClick
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.adpter.GlobalFeedAdapter
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.adpter.GlobalFeedAdapter.Companion.LIKE
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.adpter.GlobalFeedAdapter.Companion.UNLIKE
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.viewmodel.GlobalFeedViewModel
import java.util.*

class GlobalFeedFragment : BaseFragment<GlobalFeedViewModel>() , GlobalFeedAdapterClick{

    lateinit var userTimeLineList: List<Data>

    override fun provideLayoutId(): Int {
        return R.layout.fragment_global_feed
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {
        showLoader()
        viewModel.fetchGlobalFeed()
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.userTimeLine.observe(this, Observer {
            userTimeLineList = it
            setUserTimeLineAdapter()
        })


        viewModel.loader.observe(this, Observer {
            hideLoader()
        })
    }


    private fun setUserTimeLineAdapter() {
        rc_user_timeline.layoutManager = LinearLayoutManager(requireContext())
        val adapter = GlobalFeedAdapter(userTimeLineList, this)
        rc_user_timeline.adapter = adapter

    }

    override fun onItemCLick(type: Int, pos: Int, status: Boolean, objects: Any) {
       if(type == LIKE){
           showLoader()
           viewModel.setGlobalFeedLikeRequest(objects as Data)
           viewModel.likePost()
       } else if(type == UNLIKE){
           showLoader()
           viewModel.setGlobalFeedLikeRequest(objects as Data)
           viewModel.unlikePost()
       }
    }
}
