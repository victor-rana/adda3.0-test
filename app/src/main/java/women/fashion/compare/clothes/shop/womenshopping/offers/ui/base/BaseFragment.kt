package women.fashion.compare.clothes.shop.womenshopping.offers.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.DaggerFragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.FragmentComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.di.module.FragmentModule
import women.fashion.compare.clothes.shop.womenshopping.offers.utils.display.Toaster
import javax.inject.Inject

/**
 * Reference for generics: https://kotlinlang.org/docs/reference/generics.html
 * Basically BaseFragment will take any class that extends BaseViewModel
 */
abstract class BaseFragment<VM : BaseViewModel> : Fragment() {
    lateinit var progressDialog : ProgressDialog
    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
        setupObservers()
        viewModel.onCreate()
    }

    private fun buildFragmentComponent() =
        DaggerFragmentComponent
            .builder()
            .applicationComponent((requireContext().applicationContext as women.fashion.compare.clothes.shop.womenshopping.offers.MainApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(provideLayoutId(), container, false)

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }


    fun showMessage(message: String) = context?.let { Toaster.show(it, message) }

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    fun goBack() {
        if (activity is BaseActivity<*>) (activity as BaseActivity<*>).goBack()
    }

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

    protected abstract fun setupView(view: View)

    fun showLoader(){
        if( this::progressDialog.isInitialized) {
            progressDialog.show();
        } else{
            progressDialog = ProgressDialog(requireContext())
            progressDialog.show()
        }
    }

    fun hideLoader(){
        if(this::progressDialog.isInitialized){ progressDialog.dismiss()}
    }
}