package br.edu.up.secb.ui.screens.sapataria

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
<<<<<<< HEAD:app/src/main/java/br/edu/up/planner/ui/screens/sapataria/TelaSapatosAfazer.kt
import br.edu.up.planner.ui.screens.util.SECTopBar
import kotlinx.coroutines.launch
=======
import br.edu.up.secb.dados.SapatosAfazer
import br.edu.up.secb.ui.screens.util.SECTopBar
import br.edu.up.secb.ui.screens.util.TelaUmBottomBar
>>>>>>> b59b9db2de010cc4130b255da9ba2684c24a7a86:app/src/main/java/br/edu/up/secb/ui/screens/sapataria/TelaSapatosAfazer.kt

// Rotas
object SapatosRota {
    const val TELA_LISTAR_SAPATOS_ROTA = "listar_sapatos"
    const val TELA_INCLUIR_SAPATOS_ROTA = "incluir_sapatos"
}

<<<<<<< HEAD:app/src/main/java/br/edu/up/planner/ui/screens/sapataria/TelaSapatosAfazer.kt
// Dados do sapato
data class SapatosAfazer(
    var pago: Boolean,
    var nomeSapato: String,
    var descricao: String,
    var concluido: Boolean = false,
    var preco: Double,
    var formaPagamento: Int, // 1 = dinheiro, 2 = cartão, 3 = pix, 4 = não informado
    var par: Boolean = false,
    var id: Int? = null
)
=======

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




>>>>>>> b59b9db2de010cc4130b255da9ba2684c24a7a86:app/src/main/java/br/edu/up/secb/ui/screens/sapataria/TelaSapatosAfazer.kt

// Tela principal
@Composable
<<<<<<< HEAD:app/src/main/java/br/edu/up/planner/ui/screens/sapataria/TelaSapatosAfazer.kt
fun TelaSapatosAfazer(drawerState: DrawerState, navController: NavHostController) {
    val serviçosSapatos = mutableListOf(
        SapatosAfazer(pago = true, nomeSapato = "Tênis Nike", preco = 18.00, formaPagamento = 1, par = false, concluido = false, descricao = "Reparar sola", id = 1),
        SapatosAfazer(pago = false, nomeSapato = "Tênis Adidas", preco = 50.00, formaPagamento = 4, par = true, concluido = true, descricao = "Trocar cadarço", id = 2)
    )

    val navCtrlSapatos = rememberNavController()

    Scaffold(
        topBar = { SECTopBar(drawerState) },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                NavHost(
                    navController = navCtrlSapatos,
                    startDestination = SapatosRota.TELA_LISTAR_SAPATOS_ROTA
                ) {
                    composable(SapatosRota.TELA_LISTAR_SAPATOS_ROTA) {
                        TelaListagemSapatos(sapatosAfazer = serviçosSapatos)
                    }
                    composable(SapatosRota.TELA_INCLUIR_SAPATOS_ROTA) {
                        TelaIncluirSapatos(navController = navCtrlSapatos)
                    }
                }
            }
        },
        floatingActionButton = { FloatButton(navController = navCtrlSapatos) }
    )
}

// Tela de listagem
@Composable
fun TelaListagemSapatos(sapatosAfazer: List<SapatosAfazer>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(sapatosAfazer) { sapato ->
            SapatoCard(sapatoAfazer = sapato)
        }
=======
private fun FloatButton() {
    FloatingActionButton(onClick = { navController.navigate("incluirAfazeres")}) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "+"
        )
>>>>>>> b59b9db2de010cc4130b255da9ba2684c24a7a86:app/src/main/java/br/edu/up/secb/ui/screens/sapataria/TelaSapatosAfazer.kt
    }
}

// Card de um sapato
@Composable
fun SapatoCard(sapatoAfazer: SapatosAfazer) {
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
                text = "ID: #${sapatoAfazer.id}",
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = if (sapatoAfazer.par) "Par" else "Um pé",
                fontSize = 16.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "R$ ${sapatoAfazer.preco}",
                    fontSize = 16.sp
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
                    color = if (sapatoAfazer.concluido) Color.Green else Color.Red,
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

// Tela de inclusão
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaIncluirSapatos(navController: NavController) {
    var nomeCliente by remember { mutableStateOf("") }
    var tipoSapato by remember { mutableStateOf("") }
    var tarefa by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Adicionar Pedido", fontSize = 24.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = nomeCliente,
            onValueChange = { nomeCliente = it },
            label = { Text("Nome do Cliente") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = tipoSapato,
            onValueChange = { tipoSapato = it },
            label = { Text("Tipo de Sapato") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = tarefa,
            onValueChange = { tarefa = it },
            label = { Text("O que precisa fazer") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Adiciona o sapato
            val sapatoSalvar = SapatosAfazer(
                pago = false,
                nomeSapato = tipoSapato,
                descricao = tarefa,
                concluido = false,
                preco = 100.0, // preço fixo de exemplo
                formaPagamento = 1, // tipo de pagamento
                par = true // supondo que o sapato seja par
            )
            // Salvar o sapato no repositório (futuramente)
            // Exemplo: viewModel.gravar(sapatoSalvar)
            navController.popBackStack()
        }) {
            Text("Adicionar Pedido")
        }
    }
}

// Botão flutuante
@Composable
fun FloatButton(navController: NavController) {
    FloatingActionButton(onClick = {
        navController.navigate(SapatosRota.TELA_INCLUIR_SAPATOS_ROTA)
    }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Adicionar"
        )
    }
}
