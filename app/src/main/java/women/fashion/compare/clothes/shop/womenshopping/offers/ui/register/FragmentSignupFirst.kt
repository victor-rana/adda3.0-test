package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register

import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.android.synthetic.main.fragment_signup1.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.FragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel.FragmentSignupFirstViewModel
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.common.Status

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSignupFirst.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSignupFirst(val googleAccount: GoogleSignInAccount?) : BaseFragment<FragmentSignupFirstViewModel>() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun provideLayoutId(): Int = R.layout.fragment_signup1

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {
        etEmail.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onEmailChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })

        et_password.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onPasswordChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })


        etConfirmPassword.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onCnfPasswordChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })

        tvGoogle.setOnClickListener { (activity as RegisterFirstActivity).doGoogleLogin() }

        btSignup.setOnClickListener {
            viewModel.doChangeFragment()
             }

        if(googleAccount!=null){
            etEmail.setText(googleAccount.email)
            tvGoogle.text = googleAccount.displayName
        }
    }

    fun setGoogleData(hasGoogleSignup: Boolean, googleAccount: GoogleSignInAccount?){
        if(hasGoogleSignup){
            etEmail.setText(googleAccount?.email)
            tvGoogle.text = googleAccount?.displayName
        }
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.emailField.observe(this, Observer {
            if (etEmail.text.toString() != it) etEmail.setText(it)
        })

        viewModel.emailValidation.observe(this, Observer {
            when (it.status) {
                Status.ERROR -> layoutEmail.error = it.data?.run { getString(this) }
                else -> layoutEmail.isErrorEnabled = false
            }
        })

        viewModel.passwordField.observe(this, Observer {
            if (et_password.text.toString() != it) et_password.setText(it)
        })

        viewModel.passwordValidation.observe(this, Observer {
            when (it.status) {
                Status.ERROR -> layoutPassword.error = it.data?.run { getString(this) }
                else -> layoutPassword.isErrorEnabled = false
            }
        })

        viewModel.cnfPasswordField.observe(this, Observer {
            if (etConfirmPassword.text.toString() != it) etConfirmPassword.setText(it)
        })

        viewModel.passwordValidation.observe(this, Observer {
            when (it.status) {
                Status.ERROR -> layoutConfirmPassword.error = it.data?.run { getString(this) }
                else -> layoutPassword.isErrorEnabled = false
            }
        })

        viewModel.changeFragment.observe(this, Observer {
          //  (activity as RegisterFirstActivity).addSecondFragment()
        })
    }
}