package pol.rubiano.magicapp2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pol.rubiano.magicapp2.ui.screens.*

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Magic.route,
        modifier = modifier
    ) {
        composable(Screen.Magic.route) { MagicScreen(navController) }
        composable(Screen.Albums.route) { AlbumsScreen(navController) }
        composable(Screen.Decks.route) { DecksScreen(navController) }
        composable(Screen.Random.route) { RandomScreen(navController) }
        composable(Screen.Search.route) { SearchScreen(navController) }
    }
}
