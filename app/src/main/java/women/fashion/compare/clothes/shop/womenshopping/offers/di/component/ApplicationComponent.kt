package women.fashion.compare.clothes.shop.womenshopping.offers.di.component

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

import dagger.Component
import io.reactivex.disposables.CompositeDisposable

import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.NetworkService
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.GlobalFeedRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.data.repository.UserRepository
import women.fashion.compare.clothes.shop.womenshopping.offers.di.ApplicationContext
import women.fashion.compare.clothes.shop.womenshopping.offers.di.TempDirectory
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.ApplicationModule
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.network.NetworkHelper
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx.SchedulerProvider
import java.io.File
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: women.fashion.compare.clothes.shop.womenshopping.offers.MainApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    /**
     * These methods are written in ApplicationComponent because the instance of
     * NetworkService is singleton and is maintained in the ApplicationComponent's implementation by Dagger
     * For NetworkService singleton instance to be accessible to say DummyActivity's DummyViewModel
     * this ApplicationComponent must expose a method that returns NetworkService instance
     * This method will be called when NetworkService is injected in DummyViewModel.
     * Also, in ActivityComponent you can find dependencies = [ApplicationComponent::class] to link this relationship
     */
    fun getNetworkService(): NetworkService

    fun getDatabaseService(): women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.DatabaseService

    fun getSharedPreferences(): SharedPreferences

    fun getNetworkHelper(): NetworkHelper

    /**---------------------------------------------------------------------------
     * Dagger will internally create UserRepository instance using constructor injection.
     * Dependency through constructor
     * UserRepository ->
     *  [NetworkService -> Nothing is required],
     *  [DatabaseService -> Nothing is required],
     *  [UserPreferences -> [SharedPreferences -> provided by the function provideSharedPreferences in ApplicationModule class]]
     * So, Dagger will be able to create an instance of UserRepository by its own using constructor injection
     *---------------------------------------------------------------------------------
     */
    fun getUserRepository(): UserRepository

    fun getGlobalFeedRepository(): GlobalFeedRepository

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

    @TempDirectory
    fun getTempDirectory(): File
}