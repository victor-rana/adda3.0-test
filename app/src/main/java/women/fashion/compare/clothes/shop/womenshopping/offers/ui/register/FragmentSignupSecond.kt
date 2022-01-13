package women.fashion.compare.clothes.shop.womenshopping.offers.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.android.synthetic.main.fragment_signup2.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.FragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.register.viewmodel.FragmentSignupSecondViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSignupSecond.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSignupSecond : BaseFragment<FragmentSignupSecondViewModel>() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup2, container, false)
    }

    fun setGoogleData(hasGoogleSignup: Boolean, googleAccount: GoogleSignInAccount){
        if(hasGoogleSignup){
            etName.setText(googleAccount.displayName)
            if(googleAccount.familyName!=null){
                etLastName.setText(googleAccount.familyName)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentSignupSecond.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSignupSecond().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_signup2
    }

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupView(view: View) {

    }
}