package women.fashion.compare.clothes.shop.womenshopping.offers.ui.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import women.fashion.compare.clothes.shop.womenshopping.offers.MainApplication
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.DaggerActivityComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.ActivityModule
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.display.Toaster

import javax.inject.Inject

/**
 * Reference for generics: https://kotlinlang.org/docs/reference/generics.html
 * Basically BaseActivity will take any class that extends BaseViewModel
 */
abstract class  BaseActivity<VM : BaseViewModel> : AppCompatActivity(), View.OnClickListener{

   lateinit var progressDialog : ProgressDialog

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        setupObservers()
        setClickListener();
        setupView(savedInstanceState)
        viewModel.onCreate()
    }

    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    fun startActivityCommon( context : Context?, activity : Class<*>){
        startActivity(Intent(context, activity))
    }

    fun showLoader(){
       if( this::progressDialog.isInitialized) {
           progressDialog.show();
       } else{
           progressDialog = ProgressDialog(this)
           progressDialog.show()
       }
    }

    fun hideLoader(){
       if(this::progressDialog.isInitialized){ progressDialog.dismiss()}
    }

    fun showMessage(message: String) = Toaster.show(applicationContext, message)

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    open fun goBack() = onBackPressed()

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStackImmediate()
        else super.onBackPressed()
    }

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)

     open fun setClickListener(){
    }

    override fun onClick(v: View) {

    }
}