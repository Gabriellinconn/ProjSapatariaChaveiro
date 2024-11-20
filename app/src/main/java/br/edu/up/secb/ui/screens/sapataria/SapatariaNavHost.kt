package br.edu.up.secb.ui.screens.sapataria

//import androidx.compose.material3.DrawerState
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//
//object TelaUm {
//    val TELA_SAPATARIA_ROUTE = "t1a"
//    val TELA_PAGAMENTOS_ROUTE = "t1b"
//    val TELA_REALIZADOS_ROUTE = "t1c"
//}
//
//
//@Composable
//fun SapatariaNavHost(drawerState: DrawerState) {
//
//    val navCtrlBottonNav = rememberNavController()
//    NavHost(
//        navController = navCtrlBottonNav,
//        startDestination = TelaUm.TELA_SAPATARIA_ROUTE
//    ) {
//        composable(TelaUm.TELA_SAPATARIA_ROUTE) {
//            TelaSapatosAfazer(drawerState, navCtrlBottonNav)
//        }
//        composable(TelaUm.TELA_PAGAMENTOS_ROUTE) {
//            TelaPagamentos(drawerState, navCtrlBottonNav)
//        }
//        composable(TelaUm.TELA_REALIZADOS_ROUTE) {
//            TelaRealizados(drawerState, navCtrlBottonNav)
//        }
//    }
//}
//

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.secb.IncluirEditarPedido

@Composable
fun SapatariaNavHost(
    //db: AfazerDatabase
    viewModel: SapatosAfazerViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "listarAfazeres")
    {
        composable("listarSapatosAfazer") {
            TelaSapatosAfazer(viewModel, navController)
        }
        composable("incluirPedido") {
            IncluirEditarPedido(viewModel = viewModel, navController = navController)
        }
        composable("editarSapato/{sapatoId}") { navRequest ->
            val afazerId = navRequest.arguments?.getString("afazerId")
            IncluirEditarPedido(sapatoId?.toInt(), viewModel, navController)
        }
    }
}

