package women.fashion.compare.clothes.shop.womenshopping.offers.data.repository

import io.reactivex.Single
import women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.DatabaseService
import women.fashion.compare.clothes.shop.womenshopping.offers.data.local.prefs.UserPreferences
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.NetworkService
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.LoginRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.register.RegisterRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.login.LoginResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.RegisterResponse
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService,
    private val userPreferences: UserPreferences
) {

    fun saveCurrentUser(user: LoginResponse.Data) {
        userPreferences.setString(UserPreferences.KEY_USER_ID, user.id)
        userPreferences.setString(UserPreferences.KEY_USER_NAME, user.name)
        userPreferences.setString(UserPreferences.KEY_USER_EMAIL, user.email)
        userPreferences.setString(UserPreferences.KEY_ACCESS_TOKEN, user.token)
        userPreferences.setString(UserPreferences.KEY_IMAGE, user.profileImg)
        userPreferences.setString(UserPreferences.KEY_GENDER, user.gender)
        userPreferences.setString(UserPreferences.KEY_DOB, user.dateOfBirth)
        userPreferences.setString(UserPreferences.KEY_ENROLLMENT_DATE, user.enrollmentDate)
        userPreferences.setString(UserPreferences.KEY_MOBILE, user.mobile)
        userPreferences.setString(UserPreferences.KEY_PRESTIGE_LEVEL, user.prestigeLevel)
        userPreferences.setString(UserPreferences.KEY_STATUS, user.status)
        userPreferences.setString(UserPreferences.KEY_ADDRESS, "")
        userPreferences.setBoolean(UserPreferences.KEY_IS_EMAIL_VERIFIED, user.isEmailVerified)
        userPreferences.setBoolean(UserPreferences.KEY_IS_MOBILE_VERIFIED, user.isMobileVerified)
        userPreferences.setBoolean(UserPreferences.KEY_IS_WALLET_ACTIVE, user.isWalletActive)
        userPreferences.setBoolean(UserPreferences.KEY_IS_PROFILE_PUBLIC, user.isProfilePublic)
    }

    fun removeCurrentUser() {
        userPreferences.removeString(UserPreferences.KEY_USER_ID)
        userPreferences.removeString(UserPreferences.KEY_USER_NAME)
        userPreferences.removeString(UserPreferences.KEY_USER_EMAIL)
        userPreferences.removeString(UserPreferences.KEY_ACCESS_TOKEN)
    }

    fun getCurrentUser(): String? {

        return userPreferences.getString(UserPreferences.KEY_ACCESS_TOKEN)


    }

    fun doUserLogin(email: String, password: String?, googleToken: String?, fbToken: String?): Single<LoginResponse> =
        networkService.doLoginCall(LoginRequest(email, password, googleToken, fbToken))
            .map {
                it
            }

    fun doUserRegister(registerRequest: RegisterRequest): Single<RegisterResponse> {
        return networkService.doRegisterCall(registerRequest).map { it }
    }

}