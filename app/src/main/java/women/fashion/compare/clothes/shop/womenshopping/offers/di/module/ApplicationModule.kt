package women.fashion.compare.clothes.shop.womenshopping.offers.di.module
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import women.fashion.compare.clothes.shop.womenshopping.offers.BuildConfig
import women.fashion.compare.clothes.shop.womenshopping.offers.MainApplication
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.NetworkService
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.Networking
import women.fashion.compare.clothes.shop.womenshopping.offers.di.ApplicationContext
import women.fashion.compare.clothes.shop.womenshopping.offers.di.TempDirectory
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.FileUtils
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.RxSchedulerProvider
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MainApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext

    fun provideContext(): Context = application

    @Provides
    @Singleton
    @TempDirectory
    fun provideTempDirectory() = FileUtils.getDirectory(application, "temp")

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
        application.getSharedPreferences("bootcamp-instagram-project-prefs", Context.MODE_PRIVATE)

    /**
     * We need to write @Singleton on the provide method if we are create the instance inside this method
     * to make it singleton. Even if we have written @Singleton on the instance's class
     */
    @Provides
    @Singleton
    fun provideDatabaseService(): women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.DatabaseService =
        Room.databaseBuilder(
            application, women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.DatabaseService::class.java,
            "bootcamp-instagram-project-db"
        ).build()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.API_KEY,
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024 // 10MB
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)
}