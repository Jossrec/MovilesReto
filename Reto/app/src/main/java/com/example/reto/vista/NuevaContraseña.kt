package com.example.reto.vista

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.R
import com.example.reto.ui.theme.RetoTheme
import kotlinx.coroutines.flow.combineTransform
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun NuevaContra(modifier: Modifier = Modifier) {
    var nueva_contra by remember { mutableStateOf("") }
    var confirmacion by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false)}
    var passwordVisible2 by remember { mutableStateOf(false)}
    val image = painterResource(R.drawable.vector_5)
    val image2 = painterResource(R.drawable.vector_1)
    val imgage3 = painterResource(R.drawable.vector_3)
    val icono = if(passwordVisible){
        Icons.Default.Visibility
    }
    else{
        Icons.Default.VisibilityOff
    }
    val icono2 = if(passwordVisible2){
        Icons.Default.Visibility
    }
    else{
        Icons.Default.VisibilityOff
    }
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
                value = nueva_contra,
                onValueChange = { newText ->
                    nueva_contra = newText
                },
                label = { Text(text = "Nueva contraseña") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), //Especifca el tipo de teclado
                //Para visualiar una contraseña
                //visualTransformation = PasswordVisualTransformation(),
                visualTransformation =
                if(passwordVisible){
                    VisualTransformation.None
                }
                else PasswordVisualTransformation(),
                trailingIcon = {
                    if(nueva_contra.isNotBlank()){
                        IconButton(onClick = {passwordVisible = !passwordVisible}) {
                            Icon(
                                imageVector = icono,
                                contentDescription = ""
                            )
                        }
                    }
                    else null
                }
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
                value = confirmacion,
                onValueChange = { newText ->
                    confirmacion = newText
                },
                label = { Text(text = "Confirmar contraseña") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), //Especifca el tipo de teclado
                //Para visualiar una contraseña
                //visualTransformation = PasswordVisualTransformation()
                visualTransformation =
                if(passwordVisible2){
                    VisualTransformation.None
                }
                else PasswordVisualTransformation(),
                trailingIcon = {
                    if(nueva_contra.isNotBlank()){
                        IconButton(onClick = {passwordVisible2 = !passwordVisible2}) {
                            Icon(
                                imageVector = icono2,
                                contentDescription = ""
                            )
                        }
                    }
                    else null
                }
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

@Preview(showBackground = true)
@Composable
fun NuevaContraPreview() {
    RetoTheme {
        NuevaContra(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
