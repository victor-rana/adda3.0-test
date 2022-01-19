package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse
import com.google.gson.annotations.SerializedName


data class LikeRes(
    @SerializedName("data") var data: Data,
    @SerializedName("statusCode")
    var statusCode: Int,
    @SerializedName("statusMessage")
    var statusMessage: String)
{
    class Data(
        @SerializedName("commentId")
        var commentId: Any,
        @SerializedName("createdBy")
        var createdBy: String,
        @SerializedName("creationTime")
        var creationTime: String,
        @SerializedName("id")
        var id: String,
        @SerializedName("postId")
        var postId: String,
        @SerializedName("source")
        var source: String,
        @SerializedName("status")
        var status: String,
        @SerializedName("type")
        var type: String,
        @SerializedName("updatingTime")
        var updatingTime: String
    )
}