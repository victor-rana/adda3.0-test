package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.GlobalFeedAdapterClick
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse.Data
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.fragment.GlobalFeedViewHolder
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.viewmodel.GlobalFeedViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.splash.SplashViewModel
import javax.inject.Inject

class GlobalFeedAdapter(var dataList: List<Data>, private var globalFeedAdapterClick: GlobalFeedAdapterClick) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val LIKE : Int = 1
        const val UNLIKE : Int = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.inflate_user_timeline, parent, false)
        return GlobalFeedViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val globalViewHolder : GlobalFeedViewHolder = holder as GlobalFeedViewHolder
        val data : Data = dataList.get(position)

        globalViewHolder.tvUserName.text = data.post?.createdBy
        globalViewHolder.tvPlace.text = data.post?.subject
        globalViewHolder.tvDescription.text = data.post?.description
        globalViewHolder.tvTime.text = data.post?.updatingTime

        globalViewHolder.ivComment.setOnClickListener{
            globalFeedAdapterClick.onItemCLick(LIKE, position,false, data)
        }
        globalViewHolder.ivLike.setOnClickListener{
            globalFeedAdapterClick.onItemCLick(UNLIKE, position,false, data)
        }
        globalViewHolder.ivShare.setOnClickListener {
            globalFeedAdapterClick.onItemCLick(0, position,false, data)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


}