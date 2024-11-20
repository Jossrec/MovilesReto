package com.example.reto.camara

import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.CameraController

import androidx.lifecycle.ViewModel
import java.io.File



class CameraViewModel : ViewModel() {
    private var imageCapture: CameraController? = null

    fun setImageCapture(imageCapture: CameraController) {
        this.imageCapture = imageCapture
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun takePhoto(
        context: Context,
        onImageSaved: (File) -> Unit,
        onError: (ImageCaptureException) -> Unit
    ) {
        // Crear nombre de archivo único
        val fileName = "IMG_${System.currentTimeMillis()}.jpg"

        // Definir dónde guardar la imagen
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            put(MediaStore.MediaColumns.RELATIVE_PATH, "Pictures/MyApp") // Cambiar 'MyApp' por el nombre de tu app o carpeta
        }

        // Obtener referencia al ContentResolver para interactuar con MediaStore
        val contentResolver = context.contentResolver

        // Capturar la imagen
        val outputOptions = ImageCapture.OutputFileOptions.Builder(
            contentResolver,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            contentValues
        ).build()

        imageCapture?.takePicture(
            outputOptions,
            context.mainExecutor,
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    // Notificar éxito
                    val savedUri = outputFileResults.savedUri
                    savedUri?.let {
                        onImageSaved(File(it.path ?: ""))
                    }
                }

                override fun onError(exception: ImageCaptureException) {
                    // Notificar error
                    onError(exception)
                }
            }
        )
    }
}