package presentation.main

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import presentation.main.cart.CartScreenTab
import presentation.main.home.HomeScreenTab
import presentation.main.notification.NotificationScreenTab
import presentation.main.profile.ProfileScreenTab
import presentation.theme.blackColor
import presentation.theme.platinum_color
import presentation.theme.whiteColor

class MainScreen : Screen {

    @Composable
    override fun Content() {
        TabNavigator(
            tab = HomeScreenTab
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    BottomNavigation(
                        modifier = Modifier.clip(
                            shape = RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp
                            )
                        ),
                        backgroundColor = MaterialTheme.colorScheme.primary,
                    ) {
                        TabNavigationItem(HomeScreenTab)
                        TabNavigationItem(CartScreenTab)
                        TabNavigationItem(NotificationScreenTab)
                        TabNavigationItem(ProfileScreenTab)
                    }
                },
                content = { CurrentTab() },
            )
        }
    }


}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator: TabNavigator = LocalTabNavigator.current
    val selected = tabNavigator.current == tab

    BottomNavigationItem(
        selected = selected,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter = it,
                    contentDescription =
                    tab.options.title, tint = if (selected) blackColor else platinum_color
                )
            }
        },
        selectedContentColor = blackColor,
        unselectedContentColor = whiteColor,
        label = {
            Text(
                text = tab.options.title
            )
        },
        modifier = Modifier.padding(10.dp)
    )
}