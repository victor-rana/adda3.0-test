package women.fashion.compare.clothes.shop.womenshopping.offers.data.repository


import io.reactivex.Single
import women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.DatabaseService
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.Dummy
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.NetworkService
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.DummyRequest
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    fun fetchDummy(id: String): Single<List<Dummy>> =
        networkService.doDummyCall(DummyRequest(id)).map { it.data }

}