package women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies


import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view_dummies.view.*
import women.fashion.compare.clothes.shop.womenshopping.offers.R
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.Dummy
import women.fashion.compare.clothes.shop.womenshopping.offers.di.component.ViewHolderComponent
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseItemViewHolder

class DummyItemViewHolder(parent: ViewGroup) : BaseItemViewHolder<Dummy, DummyItemViewModel>(
        R.layout.item_view_dummies, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.name.observe(this, Observer {
            itemView.tv_head_line_dummy.text = it
        })

        viewModel.url.observe(this, Observer {
            Glide.with(itemView.context).load(it).into(itemView.iv_dummy)
        })
    }

    override fun setupView(view: View) {
        view.setOnClickListener {
            viewModel.onItemClick(adapterPosition)
        }
    }
}