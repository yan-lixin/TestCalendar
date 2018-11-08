package com.kotlin.test.api

import com.kotlin.test.bean.CalendarDayBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Copyright (c), 2018-2018, CHAINCE
 * Author: lixin
 * Date: 2018/11/7
 * Description:
 */ 
interface RetrofitService {

    @GET("calendar/day")
    fun calendarDay(@Query("date") date: String, @Query("key") key: String): Observable<CalendarDayBean>
}