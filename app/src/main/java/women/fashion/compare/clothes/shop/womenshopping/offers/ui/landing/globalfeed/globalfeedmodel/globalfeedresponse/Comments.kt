package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse

import com.google.gson.annotations.SerializedName

data class Comments(
    @SerializedName("id"           ) var id           : String? = null,
    @SerializedName("postId"       ) var postId       : String? = null,
    @SerializedName("createdBy"    ) var createdBy    : String? = null,
    @SerializedName("description"  ) var description  : String? = null,
    @SerializedName("creationTime" ) var creationTime : String? = null,
    @SerializedName("updatingTime" ) var updatingTime : String? = null,
    @SerializedName("status"       ) var status       : String? = null,
    @SerializedName("likes"        ) var likes        : String? = null
)
