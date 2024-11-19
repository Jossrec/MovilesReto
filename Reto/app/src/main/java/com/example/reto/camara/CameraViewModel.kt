package com.example.reto.camara

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.CameraController

import androidx.lifecycle.ViewModel
import java.io.File


class CameraViewModel: ViewModel(){
    private var imageCapture: CameraController? = null


    fun setImageCapture(imageCapture: CameraController) {
        this.imageCapture = imageCapture
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun takePhoto(context: Context, onImageSaved: (File) -> Unit, onError: (ImageCaptureException) -> Unit) {
        // Crear archivo para guardar la imagen
        val photoFile = File(
            context.getExternalFilesDir(null),
            "IMG_${System.currentTimeMillis()}.jpg"
        )

        // Configurar opciones de salida
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        // Capturar la imagen
        imageCapture?.takePicture(
            outputOptions,
            context.mainExecutor,
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    onImageSaved(photoFile)
                }

                override fun onError(exception: ImageCaptureException) {
                    onError(exception)
                }
            }
        )
    }
}