package com.example.reto.Vista


import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reto.R
import com.example.reto.ui.theme.Black
import com.example.reto.ui.theme.GreenAwaq
import com.example.reto.ui.theme.RetoTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Jetpack Compose 1", "Preparado?"),
    MyMessage("Hola Jetpack Compose 2", "Preparado?"),
    MyMessage("Hola Jetpack Compose 3", "Preparado?"),
    MyMessage("Hola Jetpack Compose 4", "Preparado?"),
    MyMessage("Hola Jetpack Compose 5", "Preparado?"),
    MyMessage("Hola Jetpack Compose 6", "Preparado?"),
    MyMessage("Hola Jetpack Compose 7", "Preparado?"),
    MyMessage("Hola Jetpack Compose 8", "Preparado?"),
    MyMessage("Hola Jetpack Compose 9", "Preparado?"),
    MyMessage("Hola Jetpack Compose 10", "Preparado?"),
    MyMessage("Hola Jetpack Compose 11", "Preparado?"),
    MyMessage("Hola Jetpack Compose 12", "Preparado?"),
    MyMessage("Hola Jetpack Compose 13", "Preparado?"),
    MyMessage("Hola Jetpack Compose 14", "Preparado?"),
    MyMessage("Hola Jetpack Compose 15", "Preparado?"),
    MyMessage("Hola Jetpack Compose 16", "Preparado?"),
)


data class MyMessage(val title: String, val body: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(messages: List<MyMessage>) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Búsqueda",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenAwaq,
                    titleContentColor = Black
                ),
                navigationIcon = {
                    IconButton(onClick = { /* Acción de navegación */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Descripción del ícono"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Acción del menú */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Descripción del ícono"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        MyMessages(messages, Modifier.padding(innerPadding))
    }
}

@Composable
fun MyMessages(messages: List<MyMessage>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyComponent(message: MyMessage) {
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun MyTexts(message: MyMessage) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            message.title,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
    RetoTheme {
        SearchScreen(messages)
    }
}