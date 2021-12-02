package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.login

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id") var id : String,
    @SerializedName("name") var name : String,
    @SerializedName("email") var email : String,
    @SerializedName("mobile") var mobile : String,
    @SerializedName("gender") var gender : String,
    @SerializedName("address") var address : List<Address>,
    @SerializedName("profileImg") var profileImg : String,
    @SerializedName("coverImg") var coverImg : String,
    @SerializedName("prestigeLevel") var prestigeLevel : String,
    @SerializedName("enrollmentDate") var enrollmentDate : String,
    @SerializedName("connections") var connections : String,
    @SerializedName("isProfilePublic") var isProfilePublic : Boolean,
    @SerializedName("dateOfBirth") var dateOfBirth : String,
    @SerializedName("isEmailVerified") var isEmailVerified : Boolean,
    @SerializedName("isMobileVerified") var isMobileVerified : Boolean,
    @SerializedName("isWalletActive") var isWalletActive : Boolean,
    @SerializedName("status") var status : String,
    @SerializedName("token") var token : String
)
