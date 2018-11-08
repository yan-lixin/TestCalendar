package com.kotlin.test

import android.app.Application
import com.orhanobut.logger.LogLevel
import com.orhanobut.logger.Logger

/**
 * Copyright (c), 2018-2018, CHAINCE
 * Author: lixin
 * Date: 2018/11/7
 * Description:
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.init().logLevel(LogLevel.FULL).methodCount(3);
    }
}