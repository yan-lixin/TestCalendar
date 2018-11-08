package com.kotlin.test.mvp.ui

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import com.kotlin.test.R
import com.kotlin.test.bean.CalendarDayBean
import com.kotlin.test.mvp.contract.ICalendarContract
import com.kotlin.test.mvp.presenter.CalendarDataPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ICalendarContract.View {

    lateinit var presenter: CalendarDataPresenter

    var date: String? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CalendarDataPresenter(this)

        selectButton.setOnClickListener {
            titleTextView.visibility = View.GONE
            selectButton.visibility = View.GONE
            contentTextView.visibility = View.GONE
            datePicker.visibility = View.VISIBLE
        }

        datePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            date = "$year-$monthOfYear-$dayOfMonth"
            presenter.getDayCalendarData("$year-$monthOfYear-$dayOfMonth")
        }
    }

    override fun showDayCalendarData(calendarDayBean: CalendarDayBean) {
        titleTextView.visibility = View.VISIBLE
        selectButton.visibility = View.VISIBLE
        contentTextView.visibility = View.VISIBLE
        datePicker.visibility = View.GONE
        titleTextView.text = "$date 数据"
        contentTextView.text = calendarDayBean.toString()
    }

    override fun showError(errorMsg: String) {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showMessage(message: String) {
    }

    override fun killMySelf() {
    }
}
