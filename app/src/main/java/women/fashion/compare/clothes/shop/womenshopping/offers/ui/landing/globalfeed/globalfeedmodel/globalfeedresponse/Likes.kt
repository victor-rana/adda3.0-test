package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse

import com.google.gson.annotations.SerializedName

data class Likes(
    @SerializedName("id") var id: String? = null,
    @SerializedName("postId") var postId: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("source") var source: String? = null,
    @SerializedName("commentId") var commentId: String? = null,
    @SerializedName("createdBy") var createdBy: String? = null,
    @SerializedName("creationTime") var creationTime: String? = null,
    @SerializedName("updatingTime") var updatingTime: String? = null,
    @SerializedName("status") var status: String? = null
)
