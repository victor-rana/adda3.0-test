package women.fashion.compare.clothes.shop.womenshopping.offers.ui.loginsignup

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login_signup.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.RegisterFirstActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.splash.SplashViewModel


class LoginSignupActivity : BaseActivity<SplashViewModel>(){

    override fun provideLayoutId(): Int {
        return R.layout.activity_login_signup
    }


    override fun injectDependencies(activityComponent: ActivityComponent) {
       activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
    }

    override fun setClickListener() {
        btn_login.setOnClickListener(this)
        btn_sign_up.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)

        when(v.id){
            R.id.btn_login -> {
             startActivity(Intent(this, LoginActivity::class.java))
            }
            R.id.btn_sign_up -> {
                startActivity(Intent(this, RegisterFirstActivity::class.java))
            }

        }

    }

}