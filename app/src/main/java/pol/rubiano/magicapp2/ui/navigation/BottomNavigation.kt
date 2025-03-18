package pol.rubiano.magicapp2.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import pol.rubiano.magicapp2.R
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.compose.outlineLight
import com.example.compose.primaryLight


sealed class Screen(val route: String, val title: Int, val icon: Int) {
    data object Magic : Screen("magic", R.string.magic, R.drawable.magic)
    data object Albums : Screen("albums", R.string.albums, R.drawable.album)
    data object Decks : Screen("decks", R.string.decks, R.drawable.deck)
    data object Random : Screen("random", R.string.random, R.drawable.random)
    data object Search : Screen("search", R.string.search, R.drawable.search)
}

val bottomNavItems = listOf(
    Screen.Magic,
    Screen.Albums,
    Screen.Decks,
    Screen.Random,
    Screen.Search
)

@Composable
fun AppBottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        bottomNavItems.forEach { screen ->
            val interactionSource = remember { MutableInteractionSource() }
            val isCurrentScreen = currentRoute == screen.route
            val iconSize by animateDpAsState(
                targetValue = if (isCurrentScreen) 34.dp else 24.dp,
                animationSpec = tween(durationMillis = 300)
            )
            val textSize by animateFloatAsState(
                targetValue = if (isCurrentScreen) 14f else 12f,
                animationSpec = tween(durationMillis = 300)
            )

            NavigationBarItem(
                icon = {
                    Box(
                        modifier = Modifier
                            .background(
                                color = if (isCurrentScreen) Color.Transparent else Color.Transparent,
                            )
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(iconSize),
                            painter = painterResource(id = screen.icon),
                            contentDescription = stringResource(screen.title),
                            tint = if (isCurrentScreen) primaryLight else outlineLight
                        )
                    }
                },
                label = {
                    Text(
                        stringResource(screen.title),
                        style = TextStyle(
                            fontSize = textSize.sp,
                            fontWeight = if (isCurrentScreen) FontWeight.Bold else FontWeight.Normal
                        ),
                    )
                },
                selected = isCurrentScreen,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = primaryLight,
                    selectedTextColor = primaryLight,
                    unselectedIconColor = outlineLight,
                    unselectedTextColor = outlineLight,
                    indicatorColor = Color.Transparent
                ),
                interactionSource = interactionSource
            )
        }
    }
}
