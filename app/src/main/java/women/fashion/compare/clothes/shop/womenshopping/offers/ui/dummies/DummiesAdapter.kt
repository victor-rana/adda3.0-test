package women.fashion.compare.clothes.shop.womenshopping.offers.ui.dummies

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import women.fashion.compare.clothes.shop.womenshopping.offers.data.model.Dummy
import women.fashion.compare.clothes.shop.womenshopping.offers.ui.base.BaseAdapter


class DummiesAdapter(
    parentLifecycle: Lifecycle,
    private val dummies: ArrayList<Dummy>
) : BaseAdapter<Dummy, DummyItemViewHolder>(parentLifecycle, dummies) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DummyItemViewHolder(parent)
}