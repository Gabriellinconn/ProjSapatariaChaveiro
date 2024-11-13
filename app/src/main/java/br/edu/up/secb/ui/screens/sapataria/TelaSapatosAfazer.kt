package br.edu.up.secb.ui.screens.sapataria

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
import br.edu.up.secb.dados.SapatosAfazer
import br.edu.up.secb.ui.screens.util.SECTopBar
import br.edu.up.secb.ui.screens.util.TelaUmBottomBar

object SapatosRota {
    val TELA_LISTAR_SAPATOS_ROTA = "listar_sapatos"
    val TELA_INCLUIR_SAPATOS_ROTA = "incluir_sapatos"
}


@Composable
fun TelaSapatosAfazer(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {

    var serviçosSapatos = mutableListOf(
        SapatosAfazer(


            nomeSapato = "Tênis Nike",
            descricao = "Colar Sola",
            preco = 18.00,
            formaPagamento = 1,
            par = false,
            concluido = false,
            pago = true,
            sapatoId = 1
        ),
        SapatosAfazer(


            nomeSapato = "Tênis Nike",
            descricao = "Colar Sola",
            preco = 18.00,
            formaPagamento = 1,
            par = false,
            concluido = false,
            pago = true,
            sapatoId = 1
        ),
        SapatosAfazer(


            nomeSapato = "Tênis Nike",
            descricao = "Colar Sola",
            preco = 18.00,
            formaPagamento = 1,
            par = false,
            concluido = false,
            pago = true,
            sapatoId = 1
        ),
        SapatosAfazer(


            nomeSapato = "Tênis Nike",
            descricao = "Colar Sola",
            preco = 18.00,
            formaPagamento = 1,
            par = false,
            concluido = false,
            pago = true,
            sapatoId = 1
        ),
        SapatosAfazer(


            nomeSapato = "Tênis Nike",
            descricao = "Colar Sola",
            preco = 18.00,
            formaPagamento = 1,
            par = false,
            concluido = false,
            pago = true,
            sapatoId = 1
        ),
        SapatosAfazer(
            nomeSapato = "Sapato Feminino",
            descricao = "Restaurar Taco e Sola",
            preco = 50.00,
            formaPagamento = 4,
            par = true,
            concluido = true,
            pago = false,
            sapatoId = 2
        )
    )

    val navCtrlSapatos = rememberNavController()


    Scaffold(
        topBar = { SECTopBar(drawerState) },
        content = { padding ->  padding
            NavHost(
                navController = navCtrlSapatos,
                startDestination = SapatosRota.TELA_LISTAR_SAPATOS_ROTA)
            {
                composable(SapatosRota.TELA_LISTAR_SAPATOS_ROTA) {
                    TelaListagemSapatos(serviçosSapatos)
                }
                composable(SapatosRota.TELA_INCLUIR_SAPATOS_ROTA) {
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
private fun TelaListagemSapatos(sapatosAfazer: MutableList<SapatosAfazer>) {

    LazyColumn(

        modifier = Modifier.padding(top = 70.dp).padding(bottom = 90.dp).fillMaxSize(),

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
                        text = "#${sapatoAfazer.sapatoId}",
                        fontSize = 14.sp,
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
                            .padding(vertical = 5.dp),
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
                                else -> "Não informado"
                            },
                            fontSize = 16.sp
                        )

                        Text(
                            text = if (sapatoAfazer.pago) "Pago" else "Não pago",
                            color = if (sapatoAfazer.concluido) Color.Red else Color.Green,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Text(
                        text = if (sapatoAfazer.concluido) "Concluído" else "Pendente",
                        color = if (sapatoAfazer.concluido) Color.Green else Color.Yellow,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}






@Composable
private fun FloatButton() {
    FloatingActionButton(onClick = { navController.navigate("incluirAfazeres")}) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "+"
        )
    }
}


