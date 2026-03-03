package com.example.naving.rx.schedule

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AppSchedulerProvider @Inject constructor() : SchedulerProvider {
    override fun io() = Schedulers.io()
    override fun main(): Scheduler = AndroidSchedulers.mainThread()
    override fun computation() = Schedulers.computation()
}
