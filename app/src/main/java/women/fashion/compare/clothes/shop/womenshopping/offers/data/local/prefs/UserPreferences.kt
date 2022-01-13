package women.fashion.compare.clothes.shop.womenshopping.offers.data.local.prefs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferences @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val KEY_USER_ID = "PREF_KEY_USER_ID"
        const val KEY_USER_NAME = "PREF_KEY_USER_NAME"
        const val KEY_USER_EMAIL = "PREF_KEY_USER_EMAIL"
        const val KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        const val KEY_MOBILE = "PREF_KEY_MOBILE"
        const val KEY_GENDER = "PREF_KEY_GENDER"
        const val KEY_ADDRESS = "PREF_KEY_ADDRESS"
        const val KEY_IMAGE = "PREF_KEY_IMAGE"
        const val KEY_PRESTIGE_LEVEL = "PREF_KEY_PRESTIGE_LEVEL"
        const val KEY_DOB = "PREF_KEY_DOB"
        const val KEY_IS_EMAIL_VERIFIED = "PREF_KEY_EMAIL_VERIFIED"
        const val KEY_IS_MOBILE_VERIFIED = "PREF_KEY_MOBILE_VERIFIED"
        const val KEY_IS_WALLET_ACTIVE = "PREF_KEY_WALLET_ACTIVE"
        const val KEY_STATUS = "PREF_KEY_STATUS"
        const val KEY_ENROLLMENT_DATE = "PREF_KEY_ENROLLMENT_DATE"
        const val KEY_IS_PROFILE_PUBLIC = "PREF_KEY_IS_PROFILE_PUBLIC"
    }

    fun getUserId(): String? =
        prefs.getString(KEY_USER_ID, null)

    fun setUserId(userId: String) =
        prefs.edit().putString(KEY_USER_ID, userId).apply()

    fun removeUserId() =
        prefs.edit().remove(KEY_USER_ID).apply()

    fun getUserName(): String? =
        prefs.getString(KEY_USER_NAME, null)

    fun setUserName(userName: String) =
        prefs.edit().putString(KEY_USER_NAME, userName).apply()

    fun removeUserName() =
        prefs.edit().remove(KEY_USER_NAME).apply()

    fun getUserEmail(): String? =
        prefs.getString(KEY_USER_EMAIL, null)

    fun setUserEmail(email: String) =
        prefs.edit().putString(KEY_USER_EMAIL, email).apply()

    fun removeUserEmail() =
        prefs.edit().remove(KEY_USER_EMAIL).apply()

    fun getAccessToken(): String? =
        prefs.getString(KEY_ACCESS_TOKEN, null)

    fun setAccessToken(token: String) =
        prefs.edit().putString(KEY_ACCESS_TOKEN, token).apply()

    fun removeAccessToken() =
        prefs.edit().remove(KEY_ACCESS_TOKEN).apply()



    fun setString( key :String, value : String?){
        prefs.edit().putString(key, value).apply()
    }
    fun getString( key :String): String?{
         return prefs.getString(key, "")
    }
    fun removeString( key :String){
        prefs.edit().remove(key).apply()
    }

    fun setBoolean( key :String, value : Boolean){
        prefs.edit().putBoolean(key, value).apply()
    }
    fun getBoolean( key :String) : Boolean{
        return prefs.getBoolean(key,false)
    }

    fun setInt( key :String, value : Int){
        prefs.edit().putInt(key, value).apply()
    }
    fun getInt( key :String): Int?{
        return prefs.getInt(key,0)
    }

}