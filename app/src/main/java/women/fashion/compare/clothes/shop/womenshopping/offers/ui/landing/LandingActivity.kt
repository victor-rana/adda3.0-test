package women.fashion.compare.clothes.shop.womenshopping.offers.ui.landing

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseActivity

class LandingActivity : BaseActivity<LandingViewModel>() {

    override fun provideLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragNavHost) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNavigation, navHostFragment.navController)

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf (
                R.id.homeFragment,
                R.id.top_departmentFragment,
                R.id.addFeedFragment,
                R.id.cartFragment,
                R.id.offersFragment,
            )
        )
        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)
    }
}