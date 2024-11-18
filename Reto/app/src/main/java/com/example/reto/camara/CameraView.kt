package com.example.reto.camara


import android.content.ContentValues

import android.media.MediaScannerConnection

import android.os.Build
import android.os.Environment
import android.provider.MediaStore

import androidx.annotation.RequiresApi


import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.FloatingActionButton

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.reto.MainActivity

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun CameraView(modifier: Modifier = Modifier, activity: MainActivity,onClose: () -> Unit) {

    val cameraViewModel = CameraViewModel()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var showCamera by remember { mutableStateOf(true) }

        CameraWindow(activity = activity, cameraViewModel = cameraViewModel, onClose = onClose)
    }
}
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun CameraWindow(
    activity: MainActivity,
    cameraViewModel: CameraViewModel,
    onClose: () -> Unit
) {
    val controller = remember {
        LifecycleCameraController(activity).apply {
            setEnabledUseCases(CameraController.IMAGE_CAPTURE)
        }
    }
    cameraViewModel.setImageCapture(controller)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val lifecycleOwner = LocalLifecycleOwner.current
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = {
                PreviewView(it).apply {
                    this.controller = controller
                    controller.bindToLifecycle(lifecycleOwner)
                }
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Botón para cerrar la cámara
            CameraControlButton(
                icon = Icons.Filled.ArrowBack,
                contentDescription = "Cerrar Cámara",
                onClick = onClose ,// Llama al callback para cerrar la cámara
            )

            Spacer(modifier = Modifier.width(1.dp))

            // Botón para tomar una foto
            CameraControlButton(
                icon = Icons.Filled.PhotoCamera,
                contentDescription = "Tomar Foto",
                onClick = {
                    if (activity.arePermissionsGranted()) {
                        val contentResolver = activity.contentResolver
                        val contentValues = ContentValues().apply {
                            put(MediaStore.Images.Media.DISPLAY_NAME, "photo_${System.currentTimeMillis()}.jpg")
                            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                            put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
                        }
                        val uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
                        val outputStream = uri?.let { contentResolver.openOutputStream(it) }
                        cameraViewModel.takePhoto(
                            context = activity,
                            onImageSaved = { file ->
                                println("Foto guardada en: ${file.absolutePath}")
                                MediaScannerConnection.scanFile(activity, arrayOf(file.absolutePath), null, null)
                            },
                            onError = { exception ->
                                println("Error al tomar la foto: ${exception.message}")
                            }
                        )
                    }
                }
            )
        }
    }
}
@Composable
fun CameraControlButton(icon: ImageVector, contentDescription: String?, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(60.dp)
            .background(MaterialTheme.colorScheme.primary)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(26.dp)
        )
    }
}