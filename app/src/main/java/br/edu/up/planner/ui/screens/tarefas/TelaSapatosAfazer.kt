package br.edu.up.planner.ui.screens.tarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import br.edu.up.planner.ui.screens.util.TelaUmBottomBar

object TarefasRota {
    val TELA_LISTAR_AFAZERES_ROTA = "listar_afazeres"
    val TELA_INCLUIR_AFAZER_ROTA = "incluir_afazer"
}


@Composable
fun TelaAfazeres(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {

    var serviços = mutableListOf(
        SapatosAfazer(


            nomeSapato = "Tênis Nike",
            descricao = "Colar Sola",
            preco = 18.00,
            formaPagamento = 1,
            par = false,
            concluido = false,
            id = 1
        ),
        SapatosAfazer(
            nomeSapato = "Sapato Feminino",
            descricao = "Restaurar Taco e Sola",
            preco = 50.00,
            formaPagamento = 2,
            par = true,
            concluido = true,
            id = 2
        )
    )

    val navCtrlTarefas = rememberNavController()


    Scaffold(
        topBar = { PlannerTopBar(drawerState) },
        content = { padding ->  padding
            NavHost(
                navController = navCtrlTarefas,
                startDestination = TarefasRota.TELA_LISTAR_AFAZERES_ROTA)
            {
                composable(TarefasRota.TELA_LISTAR_AFAZERES_ROTA) {
                    TelaListagemAfazeres(serviços)
                }
                composable(TarefasRota.TELA_INCLUIR_AFAZER_ROTA) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(200.dp))
                        Text(text = "TELA DE INCLUIR AFAZER")
                    }

                }
            }


        },
        floatingActionButton = { FloatButton() },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}

@Composable
private fun TelaListagemAfazeres(sapatosAfazer: MutableList<SapatosAfazer>) {
    LazyColumn(
        modifier = Modifier.padding(top = 70.dp). fillMaxSize(),

        contentPadding = PaddingValues(16.dp)
    ) {
        items(sapatosAfazer) { sapatoAfazer ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp),

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = sapatoAfazer.nomeSapato,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    Text(
                        text = sapatoAfazer.descricao,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    Text(
                        text = if(sapatoAfazer.par) "Par" else "Um pé",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 0.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "R$ ${sapatoAfazer.preco}",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = when (sapatoAfazer.formaPagamento) {
                                1 -> "Dinheiro"
                                2 -> "Cartão"
                                3 -> "Pix"
                                else -> "Outra Forma de Pagamento"
                            },
                            fontSize = 16.sp
                        )
                    }

                    Text(
                        text = if (sapatoAfazer.concluido) "Concluído" else "Pendente",
                        color = if (sapatoAfazer.concluido) Color.Green else Color.Yellow,
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }
        }
    }
}



data class SapatosAfazer(
    var nomeSapato: String,
    var descricao: String,
    var concluido: Boolean = false,
    var preco: Double,
    var formaPagamento: Int, //1 = dinheiro, 2 = cartão, 3 = pix.
    var par: Boolean = false,
    var id: Int? = null
)


@Composable
private fun FloatButton() {
    FloatingActionButton(onClick = { }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "+"
        )
    }
}


