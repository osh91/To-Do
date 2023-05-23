import androidx.navigation.NavHostController
import com.example.to_do.util.Action
import com.example.to_do.util.Constants
import com.example.to_do.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {

// * NAVIGATION IN LIST AND TASK

    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = {
        // (Int) är taskId
        taskId -> navController.navigate("task/$taskId")
    }
}