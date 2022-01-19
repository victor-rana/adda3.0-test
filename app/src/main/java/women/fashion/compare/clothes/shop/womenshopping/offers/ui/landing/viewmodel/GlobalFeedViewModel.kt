package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse.Data
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse.GlobalFeedResponse
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.GlobalFeedRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedrequest.LikeReq
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.globalfeed.globalfeedmodel.globalfeedresponse.LikeRes
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider

class GlobalFeedViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val globalFeedRepository: GlobalFeedRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    var userTimeLine: MutableLiveData<List<Data>> = MutableLiveData()
    var feedLike: MutableLiveData<Data> = MutableLiveData()

    override fun onCreate() {
    }

    fun fetchGlobalFeed() {
        if(checkInternetConnectionWithMessage()) {
            compositeDisposable.addAll( globalFeedRepository.getGlobalFeed()
                .toObservable()
                .firstOrError()
                .subscribeOn(schedulerProvider.io())
                .subscribeWith(object : DisposableSingleObserver<GlobalFeedResponse?>(){
                    override fun onSuccess(t: GlobalFeedResponse) {
                        if(t.statusCode == 200) {
                            userTimeLine.postValue(t.data)
                        } else{

                        }
                        loader.postValue(true)
                    }


                    override fun onError(e: Throwable) {

                        Log.d("TAG", "onError: "+e.printStackTrace())
                        handleNetworkError(e)
                        loader.postValue(true)
                    }

                }

                )
            )
        }
    }

    fun setGlobalFeedLikeRequest(data: Data){
        feedLike = MutableLiveData(data)
    }

    fun getGlobalLikeRequest(): LikeReq{
       var data: Data? = feedLike.value as Data
       return LikeReq("", data?.post?.createdBy, data?.post?.id, "POST", data?.post?.status)
    }

    fun likePost() {
        if(checkInternetConnectionWithMessage()) {
            compositeDisposable.addAll( globalFeedRepository.likePost(getGlobalLikeRequest())
                .toObservable()
                .firstOrError()
                .subscribeOn(schedulerProvider.io())
                .subscribeWith(object : DisposableSingleObserver<LikeRes?>(){
                    override fun onSuccess(t: LikeRes) {
                        if(t.statusCode == 200) {


                        } else{

                        }
                        loader.postValue(true)
                    }


                    override fun onError(e: Throwable) {

                        Log.d("TAG", "onError: "+e.printStackTrace())
                        handleNetworkError(e)
                        loader.postValue(true)
                    }

                }

                )
            )
        }
    }

    fun unlikePost() {
        if(checkInternetConnectionWithMessage()) {
            compositeDisposable.addAll( globalFeedRepository.unLikePost(getGlobalLikeRequest())
                .toObservable()
                .firstOrError()
                .subscribeOn(schedulerProvider.io())
                .subscribeWith(object : DisposableSingleObserver<LikeRes?>(){
                    override fun onSuccess(t: LikeRes) {
                        if(t.statusCode == 200) {
                           // userTimeLine.postValue(t.data)
                        } else{

                        }
                        loader.postValue(true)
                    }


                    override fun onError(e: Throwable) {

                        Log.d("TAG", "onError: "+e.printStackTrace())
                        handleNetworkError(e)
                        loader.postValue(true)
                    }

                }

                )
            )
        }
    }
}