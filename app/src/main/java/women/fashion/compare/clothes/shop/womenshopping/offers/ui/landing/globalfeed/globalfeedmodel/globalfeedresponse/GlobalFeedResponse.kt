package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse

import com.google.gson.annotations.SerializedName

data class GlobalFeedResponse(
    @SerializedName("statusCode"    ) var statusCode    : Int?       = null,
    @SerializedName("statusMessage" ) var statusMessage : String?    = null,
    @SerializedName("data"          ) var data          : List<Data> = arrayListOf()

)
