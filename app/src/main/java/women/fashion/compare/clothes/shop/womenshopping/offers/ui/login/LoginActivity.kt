package women.fashion.compare.clothes.shop.womenshopping.offers.ui.login


import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Event
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

import android.content.Intent
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.android.synthetic.main.activity_login.*
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing.LandingActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.RegisterFirstActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Validation
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Validator


class LoginActivity : BaseActivity<LoginViewModel>() {


    private lateinit var email: String
    private lateinit var passowrd: String

    companion object {
        const val TAG = "LoginActivity"
        const val GOOGLE_REQ_CODE = 100
    }

    private lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun provideLayoutId(): Int = R.layout.activity_login

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }


    override fun setClickListener() {
        super.setClickListener()

        btn_login.setOnClickListener(this)
        tv_sign_up.setOnClickListener(this)
        tv_forgot_password.setOnClickListener(this)
        tv_google.setOnClickListener(this)
        tv_facebook.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        super.onClick(v)

        when (v.id) {

            R.id.btn_login -> {
                email = et_email.text.toString().trim()
                passowrd = et_password.text.toString().trim()
                if (!Validator.validateEmail(email)) {
                    showMessage(R.string.email_field_invalid)
                } else if (!Validator.validatePassword(passowrd)) {
                    showMessage(R.string.password_field_small_length)
                } else {
                    showLoader()
                    viewModel.onLogin(email, passowrd)
                }
            }
            R.id.tv_sign_up -> {
                startActivityCommon(this, RegisterFirstActivity::class.java)
            }
            R.id.tv_forgot_password -> {

            }
            R.id.tv_google -> {

            }
            R.id.tv_facebook -> {

            }

        }
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }

    private fun initGoogleConfig() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    fun doGoogleLogin() {

        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, GOOGLE_REQ_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GOOGLE_REQ_CODE && resultCode != Activity.RESULT_CANCELED) {
            handleLoginResponse(data)
        }
    }

    private fun handleLoginResponse(data: Any?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data as Intent)
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)

            viewModel.onGoogleLogin(account)

            Log.d(TAG, "handleLoginResponse ok${account.email}")

        } catch (e: Exception) {
            Log.d(TAG, "handleLoginResponse error: ${e.message}")
            e.message?.let { showMessage(it) }
        }
    }

    override fun setupObservers() {
        super.setupObservers()


        viewModel.logIn.observe(this, Observer {

            if (it) {
                startActivityCommon(this, LandingActivity::class.java)
            } else {
                showMessage(R.string.invalid_user)
            }
        })



        viewModel.loader.observe(this, Observer { hideLoader() })
    }


}