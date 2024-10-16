package com.example.reto.Vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.reto.R


@Composable
fun EditProfile() {
    // Usamos un estado para guardar el valor ingresado por el usuario
    var text by remember { mutableStateOf("") }

    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Row (modifier = Modifier.padding(top = 30.dp) ){
            Image(
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = "foto de perfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .padding(16.dp),

            ) {
            Text(text= "Nombre", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text(stringResource(R.string.profilename)) },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(40.dp))

            Text(text= "Email", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text(stringResource(R.string.correo)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(40.dp))

            Text(text= "Contraseña", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text(stringResource(R.string.contraseña)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(40.dp))

            Text(text= "Télefono", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text(stringResource(R.string.numerocel)) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(35.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(onClick = { /* Acción */ },
                    modifier = Modifier
                        .size(200.dp, 70.dp) // Color del texto

                ) {
                    Text("Guardar", fontSize = 25.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditProfileView() {
    EditProfile()
}