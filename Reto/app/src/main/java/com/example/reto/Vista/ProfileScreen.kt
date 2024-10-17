package com.example.reto.Vista


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Altura del banner
            .background(color = GreenAwaq) // Color de fondo del banner

    )
    Column (Modifier.padding(start= 20.dp, end = 20.dp).fillMaxSize()){

        val borderWidth = 4.dp

        Row (Modifier.padding(top = 70.dp)){
            Image(
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = "foto de perfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)



            )
            Column {
                Text(
                    text = stringResource(R.string.profilename),
                    fontWeight = FontWeight.W500,
                    fontSize = 40.sp,
                    color = Color.White,
                    modifier = Modifier

                        .padding(start = 20.dp)
                )
                Text(
                    text = stringResource(R.string.startdate),
                    fontWeight = FontWeight.W400,
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 20.dp)

                )
            }

        }
        Column (Modifier.padding(top = 50.dp)){
            Row (modifier = Modifier.padding(bottom = 10.dp)){
                Image(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = "email",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(30.dp)


                )
                Text(
                    text = stringResource(R.string.correo),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 30.dp)
                )
            }

            Divider()

            Row (modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)){
                Image(
                    painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                    contentDescription = "contraseña",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(30.dp)


                )
                Text(
                    text = stringResource(R.string.contraseña),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 30.dp)
                )
            }

            Divider()

            Row (modifier = Modifier.padding(top = 20.dp,bottom = 20.dp)){
                Image(
                    painter = painterResource(id = R.drawable.baseline_smartphone_24),
                    contentDescription = "numero telefonico",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(30.dp)


                )
                Text(
                    text = stringResource(R.string.numerocel),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 30.dp)
                )
            }
            Divider()
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { navController.navigate("editprofile") },
                modifier = Modifier.size(200.dp, 70.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenAwaq,  // Color de fondo
                    contentColor = White          // Color del texto
                )
            ) {
                Text("Editar", fontSize = 25.sp)
            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showProfile(modifier: Modifier =Modifier){
    val navController = rememberNavController()
    Profile(navController)

}