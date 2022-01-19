package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("post"     ) var post     : Post?               = Post(),
    @SerializedName("comments" ) var comments : ArrayList<Comments> = arrayListOf(),
    @SerializedName("likes"    ) var likes    : ArrayList<Likes>    = arrayListOf()
)
