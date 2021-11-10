package women.fashion.compare.clothes.shop.womenshopping.offers.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.mindorks.paracamera.Camera
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.DummyRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies.DummiesAdapter
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies.DummiesViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.ViewModelProviderFactory
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun provideDummiesViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        dummyRepository: DummyRepository
    ): DummiesViewModel =
        ViewModelProviders.of(fragment,
            ViewModelProviderFactory(DummiesViewModel::class) {
                DummiesViewModel(schedulerProvider, compositeDisposable, networkHelper, dummyRepository)
            }
        ).get(DummiesViewModel::class.java)

    @Provides
    fun provideDummiesAdapter() = DummiesAdapter(fragment.lifecycle, ArrayList())



    @Provides
    fun provideCamera() = Camera.Builder()
        .resetToCorrectOrientation(true)// it will rotate the camera bitmap to the correct orientation from meta data
        .setTakePhotoRequestCode(1)
        .setDirectory("temp")
        .setName("camera_temp_img")
        .setImageFormat(Camera.IMAGE_JPEG)
        .setCompression(75)
        .setImageHeight(500)// it will try to achieve this height as close as possible maintaining the aspect ratio;
        .build(fragment)




}