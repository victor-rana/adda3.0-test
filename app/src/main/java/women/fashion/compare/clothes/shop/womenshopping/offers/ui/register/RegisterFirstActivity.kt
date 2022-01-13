package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_register_first.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.login.LoginActivity.Companion.GOOGLE_REQ_CODE
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel.RegisterViewModel


class RegisterFirstActivity : BaseActivity<RegisterViewModel>() {

//    var transaction: FragmentTransaction? = null
//    val manager: FragmentManager = supportFragmentManager
//    private lateinit var mGoogleSignInClient: GoogleSignInClient
//
//    private val FRAGMENT_SIGNUP_FIRST = "FragmentSignupFirst"
//    private val FRAGMENT_SIGNUP_SECOND = "FragmentSignupSecond"
//    lateinit var googleAccount: GoogleSignInAccount
//    var isGoogleSignIn: Boolean = false


    override fun provideLayoutId(): Int = R.layout.activity_register_first

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setClickListener() {
        super.setClickListener()

        btn_sign_up.setOnClickListener(this)
        tv_login.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)

        when (v.id) {
            R.id.btn_sign_up -> {
                startActivity(Intent(this, RegisterSecondActivity::class.java))
                finish()
            }
            R.id.tv_login -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    override fun setupView(savedInstanceState: Bundle?) {
//        val account = intent.getParcelableExtra<GoogleSignInAccount>("googleLoginData")
//        if(account!=null){
//            Timber.tag("RegisterActivity").d("googleAccount ${account.email}")
//            isGoogleSignIn = true
//        }
        // setupFragment(account)
    }

//    private fun setupFragment(googleAccount: GoogleSignInAccount?){
//
//        val fragmentSignupFirst = FragmentSignupFirst(googleAccount)
//        transaction = manager.beginTransaction()
//        transaction!!.add(R.id.registerContainer, fragmentSignupFirst, FRAGMENT_SIGNUP_FIRST)
//        transaction!!.addToBackStack("FragmentSignupFirst")
//        transaction!!.commit()
//    }
//
//    fun addSecondFragment(){
//        val fragmentSignupSecond = FragmentSignupSecond()
//        fragmentSignupSecond.setGoogleData(isGoogleSignIn, googleAccount)
//        transaction = manager.beginTransaction()
//        transaction!!.add(R.id.registerContainer, fragmentSignupSecond, FRAGMENT_SIGNUP_SECOND)
//        transaction!!.addToBackStack("FragmentSignupSecond")
//        transaction!!.commit()
//    }

    fun doGoogleLogin() {

//        if(!isGoogleSignIn)
//        {
//            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build()
//
//            mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//
//            val signInIntent: Intent = mGoogleSignInClient.signInIntent
//            startActivityForResult(signInIntent, GOOGLE_REQ_CODE)
//        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GOOGLE_REQ_CODE && resultCode != Activity.RESULT_CANCELED) {
            viewModel.handleLoginResponse(data)
        }
    }


    override fun setupObservers() {
        super.setupObservers()

//        viewModel.loggingIn.observe(this, Observer {
//            pb_loading_register.visibility = if (it) View.VISIBLE else View.GONE
//        })
//
//        viewModel.googleLiveData.observe(this, Observer {
//            isGoogleSignIn = true
//            val fragment = fragmentManager.findFragmentByTag(FRAGMENT_SIGNUP_FIRST) as FragmentSignupFirst
//            fragment.setGoogleData(isGoogleSignIn, it)
//        })
//
//        viewModel.errorMessage.observe(this, Observer {
//            showMessage(it)
//        })
    }
}