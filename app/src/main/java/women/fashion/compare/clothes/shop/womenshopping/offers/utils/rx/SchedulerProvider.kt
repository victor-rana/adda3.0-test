package women.fashion.compare.clothes.shop.womenshopping.offers.utils.rx

import io.reactivex.Scheduler
import javax.inject.Singleton

@Singleton
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}