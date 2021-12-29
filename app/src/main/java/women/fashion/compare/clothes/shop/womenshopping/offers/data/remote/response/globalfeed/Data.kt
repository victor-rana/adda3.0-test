package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.globalfeed

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("post"     ) var post     : Post?        = Post(),
    @SerializedName("comments" ) var comments : List<String> = arrayListOf(),
    @SerializedName("likes"    ) var likes    : List<String> = arrayListOf()
)
