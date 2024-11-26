package com.example.reto.vista

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.reto.R
import com.example.reto.ui.theme.GreenAwaq
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPasswordScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.height(120.dp),
                title = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            "Contraseña",
                            fontSize = 50.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = com.example.reto.ui.theme.Black
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .size(80.dp)
                            .padding(vertical = 20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = com.example.reto.ui.theme.Black,
                            modifier = Modifier.size(50.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = com.example.reto.ui.theme.Black,
                    scrolledContainerColor = GreenAwaq
                ),
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(start = 20.dp, end = 20.dp, top = 140.dp)
                .fillMaxSize()
        ) {
            Column {
                Text(
                    text = "Contraseña actual",
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                OutlinedTextField(
                    value = currentPassword,
                    onValueChange = { currentPassword = it },
                    label = { Text(text = stringResource(R.string.contraseña)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(fontSize = 40.sp),
                    singleLine = true
                )
            }


            Spacer(modifier = Modifier.padding(10.dp))

            Column {
                Text(
                    text = "Contraseña nueva",
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                OutlinedTextField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    label = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(fontSize = 40.sp),
                    singleLine = true
                )
            }


            Spacer(modifier = Modifier.padding(10.dp))

            Column {
                Text(
                    text = "Repetir contraseña nueva",
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(fontSize = 40.sp),
                    singleLine = true
                )
            }


            Spacer(modifier = Modifier.padding(30.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    onClick = { navController.navigate("ProfileScreen") },
                    modifier = Modifier.size(300.dp, 70.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreenAwaq,
                        contentColor = White
                    )
                ) {
                    Text("Confirmar", fontSize = 40.sp)
                }
            }
        }
    }
}
