package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse

import com.google.gson.annotations.SerializedName

data class PostEntities(
    @SerializedName("imageUrl"          ) var imageUrl          : String?      = null,
    @SerializedName("taggedProductUrl"  ) var taggedProductUrl  : String?      = null,
    @SerializedName("taggedProductName" ) var taggedProductName : String?      = null,
    @SerializedName("taggedProductDesc" ) var taggedProductDesc : String?      = null,
    @SerializedName("taggedUsers"       ) var taggedUsers       : List<String> = arrayListOf()
)
