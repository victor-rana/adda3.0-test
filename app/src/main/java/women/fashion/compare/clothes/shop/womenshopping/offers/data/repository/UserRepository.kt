package women.fashion.compare.clothes.shop.womenshopping.offers.data.repository


import io.reactivex.Single
import women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.DatabaseService
import women.fashion.compare.clothes.shop.womenshopping.offers.data.local.prefs.UserPreferences
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.User
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.NetworkService
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.LoginRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.register.RegisterRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.login.Data
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

    fun saveCurrentUser(user: User) {
        userPreferences.setUserId(user.id)
        userPreferences.setUserName(user.name)
        userPreferences.setUserEmail(user.email)
        userPreferences.setAccessToken(user.accessToken)
    }

    fun removeCurrentUser() {
        userPreferences.removeUserId()
        userPreferences.removeUserName()
        userPreferences.removeUserEmail()
        userPreferences.removeAccessToken()
    }

    fun getCurrentUser(): User? {

        val userId = userPreferences.getUserId()
        val userName = userPreferences.getUserName()
        val userEmail = userPreferences.getUserEmail()
        val accessToken = userPreferences.getAccessToken()

        return if (userId !== null && userName != null && userEmail != null && accessToken != null)
            User(
                userId,
                userName,
                userEmail,
                accessToken
            )
        else
            null
    }

    fun doUserLogin(email: String, password: String?, googleToken: String?, fbToken: String?): Single<LoginResponse> =
        networkService.doLoginCall(LoginRequest(email, password, googleToken, fbToken))
            .map {
                it
            }

    fun doUserRegister(registerRequest: RegisterRequest): Single<RegisterResponse> =
        networkService.doRegisterCall(registerRequest)
            .map {
                it
            }

}