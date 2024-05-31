package presentation.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.main.homscreen.HomeScreenTab
import presentation.signup.SignupScreenContent

class MainScreen : Screen {
    @Composable
    override fun Content() {
        SignupScreenContent()
    }

}
@Preview
@Composable
fun MainScreenContent(){
    TabNavigator(HomeScreenTab) {
        Scaffold(
            content = {
                CurrentTab()
            },
            bottomBar = {

            }
        )
    }
}
