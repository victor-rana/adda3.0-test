package women.fashion.compare.clothes.shop.womenshopping.offers.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.AppTourActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.LandingActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.loginsignup.LoginSignupActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Event


class SplashActivity : BaseActivity<SplashViewModel>() {

    companion object {
        const val TAG = "SplashActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_splash

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun setupObservers() {
        super.setupObservers()

        // Event is used by the view model to tell the activity to launch another activity
        // view model also provided the Bundle in the event that is needed for the Activity
        viewModel.launchLogin.observe(this, Observer<Event<Map<String, String>>> {
//            it.getIfNotHandled()?.run {
//                startActivity(Intent(applicationContext, LoginActivity::class.java))
//            }

            Handler().postDelayed(Runnable {
                startActivity(Intent(applicationContext, AppTourActivity::class.java))
            },2000)

        })

        viewModel.launchMain.observe(this, Observer {


            Handler().postDelayed(Runnable {
                startActivity(Intent(applicationContext, LandingActivity::class.java))
            },2000)

//            it.getIfNotHandled()?.run {
//                startActivity(Intent(applicationContext, LandingActivity::class.java))
//            }
        })


    }
}