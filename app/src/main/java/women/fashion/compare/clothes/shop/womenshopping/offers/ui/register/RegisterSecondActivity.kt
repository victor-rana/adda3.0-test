package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_register_second.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.data.remote.request.register.RegisterRequest
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity
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
        rg_gender.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_male->{
                   viewModel.setGender(resources.getString(R.string.male))
                }
                R.id.rb_female->{
                    viewModel.setGender(resources.getString(R.string.female))
                }
            }
        }
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

        et_day.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               viewModel.setDay(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        et_month.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setMonth(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        et_year.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.setYear(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        viewModel.errorMessageView.observe(this, Observer {
            showMessage(it)
        })

        viewModel.launchMain.observe(this, Observer {
            startActivityCommon(this, LoginActivity::class.java)
            finish()
        })

        viewModel.loader.observe(this, Observer {
            hideLoader()
        })



    }

}