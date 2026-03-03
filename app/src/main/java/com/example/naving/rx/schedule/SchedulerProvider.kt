package com.example.naving.rx.schedule

import io.reactivex.rxjava3.core.Scheduler

interface SchedulerProvider {
    fun io(): Scheduler
    fun main(): Scheduler
    fun computation(): Scheduler
}