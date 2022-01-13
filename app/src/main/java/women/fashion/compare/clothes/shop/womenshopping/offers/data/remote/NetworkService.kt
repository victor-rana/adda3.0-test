package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote



import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Endpoints.DUMMY
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking.API_KEY
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking.HEADER_API_KEY
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.DummyRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.LoginRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.register.RegisterRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.DummyResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.globalfeed.GlobalFeedResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.login.LoginResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.RegisterResponse
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @POST(Endpoints.REGISTER)
    fun doRegisterCall(@Body request: RegisterRequest ): Single<RegisterResponse>


    @POST(Endpoints.LOGIN)
    fun doLoginCall(@Body request: LoginRequest, ): Single<LoginResponse>


    @GET(Endpoints.GLOBAL_FEED)
    fun fetchGlobalFeed(): Single<GlobalFeedResponse>

    @POST(DUMMY)
    fun doDummyCall(
        @Body request: DummyRequest,
        @Header(HEADER_API_KEY) apiKey: String = API_KEY): Single<DummyResponse>

}