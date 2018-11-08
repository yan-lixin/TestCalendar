package com.kotlin.test.base

/**
 * Copyright (c), 2018-2018, CHAINCE
 * Author: lixin
 * Date: 2018/11/7
 * Description:
 */ 
interface IBaseView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String)
    fun killMySelf()
}