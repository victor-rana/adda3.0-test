package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("statusCode") var statusCode : Int,
    @SerializedName("statusMessage") var statusMessage : String,
    @SerializedName("data") var data : Data

)