package women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations


import io.reactivex.disposables.CompositeDisposable
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.Dummy
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseItemViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Resource
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.log.Logger
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider
import javax.inject.Inject

class DummyItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<Dummy>(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "DummyItemViewModel"
    }

    val name: LiveData<String> = Transformations.map(data) { it.name }
    val url: LiveData<String?> = Transformations.map(data) { it.imageUrl }

    fun onItemClick(position: Int) {
        messageString.postValue(Resource.success("onItemClick at $position of ${data.value?.name}"))
        Logger.d(TAG, "onItemClick at $position")
    }

    override fun onCreate() {
        Logger.d(TAG, "onCreate called")
    }
}