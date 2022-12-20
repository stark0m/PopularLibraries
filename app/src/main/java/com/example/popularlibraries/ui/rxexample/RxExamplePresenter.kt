package com.example.popularlibraries.ui.rxexample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import com.example.popularlibraries.GeekBrainsApp
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import java.io.File
import java.io.FileOutputStream
import java.lang.Error

class RxExamplePresenter(private val router: Router) : MvpPresenter<RxExampleVievInterface>() {
    private val JPG_FILE_NAME = "podsolnuh.jpg"
    private val PNG_FILE_NAME = "/out.png"
    private fun getDrawbl(): Single<Drawable> {
        return Single.create() {
            var inputStream = GeekBrainsApp.instance.applicationContext.assets?.open(JPG_FILE_NAME)
            it.onSuccess(Drawable.createFromStream(inputStream, null))
            inputStream?.close()
        }
    }

    private fun saveJpgToPng(): Single<Boolean> {
        return Single.create() {
            val inputStream = GeekBrainsApp.instance.applicationContext.assets?.open(JPG_FILE_NAME)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream?.close()

            val path = GeekBrainsApp.instance.applicationContext.filesDir?.path + PNG_FILE_NAME
            val file = File(path).also {
                it.createNewFile()
            }

            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 80, outputStream)
            outputStream.close()
            it.onSuccess(true)
        }
    }

    fun getJpgConvetToPngAndShowImage() {
        try {
            getDrawbl()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                viewState.showImage(it)
            }, {

            })

            saveJpgToPng()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                viewState.showJPGToPNGconvertationInfo(it)
            }, {})
        } catch (e: Error) {

        }
    }
}