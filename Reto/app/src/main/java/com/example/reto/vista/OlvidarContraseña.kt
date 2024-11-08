package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reto.R
import com.example.reto.ui.theme.RetoTheme
import kotlinx.coroutines.flow.combineTransform
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val image = painterResource(R.drawable.vector_5)
    val image2 = painterResource(R.drawable.vector_1)
    val imgage3 = painterResource(R.drawable.vector_3)
    val regreso = painterResource(R.drawable.keyboard_arrow_left)
    Column (
        modifier = modifier.fillMaxWidth()
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
            Text(
                text = message,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 60.sp,
                textAlign = TextAlign.Left,
                color = Color.White,
                modifier = Modifier
                    .padding(10.dp, 50.dp)
            )
            IconButton(onClick = { /* Acción del menú */ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = "Descripción del ícono",
                    tint = Color.White
                )
            }
        }
        Text(
            text = from,
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
                label = { Text(text = "Email") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), //Especifca el tipo de teclado
                //visualTransformation = PasswordVisualTransformation() //Para visualiar una contraseña
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
                text = "ENVIAR",
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
fun GreetingTextPreview() {
    RetoTheme {
        GreetingText(
            message = "Olvidaste la contraseña?",
            from = "Por favor escribe tu email para poder recibir un código de verificación.",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}