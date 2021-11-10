package women.fashion.compare.clothes.shop.womenshopping.offers.utils.log

import timber.log.Timber
import women.fashion.compare.clothes.shop.womenshopping.offers.BuildConfig

object Logger {

    init {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    fun d(tag: String, s: String, vararg params: Any) =
        Timber.tag(tag).d(s, params)

    fun d(tag: String, throwable: Throwable, s: String, vararg params: Any) =
        Timber.tag(tag).d(throwable, s, params)

    fun i(tag: String, s: String, vararg params: Any) =
        Timber.tag(tag).i(s, params)

    fun i(tag: String, throwable: Throwable, s: String, vararg params: Any) =
        Timber.tag(tag).i(throwable, s, params)

    fun w(tag: String, s: String, vararg params: Any) =
        Timber.tag(tag).w(s, params)

    fun w(tag: String, throwable: Throwable, s: String, vararg params: Any) =
        Timber.tag(tag).w(throwable, s, params)

    fun e(tag: String, s: String, vararg params: Any) =
        Timber.tag(tag).e(s, params)

    fun e(tag: String, throwable: Throwable, s: String, vararg params: Any) =
        Timber.tag(tag).e(throwable, s, params)

}
