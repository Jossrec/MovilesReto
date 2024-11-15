package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.navigation.NavScreen
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.GreenAwaqOscuro

@Composable
fun IntroScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD7E3CE)), // Color de fondo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        // Logo con margen
        Text(
            text = "AWAQ-BIO",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 50.dp)
        )

        // Imagen principal
        Image(
            painter = painterResource(id = R.drawable.awaqs2_removebg_preview), // Reemplaza con tu imagen principal
            contentDescription = "Imagen principal",
            modifier = Modifier
                .size(400.dp) // Ajusta el tamaño según sea necesario
                .padding(15.dp),
            contentScale = ContentScale.Fit
        )

        // Espaciado entre la imagen y los botones
        Spacer(modifier = Modifier.height(20.dp))

        // Botón "Iniciar sesión"
        Button(
            onClick = {navController.navigate(NavScreen.LoginScreen.name) },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = GreenAwaqOscuro),
            modifier = Modifier
                .fillMaxWidth(0.8f) // Ajusta el ancho
                .height(80.dp)
        ) {
            Text(text = "INICIAR SESIÓN", color = Color.White,fontSize = 40.sp)
        }
        Spacer(modifier = Modifier.height(40.dp))


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewIntroScreen() {
    var navController = rememberNavController()
    IntroScreen(navController)
}