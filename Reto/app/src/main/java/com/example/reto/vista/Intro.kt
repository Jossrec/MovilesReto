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
            onClick = { /* Acción del botón */ },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            modifier = Modifier
                .fillMaxWidth(0.7f) // Ajusta el ancho
                .height(50.dp)
        ) {
            Text(text = "INICIAR SESIÓN", color = Color.White)
        }

        // Espaciado entre botones
        Spacer(modifier = Modifier.height(5.dp))

        // Botón "Crear una cuenta"
        ClickableText(
            text = AnnotatedString("Crear una cuenta"),
            onClick = { /* Acción del texto */ },
            modifier = Modifier.padding(bottom = 100.dp),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewIntroScreen() {
    var navController = rememberNavController()
    IntroScreen(navController)
}
