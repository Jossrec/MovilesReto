package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.R
import com.example.reto.ui.theme.RetoTheme
import kotlinx.coroutines.flow.combineTransform
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun DigitBox(value: String, onValueChange: (String) -> Unit) {
    BasicTextField(
        value = value,
        onValueChange = {
            if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                onValueChange(it)
            }
        },
        modifier = Modifier
            .size(43.dp, 50.dp)
            .background(Color(0xFFDCE3D4)), // color verde claro
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        ),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFDCE3D4)) // color verde claro
            ) {
                innerTextField()
            }
        }
    )
}

@Composable
fun Verificacion(modifier: Modifier = Modifier) {
    val correo  by remember { mutableStateOf("example@gmail.com") }
    val image = painterResource(R.drawable.vector_5)
    val image2 = painterResource(R.drawable.vector_1)
    val imgage3 = painterResource(R.drawable.vector_3)
    val regreso = painterResource(R.drawable.keyboard_arrow_left)
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }
    var input3 by remember { mutableStateOf("") }
    var input4 by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
    ){
        Box(
            modifier = Modifier
        ){
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Image(
                painter = image2,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(190.dp)
                    .offset(240.dp)
            )
            IconButton(onClick = { /* Acción del menú */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = "Descripción del ícono",
                    tint = Color.White
                )
            }
            Text(
                text = "Verificación",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 60.sp,
                textAlign = TextAlign.Left,
                color = Color.White,
                modifier = Modifier
                    .padding(10.dp, 50.dp)
            )
        }
        Text(
            text = "Por favor escribe el código de verificación de 4 dígitos enviado a ${correo}",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp, 30.dp, 0.dp, 15.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Row(
                modifier = Modifier
                    .padding(45.dp, 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                DigitBox(input1) { input1 = it }
                DigitBox(input2) { input2 = it }
                DigitBox(input3) { input3 = it }
                DigitBox(input4) { input4 = it }
            }

        }
    }
    Column (
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ){
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.green_black)
            ),
            modifier = Modifier
        ) {
            Text(
                text = "VERIFICAR",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Image(
            painter = imgage3,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun VerificaciónPreview() {
    RetoTheme {
        Verificacion(
            modifier = Modifier.fillMaxSize()
        )
    }
}