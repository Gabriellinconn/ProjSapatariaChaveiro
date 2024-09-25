package br.edu.up.planner.ui.screens.chaveiro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.planner.ui.screens.util.SECTopBar
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object ChavesRota {
    val TELA_LISTAR_CHAVES_ROTA = "listar_chaves"
    val TELA_INCLUIR_CHAVES_ROTA = "incluir_chaves"
}


@Composable
fun TelaChavesAfazer(
    drawerState: DrawerState,
) {

    var serviçosChaves = mutableListOf(
        ChavesAfazer(
            modelochave = "Chave Papaiz",
            cliente = "Wellinton",
            preco = 24.00,
            formaPagamento = 1,
            tipo = 1,
            concluido = false,
            pago = true,
            id = 1,
            quantidade = 2
        ),
        ChavesAfazer(
            modelochave = "Chave GOLD",
            cliente = "Cleber",
            preco = 18.00,
            formaPagamento = 2,
            tipo = 2,
            concluido = true,
            pago = false,
            id = 2,
            quantidade = 1
        ),
        ChavesAfazer(
            modelochave = "Aliança",
            cliente = "Junior",
            preco = 36.00,
            formaPagamento = 3,
            tipo = 1,
            concluido = false,
            pago = false,
            id = 3,
            quantidade = 1
        ),
    )

    val navCtrlTarefas = rememberNavController()


    Scaffold(
        topBar = { SECTopBar(drawerState) },
        content = { padding ->  padding
            NavHost(
                navController = navCtrlTarefas,
                startDestination = ChavesRota.TELA_LISTAR_CHAVES_ROTA)
            {
                composable(ChavesRota.TELA_LISTAR_CHAVES_ROTA) {
                    TelaListagemChaves(serviçosChaves)
                }
                composable(ChavesRota.TELA_INCLUIR_CHAVES_ROTA) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(200.dp))
                        Text(text = "TELA DE INCLUIR AFAZER")
                    }

                }
            }


        },
        floatingActionButton = { FloatButton() },
        )
}

@Composable
private fun TelaListagemChaves(chavesAfazer: MutableList<ChavesAfazer>) {

    LazyColumn(

        modifier = Modifier.padding(top = 70.dp).padding(bottom = 90.dp).fillMaxSize(),

        contentPadding = PaddingValues(16.dp)

    ) {


        items(chavesAfazer) { chavesAfazer ->



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
                        text = chavesAfazer.modelochave,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = if(chavesAfazer.tipo == 1) "Chave Normal" else "Chave Tetra",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 0.dp)
                    )

                    Text(
                        text = "${chavesAfazer.quantidade}",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = chavesAfazer.cliente,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    Text(
                        text = "#${chavesAfazer.id}",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "R$ ${chavesAfazer.preco}",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = when (chavesAfazer.formaPagamento) {
                                1 -> "Dinheiro"
                                2 -> "Cartão"
                                3 -> "Pix"
                                else -> "Não informado"
                            },
                            fontSize = 16.sp
                        )

                        Text(
                            text = if (chavesAfazer.pago) "Pago" else "Não pago",
                            color = if (chavesAfazer.concluido) Color.Red else Color.Green,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Text(
                        text = if (chavesAfazer.concluido) "Concluído" else "Pendente",
                        color = if (chavesAfazer.concluido) Color.Green else Color.Yellow,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}



data class ChavesAfazer(
    var pago: Boolean,
    var modelochave: String,
    var cliente: String,
    var concluido: Boolean = false,
    var preco: Double,
    var formaPagamento: Int? = null, //1 = dinheiro, 2 = cartão, 3 = pix, 4 = não informado
    var tipo: Int , //1 = normal, 2 = tetra
    var quantidade: Int,
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


