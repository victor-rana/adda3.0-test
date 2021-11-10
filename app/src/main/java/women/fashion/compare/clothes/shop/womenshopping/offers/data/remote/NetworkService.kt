package women.fashion.compare.clothes.shop.womenshopping.offers.data.remote



import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Endpoints.DUMMY
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking.API_KEY
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking.HEADER_API_KEY
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.DummyRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.LoginRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.DummyResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.LoginResponse
import javax.inject.Singleton

@Singleton
interface NetworkService {


    @POST(DUMMY)
    fun doDummyCall(
        @Body request: DummyRequest,
        @Header(HEADER_API_KEY) apiKey: String = API_KEY // default value set when Networking create is called
    ): Single<DummyResponse>

    @POST(Endpoints.LOGIN)
    fun doLoginCall(
        @Body request: LoginRequest,
        @Header(HEADER_API_KEY) apiKey: String = API_KEY
    ): Single<LoginResponse>





}