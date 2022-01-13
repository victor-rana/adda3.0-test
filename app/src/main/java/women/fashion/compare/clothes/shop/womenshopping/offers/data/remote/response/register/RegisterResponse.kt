package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("statusCode") var statusCode : Int,
    @SerializedName("statusMessage") var statusMessage : String,
    @SerializedName("data") var data : Data


)
data class Data(
    @SerializedName("id") var id : String,
    @SerializedName("name") var name : String,
    @SerializedName("email") var email : String,
    @SerializedName("gender") var gender : String,
    @SerializedName("address") var address : List<Address>,
    @SerializedName("password") var password : String,
    @SerializedName("profileImg") var profileImg : String,
    @SerializedName("coverImg") var coverImg : String,
    @SerializedName("prestigeLevel") var prestigeLevel : String,
    @SerializedName("enrollmentDate") var enrollmentDate : String,
    @SerializedName("connections") var connections : String,
    @SerializedName("isProfilePublic") var isProfilePublic : Boolean,
    @SerializedName("mobile") var mobile : String,
    @SerializedName("dateOfBirth") var dateOfBirth : String,
    @SerializedName("isEmailVerified") var isEmailVerified : Boolean,
    @SerializedName("isMobileVerified") var isMobileVerified : Boolean,
    @SerializedName("isWalletActive") var isWalletActive : Boolean,
    @SerializedName("status") var status : String )


data class Address(
    @SerializedName("addressAlias") var addressAlias : String,
    @SerializedName("houseNo") var houseNo : String,
    @SerializedName("street") var street : String,
    @SerializedName("landmark") var landmark : String,
    @SerializedName("city") var city : String,
    @SerializedName("state") var state : String,
    @SerializedName("pincode") var pincode : String
)