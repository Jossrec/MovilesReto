package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.R

@Composable
fun NuevaContra(message: String, from: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val image = painterResource(R.drawable.vector_5)
    val image2 = painterResource(R.drawable.vector_1)
    val imgage3 = painterResource(R.drawable.vector_3)
    val regreso = painterResource(R.drawable.keyboard_arrow_left)
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
            Image(
                painter = regreso,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(30.dp)
            )
            Text(
                text = "Crear nueva Contraseña",
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
            text = "Tu nueva contraseña debe ser diferente a la que usaste anteriormente",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(0.dp, 30.dp)
        )
        Box(
            modifier = Modifier
                .padding(10.dp, 0.dp)
                .fillMaxWidth()
                .height(60.dp)
            //.border(2.dp, Color.Gray, shape = RoundedCornerShape(6.dp))
        ){
            OutlinedTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                label = { Text(text = "Nueva contraseña") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), //Especifca el tipo de teclado
                visualTransformation = PasswordVisualTransformation() //Para visualiar una contraseña
            )
        }
        Box(
            modifier = Modifier
                .padding(10.dp, 20.dp)
                .fillMaxWidth()
                .height(60.dp)
            //.border(2.dp, Color.Gray, shape = RoundedCornerShape(6.dp))
        ){
            OutlinedTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                label = { Text(text = "Confirmar contraseña") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), //Especifca el tipo de teclado
                visualTransformation = PasswordVisualTransformation() //Para visualiar una contraseña

            )
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
                text = "GUARDAR",
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