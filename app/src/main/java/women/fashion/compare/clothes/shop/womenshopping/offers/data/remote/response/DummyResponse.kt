package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DummyResponse(
    @Expose
    @SerializedName("statusCode")
    var statusCode: String,

    @Expose
    @SerializedName("message")
    var message: String,

    @Expose
    @SerializedName("data")
    val data: List<women.fashion.compare.clothes.shop.womenshopping.offers.data.model.Dummy>
)