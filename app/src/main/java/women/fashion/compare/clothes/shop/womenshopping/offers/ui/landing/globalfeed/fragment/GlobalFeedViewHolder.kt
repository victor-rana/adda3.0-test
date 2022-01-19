package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.fragment

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseViewHolder

class GlobalFeedViewHolder(itemView: View) : BaseViewHolder(itemView) {

    val rivUserImage : RoundedImageView = itemView.findViewById(R.id.rivUserImage)
    val tvUserName : AppCompatTextView = itemView.findViewById(R.id.tvUserName)
    val tvPlace : AppCompatTextView = itemView.findViewById(R.id.tvPlace)
    val ivLike : AppCompatImageView = itemView.findViewById(R.id.ivLike)
    val ivComment : AppCompatImageView = itemView.findViewById(R.id.ivComment)
    val ivShare : AppCompatImageView = itemView.findViewById(R.id.ivShare)
    val tvDescription : AppCompatTextView = itemView.findViewById(R.id.tvDescription)
    val tvTime : AppCompatTextView = itemView.findViewById(R.id.tvTime)
    val rcTags : RecyclerView = itemView.findViewById(R.id.rcTags)

}