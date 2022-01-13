package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.register

import com.google.gson.annotations.SerializedName

data class RegisterRequest(

    @SerializedName("name") var name: String,
    @SerializedName("gender") var gender: String,
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String,
    @SerializedName("dateOfBirth") var dateOfBirth: String,
    @SerializedName("mobile") var mobile: String,

//    @SerializedName("address") var address: List<AddressRequest>,
//    @SerializedName("profileImg") var profileImg: String,
//    @SerializedName("coverImg") var coverImg: String,
//    @SerializedName("prestigeLevel") var prestigeLevel: String,
//    @SerializedName("isProfilePublic") var isProfilePublic: String,
//    @SerializedName("isEmailVerified") var isEmailVerified: Boolean,
//    @SerializedName("isMobileVerified") var isMobileVerified: Boolean,
//    @SerializedName("isWalletActive") var isWalletActive: Boolean,
//    @SerializedName("status") var status: String
)
