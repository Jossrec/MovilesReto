package com.example.reto.vista

import androidx.compose.foundation.layout.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng


import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.maps.android.compose.Marker
import com.google.android.gms.location.LocationServices
import com.google.maps.android.compose.MarkerState


@Composable
fun MapScreen(navController: NavController,
              viewModel: Formulario_1ViewModel
) {
    val context = LocalContext.current
    val fusedLocationProviderClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    var userLocation by remember { mutableStateOf(LatLng(-33.852, 151.211)) } // Default location
    var selectedLocation by remember { mutableStateOf<LatLng?>(null) }
    var selectedAddress by remember { mutableStateOf<String?>(null) }
    val cameraPositionState = rememberCameraPositionState {
        CameraPosition.fromLatLngZoom(userLocation, 10f)
    }

    // Verificación y solicitud de permisos
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                // Obtener ubicación si el permiso es concedido
                getUserLocation(fusedLocationProviderClient) { location ->
                    userLocation = LatLng(location.latitude, location.longitude)
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(userLocation, 15f)
                }
            }
        }
    )

    // Comprobar permiso inicial
    LaunchedEffect(Unit) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            getUserLocation(fusedLocationProviderClient) { location ->
                userLocation = LatLng(location.latitude, location.longitude)
                cameraPositionState.position = CameraPosition.fromLatLngZoom(userLocation, 15f)
            }
        } else {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    // UI principal
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderMap(navController)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            GoogleMap(
                cameraPositionState = cameraPositionState,
                onMapClick = { latLng ->
                    // Cuando el usuario hace clic en el mapa, se actualiza la ubicación seleccionada
                    selectedLocation = latLng
                    val geocoder = Geocoder(context)
                    val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
                    selectedAddress = addresses?.firstOrNull()?.getAddressLine(0)
                }
            ) {
                selectedLocation?.let {
                    Marker(
                        state = MarkerState(position = it),  // Usamos MarkerState en lugar de 'position'
                        title = selectedAddress ?: "Ubicación seleccionada"
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        selectedLocation?.let {
                            viewModel.updateLocalidad("$selectedAddress (${selectedLocation!!.latitude}, ${selectedLocation!!.longitude})" ?: "Ubicación desconocida")
                            navController.navigate("Formulario1")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 100.dp, vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro)
                ) {
                    Text(
                        text = "Guardar",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

// Función para obtener la ubicación del usuario
fun getUserLocation(
    fusedLocationProviderClient: FusedLocationProviderClient,
    onLocationAvailable: (Location) -> Unit
) {
    try {
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                onLocationAvailable(it)
            }
        }
    } catch (e: SecurityException) {
        e.printStackTrace()
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HeaderMap(navController: NavController) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "Mi ubicación",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = GreenAwaq,
            titleContentColor = Color.Black,
            scrolledContainerColor = GreenAwaq
        ),
        navigationIcon = {
            IconButton(onClick = { navController.navigate("Formulario1") }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Regresar"
                )
            }
        }
    )
}
