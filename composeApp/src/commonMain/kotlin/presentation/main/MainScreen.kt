package presentation.main

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import presentation.main.cart.CartScreenTab
import presentation.main.home.HomeScreenTab
import presentation.main.notification.NotificationScreenTab
import presentation.main.profile.ProfileScreenTab

class MainScreen : Screen {

    @Composable
    override fun Content() {
        TabNavigator(
            tab = HomeScreenTab
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    BottomNavigation {
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

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = {
            tab.options.icon?.let { icon ->
                Icon(
                    painter = icon,
                    contentDescription =
                    tab.options.title
                )
            }
        },
        label = {
            Text(
                text = tab.options.title
            )
        }
    )
}