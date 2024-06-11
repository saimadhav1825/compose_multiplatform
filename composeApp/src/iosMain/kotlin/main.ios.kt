import androidx.compose.ui.window.ComposeUIViewController
import di.init
import org.koin.compose.KoinApplication
import platform.UIKit.UIViewController
import presentation.theme.App

fun mainViewController(): UIViewController {
    val uiViewController = ComposeUIViewController {
        KoinApplication(application = {
            init()
        }) {
            App()
        }
    }
    Holder.viewController = uiViewController
    return uiViewController
}

internal object Holder {
    var viewController: UIViewController? = null
}