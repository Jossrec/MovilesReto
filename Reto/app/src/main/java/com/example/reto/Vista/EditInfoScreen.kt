package com.example.reto.Vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.reto.R
import com.example.reto.ui.theme.GreenAwaq


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditInfoScreen(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                "Informacion",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = GreenAwaq,
            titleContentColor = com.example.reto.ui.theme.Black,
            scrolledContainerColor = GreenAwaq
        ),


        )
        Column(
            Modifier
                .padding(start = 20.dp, end = 20.dp, top = 140.dp)
                .fillMaxSize()
        ) {

            Column {
                Text(
                    text = "Nombre",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Text(
                    text = stringResource(R.string.profilename),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }

            Divider()
            Spacer(modifier = Modifier.padding(10.dp))

            Column {
                Text(
                    text = "Correo",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Text(
                    text = stringResource(R.string.correo),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }

            Divider()
            Spacer(modifier = Modifier.padding(10.dp))
            Column {
                Text(
                    text = "Celular",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Text(
                    text = stringResource(R.string.numerocel),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }

            Divider()
            Spacer(modifier = Modifier.padding(30.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier.size(200.dp, 70.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenAwaq,  // Color de fondo
                        contentColor = White          // Color del texto
                    )
                ) {
                    Text("Confirmar", fontSize = 25.sp)
                }
            }
        }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showModif(modifier: Modifier = Modifier) {

    EditInfoScreen()

}