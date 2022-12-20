package com.example.popularlibraries.ui.rxexample

import android.graphics.drawable.Drawable
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RxExampleVievInterface :MvpView{
    fun showImage(pathName:Drawable)
    fun showJPGToPNGconvertationInfo(it: Boolean)
}