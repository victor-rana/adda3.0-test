package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_register_second.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.register.RegisterRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel.RegisterViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.splash.SplashViewModel


class RegisterSecondActivity : BaseActivity<RegisterViewModel>() {

    override fun provideLayoutId(): Int {
        return R.layout.activity_register_second
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun setClickListener() {
        super.setClickListener()
        btn_register.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        when (v.id) {
            R.id.btn_register -> {
                viewModel.registerUser(RegisterRequest("Sushant Rijal","MALE","s@gmail.com",
                    "123456","01/02/1996","7905646653"))
            }
        }
    }

    fun setUpObservers(){


    }

}