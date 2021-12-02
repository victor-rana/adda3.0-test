package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.login

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("addressAlias") var addressAlias : String,
    @SerializedName("houseNo") var houseNo : String,
    @SerializedName("street") var street : String,
    @SerializedName("landmark") var landmark : String,
    @SerializedName("city") var city : String,
    @SerializedName("state") var state : String,
    @SerializedName("pincode") var pincode : String
)
