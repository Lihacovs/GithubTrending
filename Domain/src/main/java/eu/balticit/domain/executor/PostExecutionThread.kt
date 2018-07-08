package eu.balticit.domain.executor

import io.reactivex.Scheduler

/**
 * This interface is used to separate RxAndroid concern from Presentation module
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}