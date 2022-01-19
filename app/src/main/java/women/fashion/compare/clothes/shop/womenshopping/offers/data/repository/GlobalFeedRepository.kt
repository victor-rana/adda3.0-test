package women.fashion.compare.clothes.shop.womenshopping.offers.data.repository

import io.reactivex.Single
import women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.DatabaseService
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.NetworkService
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedrequest.LikeReq
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse.GlobalFeedResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse.LikeRes
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalFeedRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService, ) {


    fun getGlobalFeed(): Single<GlobalFeedResponse> =
        networkService.fetchGlobalFeed()

    fun likePost(likeReq: LikeReq): Single<LikeRes> =
        networkService.likePost(likeReq)


    fun unLikePost(likeReq: LikeReq): Single<LikeRes> =
        networkService.unlikePost(likeReq)
}