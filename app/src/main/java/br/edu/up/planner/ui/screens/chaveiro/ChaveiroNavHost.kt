package br.edu.up.planner.ui.screens.sapataria

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object TelaDois {
    val TELA_CHAVBIRO_ROUTE = "t1a"

}


@Composable
fun ChaveiroNavHost(drawerState: DrawerState) {

    val navCtrlBottonNav = rememberNavController()
    NavHost(
        navController = navCtrlBottonNav,
        startDestination = TelaUm.TELA_SAPATARIA_ROUTE
    ) {
        composable(TelaDois.TELA_CHAVBIRO_ROUTE) {
            TelaSapatosAfazer(drawerState, navCtrlBottonNav)
        }
    }
}



