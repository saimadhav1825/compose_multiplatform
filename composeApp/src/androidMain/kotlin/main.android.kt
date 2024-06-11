import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import di.init
import org.koin.compose.KoinApplication
import presentation.theme.App
import org.koin.android.ext.koin.androidContext

@Composable
fun MainView() {
    val context = LocalContext.current
    KoinApplication(application = {
      androidContext(context.applicationContext)
        init()
    }) {
        App()
    }
}
