package pol.rubiano.magicapp2.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose.onPrimaryContainerLight
import com.example.compose.primaryContainerLight
import pol.rubiano.magicapp2.ui.navigation.bottomNavItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(navController: NavController) {
     //val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

     val navBackStackEntry by navController.currentBackStackEntryAsState()
     val currentRoute = navBackStackEntry?.destination?.route
     val currentScreen = bottomNavItems.find { it.route == currentRoute }
     val showBackButton = currentScreen == null

     androidx.compose.material3.TopAppBar(
          colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
               containerColor = primaryContainerLight,
               titleContentColor = onPrimaryContainerLight,
          ),
//          navigationIcon = {
//               if (showBackButton) {
//                    IconButton(
//                         onClick = {navController.popBackStack() }
//                    ) {
//                         Icon(
//                              Icons.AutoMirrored.Filled.ArrowBack,
//                              contentDescription = "Back",
//                              tint = MaterialTheme.colorScheme.primary
//                         )
//                    }
//               }
//          },
          title = {
               Text(
                    text = currentScreen?.let { stringResource(it.title) } ?: "Magic App",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
               )
          },
          actions = {
//               if (showBackButton) {
//                    IconButton(
//                         onClick = {navController.popBackStack() }
//                    ) {
//                         Icon(
//                              Icons.AutoMirrored.Filled.ArrowBack,
//                              contentDescription = "Back",
//                              tint = MaterialTheme.colorScheme.primary
//                         )
//                    }
//               }
          },
          //scrollBehavior = scrollBehavior,
     )
}
