package com.kotlin.test.mvp.presenter

import com.kotlin.test.api.RetrofitUtil
import com.kotlin.test.base.IBaseView
import com.kotlin.test.mvp.contract.ICalendarContract
import com.orhanobut.logger.Logger
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (c), 2018-2018, CHAINCE
 * Author: lixin
 * Date: 2018/11/7
 * Description:
 */
class CalendarDataPresenter(val view: ICalendarContract.View) : ICalendarContract.Model {

    override fun onDestroy() {

    }

    override fun attachView(view: ICalendarContract.View) {

    }

    override fun getDayCalendarData(date: String) {
        RetrofitUtil
                .retrofitService
                .calendarDay(date, "933dc930886c8c0717607f9f8bae0b48")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    view?.showDayCalendarData(result)
                    Logger.e(result.toString())
                }, { error ->
                    view?.showError(error.message.toString())
                    Logger.e(error.message.toString())
                })
    }
}