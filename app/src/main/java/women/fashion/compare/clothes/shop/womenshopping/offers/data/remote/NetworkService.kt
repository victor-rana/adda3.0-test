package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote



import io.reactivex.Single
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
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.login.LoginResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.register.RegisterResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedrequest.LikeReq
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse.GlobalFeedResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse.LikeRes
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @POST(Endpoints.REGISTER)
    fun doRegisterCall(@Body request: RegisterRequest ): Single<RegisterResponse>


    @POST(Endpoints.LOGIN)
    fun doLoginCall(@Body request: LoginRequest, ): Single<LoginResponse>


    @GET(Endpoints.USER_TIMELINE)
    fun fetchGlobalFeed(): Single<GlobalFeedResponse>

    @POST(Endpoints.LIKE_POST)
    fun likePost(@Body likeReq: LikeReq): Single<LikeRes>

    @POST(Endpoints.UNLIKE_POST)
    fun unlikePost(likeReq: LikeReq): Single<LikeRes>

    @POST(DUMMY)
    fun doDummyCall(
        @Body request: DummyRequest,
        @Header(HEADER_API_KEY) apiKey: String = API_KEY): Single<DummyResponse>

}