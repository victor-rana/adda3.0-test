package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedrequest
import com.google.gson.annotations.SerializedName


class LikeReq(
    @SerializedName("commentId")
    var commentId: String?,
    @SerializedName("createdBy")
    var createdBy: String?,
    @SerializedName("postId")
    var postId: String?,
    @SerializedName("source")
    var source: String?,
    @SerializedName("status")
    var status: String?
)