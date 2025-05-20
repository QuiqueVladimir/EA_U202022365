package upc.edu.template.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import upc.edu.template.presentation.di.PresentationModule
import upc.edu.template.presentation.view.EventoView


@Preview
@Composable
fun Home(){
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            icon = Icons.Default.Home,
            title = "eventos",
            route = "eventos"
        ),
        NavigationItem(
            icon = Icons.Default.Favorite,
            title = "mis eventos",
            route = "favorites"
        ),
    )

    val selectedIndex = remember {
        mutableIntStateOf(0)
    }

    val searchEventoViewModel = PresentationModule.getSearchEventoViewModel()
    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed{index, item ->
                    NavigationBarItem(
                        selected = selectedIndex.intValue == index,
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        onClick = {
                            selectedIndex.intValue = index
                            navController.navigate(item.route)
                        },
                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController,
            startDestination = "eventos",
            modifier = Modifier.padding(padding)
        ){
            composable("eventos") {
                EventoView(viewModel = searchEventoViewModel) { eventoId: Int ->
                    navController.navigate("eventos/$eventoId")
                }
            }
            composable("mis_eventos"){
                // Aquí va el contenido de la pantalla 3
            }
        }
    }

}

data class NavigationItem(
    val icon: ImageVector,
    val title: String,
    val route: String
)