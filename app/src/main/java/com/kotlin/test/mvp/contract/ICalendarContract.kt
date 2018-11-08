package com.kotlin.test.mvp.contract

import com.kotlin.test.base.IBaseModel
import com.kotlin.test.base.IBaseView
import com.kotlin.test.bean.CalendarDayBean

/**
 * Copyright (c), 2018-2018, CHAINCE
 * Author: lixin
 * Date: 2018/11/7
 * Description:
 */ 
interface ICalendarContract {

    /**
     * 对于经常使用的关于UI定义的方法可以定义到IBaseView中，如显示隐藏进度条，和显示文字消息
     */
    interface View: IBaseView {
        fun showDayCalendarData(calendarDayBean: CalendarDayBean)
        fun showError(errorMsg: String)
    }

    /**
     * Model层定义接口，外部只需要关心Model返回的数据，无需关心内部细节，如是否使用缓存
     */
    interface Model: IBaseModel<ICalendarContract.View> {
        fun getDayCalendarData(date: String)
    }
}