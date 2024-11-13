package com.example.reto.vista.movimientos

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.reto.models.ItemsTabsMovimientos
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TabRowDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovimientosTabs() {
    val tabs = listOf(
        ItemsTabsMovimientos.TabTodos,
        ItemsTabsMovimientos.TabGuardados,
        ItemsTabsMovimientos.TabSubidos
    )
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    Column {
        Tabs(tabs, pagerState)
        TabsContent(tabs, pagerState)
    }
}

@Composable
fun TabsContent(tabs: List<ItemsTabsMovimientos>, pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        beyondViewportPageCount = tabs.size
    ) { page ->
        tabs[page].screen()
    }
}

@Composable
fun Tabs(tabs: List<ItemsTabsMovimientos>, pagerState: PagerState) {
    val selectedTab = pagerState.currentPage
    val scope = rememberCoroutineScope()

    // Incrementa la altura del TabRow para hacer las pestañas más grandes
    TabRow(
        selectedTabIndex = selectedTab,
        modifier = Modifier.height(70.dp), // Ajusta la altura del TabRow
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedTab])
                    .height(15.dp) // Grosor del indicador
            )
        }
    ) {
        tabs.forEachIndexed { index, items ->
            Tab(
                selected = selectedTab == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = items.title,
                        fontSize = 20.sp, // Aumenta el tamaño del texto
                        modifier = Modifier.padding(8.dp)
                    )
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedTab) items.iconSelected else items.iconUnselected,
                        contentDescription = items.title,
                        modifier = Modifier.size(30.dp) // Aumenta el tamaño del ícono
                    )
                }
            )
        }
    }
}