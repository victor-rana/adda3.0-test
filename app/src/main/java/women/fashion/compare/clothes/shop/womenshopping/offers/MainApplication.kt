package women.fashion.compare.clothes.shop.womenshopping.offers

import android.app.Application
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ApplicationComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.DaggerApplicationComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.ApplicationModule


class MainApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

    // Needed to replace the component with a test specific one
    fun setComponent(applicationComponent: ApplicationComponent) {
        this.applicationComponent = applicationComponent
    }
}