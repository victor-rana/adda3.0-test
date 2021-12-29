package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.viewmodel

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.response.globalfeed.Data
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.GlobalFeedRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.UserRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider

class GlobalFeedViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val globalFeedRepository: GlobalFeedRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val feedList: MutableLiveData<List<Data>> = MutableLiveData()

    override fun onCreate() {
    }

    fun fetchGlobalFeed() {
        globalFeedRepository.getGlobalFeed()
            .subscribeOn(schedulerProvider.io())
            .subscribe({
                       feedList.postValue(it.data)
            },
                {
                    Timber.tag("Login").d(it)
                    handleNetworkError(it)
                })
    }
}