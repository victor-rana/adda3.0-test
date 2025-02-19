package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @Expose
    @SerializedName("email")
    var email: String,

    @Expose
    @SerializedName("password")
    var password: String?,

    @Expose
    @SerializedName("googleToken")
    var googleToken: String?,

    @Expose
    @SerializedName("facebookToken")
    var fbToken: String?
)