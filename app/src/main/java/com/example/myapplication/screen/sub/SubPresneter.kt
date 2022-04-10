package com.example.myapplication.screen.sub

import android.content.Context
import android.util.Log
import com.example.myapplication.contract.SubContract
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

class SubPresneter(val view : SubContract.View) : SubContract.Presenter {

    override fun getData() {
        Log.d("TestData","---- 호출 시작")
/*        val source : Observable<String> = Observable.create { emitter->
            emitter.onNext("Hello")
            emitter.onNext("Kotlin")
            emitter.onComplete()
        }

        source.subscribe {
            view.setData(it)
        }*/

//        var source1 = Observable.just("Hello", "Kotlin!!!")
//        source1.subscribe {
//            view.setData(it)
//        }
//        val list = listOf("aaaa","bbbb","cccc","dddd")
//
//
//        val observable = Observable.just(1,2,3,4,5)
//        observable
//            .map {
//                t -> (t*t).toString() + "hELLOW"
//            }
//            .subscribe{
//            view.setData(it)
//        }


        val getDiamond = Function<String, Observable<String>>{
            num -> Observable.just("$num<1>", "$num<2>","$num<3>","$num<4>","$num<5>")
        }

        val number = arrayOf("1","2","3","4","5")
        val observable = Observable.fromArray(*number).flatMap(getDiamond)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                view.setRecycler()
            }
            .subscribe {
                view.setData(it)
            }

        Log.d("TestData","---- 호출 끝")
    }

}