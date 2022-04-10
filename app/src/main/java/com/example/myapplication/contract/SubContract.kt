package com.example.myapplication.contract

import io.reactivex.Observable

interface SubContract {

    interface View : BaseView<Presenter>{
        fun setData(data : String)
        fun setRecycler()
    }
    interface Presenter : BasePresenter{
        fun getData()
    }

}