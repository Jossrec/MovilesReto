package com.example.reto.Vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.R


@Composable
fun Settings(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp) // Altura del banner
            .background(color = colorResource(id = R.color.green4CAF50))
    )


    Spacer(modifier = Modifier.height(200.dp))
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp, end = 20.dp, top = 20.dp), horizontalAlignment = Alignment.Start){
        Text(text = "Configuracion",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "GENERAL",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row (horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Editar Perfil",
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "flecha",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        Divider()
        Row (horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
            Text(
                text = "Cambiar Contraseña",
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                modifier = Modifier
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "flecha",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "NOTIFICACIONES",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(15.dp))

        Row (horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Notificaciones",
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "flecha",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "ACCIONES",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(15.dp))

        Row (horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Cerrar Sesion",
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "flecha",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsView() {
    Settings()
}