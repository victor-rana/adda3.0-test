package women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_app_tour.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.introfragment.IntroSliderFour
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.introfragment.IntroSliderOne
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.introfragment.IntroSliderThree
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.introfragment.IntroSliderTwo
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.LandingActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.loginsignup.LoginSignupActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.splash.SplashViewModel

class AppTourActivity : BaseActivity<SplashViewModel>() {
    private val fragmentList = ArrayList<Fragment>()

    override fun provideLayoutId(): Int {
        return R.layout.activity_app_tour
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
       activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        val adapter = PagerAdapter(this)
        vpIntroSlider.adapter = adapter
        fragmentList.addAll(listOf(
            IntroSliderOne(), IntroSliderTwo(), IntroSliderThree(), IntroSliderFour()
        ))
        adapter.setFragmentList(fragmentList)
        indicatorLayout.setIndicatorCount(adapter.itemCount)
        indicatorLayout.selectCurrentPosition(0)
        registerListeners()

        btn_shop_now.setOnClickListener(View.OnClickListener {
            startActivityCommon(this, LoginSignupActivity::class.java)
            finish()
        })

    }

    private fun registerListeners() {
        vpIntroSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                indicatorLayout.selectCurrentPosition(position)
                tv_count.text = ""+(position+1)
                if (position == 0) {

                  tv_description.setText("Jennifer Kingsley exploring new range of winter fashion wear")
                } else if(position == 1) {
                    tv_description.setText("Jimmy Chuka exploring new spring sweater collection")
                } else if(position == 2) {
                    tv_description.setText("Christain Lobi showing us his new summer beach wear")
                } else if(position == 3) {
                    tv_description.setText("Jimmy Chuka exploring new spring sweater collection")
                }
            }
        })

    }
}