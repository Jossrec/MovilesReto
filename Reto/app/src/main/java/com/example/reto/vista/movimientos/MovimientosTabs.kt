package com.example.reto.vista.movimientos

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.reto.models.ItemsTabsMovimientos
import kotlinx.coroutines.launch

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
    TabRow(selectedTabIndex = selectedTab) {
        tabs.forEachIndexed { index, items ->
            Tab(
                selected = selectedTab == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(text = items.title) },
                icon = {
                    Icon(
                        if (index == selectedTab) items.iconSelected
                        else items.iconUnselected,
                        contentDescription = items.title
                    )
                }
            )
        }
    }
}