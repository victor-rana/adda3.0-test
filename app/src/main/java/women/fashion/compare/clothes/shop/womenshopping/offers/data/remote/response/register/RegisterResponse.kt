package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("statusCode") var statusCode : Int,
    @SerializedName("statusMessage") var statusMessage : String,
    @SerializedName("data") var data : Data

)
