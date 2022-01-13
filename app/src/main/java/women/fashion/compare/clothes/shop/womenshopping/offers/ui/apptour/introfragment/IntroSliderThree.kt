package women.fashion.compare.clothes.shop.womenshopping.offers.ui.apptour.introfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.FragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseFragment
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.splash.SplashViewModel

class IntroSliderThree : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.intro_slider_one, container, false)
    }
}