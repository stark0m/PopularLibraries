package com.example.popularlibraries.ui.rxexample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.util.Log
import com.example.popularlibraries.GeekBrainsApp
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import java.io.File
import java.io.FileOutputStream
import java.lang.Error

class RxExamplePresenter(private val router: Router): MvpPresenter<RxExampleVievInterface>() {

    fun getJpgConvetToPngAndShowImage(){
        try {
            var inputStream = GeekBrainsApp.instance.applicationContext.assets?.open("podsolnuh.jpg")

            val d = Drawable.createFromStream(inputStream, null)


            viewState.showImage(d)
            inputStream?.close()
            inputStream = GeekBrainsApp.instance.applicationContext.assets?.open("podsolnuh.jpg")
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream?.close()

            val path = GeekBrainsApp.instance.applicationContext.filesDir?.path + "/out.png"

            Log.i("TAG", path)
            val file = File(path)
            file.createNewFile()

            val outputStream = FileOutputStream(file)

            bitmap.compress(Bitmap.CompressFormat.PNG, 80, outputStream)
            outputStream.close()
        } catch (e: Error) {

        }
    }
}