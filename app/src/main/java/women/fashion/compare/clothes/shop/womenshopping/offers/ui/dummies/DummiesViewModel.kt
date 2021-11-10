package women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations


import io.reactivex.disposables.CompositeDisposable
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.Dummy
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.DummyRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Resource
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Status
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider


class DummiesViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val dummyRepository: DummyRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val dummyLiveData: MutableLiveData<Resource<List<Dummy>>> = MutableLiveData()

    fun getDummies(): LiveData<List<Dummy>> =
        Transformations.map(dummyLiveData) { it.data }

    fun isDummiesFetching(): LiveData<Boolean> =
        Transformations.map(dummyLiveData) { it.status == Status.LOADING }

    override fun onCreate() {
        if (dummyLiveData.value == null && checkInternetConnectionWithMessage()) {
            dummyLiveData.postValue(Resource.loading())
            compositeDisposable.add(
                dummyRepository.fetchDummy("MY_SAMPLE_DUMMY")
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        { dummyLiveData.postValue(Resource.success(it)) },
                        {
                            handleNetworkError(it)
                            dummyLiveData.postValue(Resource.error())
                        })
            )
        }
    }
}