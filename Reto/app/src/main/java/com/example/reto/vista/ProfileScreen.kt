package com.example.reto.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.components.NavegacionInferior
import com.example.reto.ui.theme.GreenAwaq

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Configuracion",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = com.example.reto.ui.theme.Black,
                    scrolledContainerColor = GreenAwaq
                )
            )
        },
        bottomBar = {
            NavegacionInferior(navController)
        }
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxSize()
        ) {
            Row(Modifier.padding(top = 20.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.profilepic),
                    contentDescription = "foto de perfil",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                )
                Column {
                    Text(
                        text = stringResource(R.string.profilename),
                        fontWeight = FontWeight.W500,
                        fontSize = 40.sp,
                        color = Black,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                    
                    Text(
                        text = stringResource(R.string.startdate),
                        fontWeight = FontWeight.W400,
                        fontSize = 15.sp,
                        color = Black,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
            Column(Modifier.padding(top = 50.dp)) {
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = "email",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = stringResource(R.string.correo),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 30.dp)
                    )
                }
                Divider()

                Row(modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_smartphone_24),
                        contentDescription = "contraseña",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = stringResource(R.string.numerocel),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 30.dp, end = 40.dp)
                    )
                    Button(
                        onClick = { navController.navigate("EditInfoScreen") },
                        modifier = Modifier.size(80.dp, 30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF9CCC65),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Editar", fontSize = 15.sp)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, shape = RoundedCornerShape(12.dp))
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Cambiar contraseña",
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f),
                        color = Black
                    )
                    Image(
                        painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                        contentDescription = "flecha",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { navController.navigate("EditPasswordScreen") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, shape = RoundedCornerShape(12.dp))
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Notificaciones",
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f),
                        color = Black
                    )
                    val isChecked = true
                    Switch(
                        checked = isChecked,
                        onCheckedChange = null
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { navController.navigate("Intro") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        "Cerrar Sesion",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showProfile(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Profile(navController)
}
