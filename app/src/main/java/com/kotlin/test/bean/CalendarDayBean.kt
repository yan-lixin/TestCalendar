package com.kotlin.test.bean

/**
 * Copyright (c), 2018-2018, CHAINCE
 * Author: lixin
 * Date: 2018/11/7
 * Description:
 */ 
data class CalendarDayBean(
        val reason: String,
        val result: CalendarDayResult,
        val error_code: Int)

data class CalendarDayResult(
        val data: CalendarDayData
)

data class CalendarDayData(
        val date: String,
        val weekday: String,
        val animalsYear: String,
        val suit: String,
        val avoid: String,
        val yearMonth: String,
        val holiday: String,
        val lunar: String,
        val lunarYear: String,
        val desc: String
)