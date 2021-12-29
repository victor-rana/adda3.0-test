package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.globalfeed

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id"           ) var id           : String?            = null,
    @SerializedName("createdBy"    ) var createdBy    : String?            = null,
    @SerializedName("subject"      ) var subject      : String?            = null,
    @SerializedName("description"  ) var description  : String?            = null,
    @SerializedName("postEntities" ) var postEntities : List<PostEntities> = arrayListOf(),
    @SerializedName("hashtags"     ) var hashtags     : List<String>       = arrayListOf(),
    @SerializedName("isPrivate"    ) var isPrivate    : Boolean?           = null,
    @SerializedName("isApproved"   ) var isApproved   : Boolean?           = null,
    @SerializedName("creationTime" ) var creationTime : String?            = null,
    @SerializedName("platformId"   ) var platformId   : String?            = null,
    @SerializedName("updatingTime" ) var updatingTime : String?            = null,
    @SerializedName("status"       ) var status       : String?            = null
)
