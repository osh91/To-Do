import androidx.navigation.NavHostController
import com.example.to_do.util.Action
import com.example.to_do.util.Constants.LIST_SCREEN
import com.example.to_do.util.Constants.SPLASH_SCREEN

class Screens(navController: NavHostController) {

    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }

    // * NAVIGATION IN LIST AND TAS
    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = {
        // (Int) är taskId
            taskId ->
        navController.navigate("task/$taskId")
    }
}