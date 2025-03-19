package br.com.tiago.fiap_esg_app.produto

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.tiago.appcompreja.R
import br.com.tiago.appcompreja.components.ProdutoForm
import br.com.tiago.appcompreja.components.ProdutoList
import br.com.tiago.appcompreja.database.repository.ProdutoRepository


@Composable
fun ProdutosScreen(navController: NavHostController) {

    val context = LocalContext.current
    val produtoRepository = ProdutoRepository(context)

    var nomeState = remember { mutableStateOf("") }
    var marcaState = remember { mutableStateOf("") }
    var estoqueState = remember { mutableStateOf("") }
    var precoState = remember { mutableStateOf("") }
    var descricaoState = remember { mutableStateOf("") }
    var categoriaState = remember { mutableStateOf("") }
    var codigoBarraState = remember { mutableStateOf("") }
    var precoPromocionalState = remember { mutableStateOf("") }
    var promocaoState = remember { mutableStateOf(false) }
    var listaProdutosState = remember { mutableStateOf(produtoRepository.listarProdutos()) }

    Column (
        modifier = Modifier.padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 16.dp) // espaçamento do topo e laterais

    ){
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick =
            { navController.navigate("clientes") },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text(
                text = "Voltar",
                fontSize = 20.sp,
                color = colorResource(id = R.color.laranja)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Column {
            ProdutoForm(
                nome = nomeState.value,
                marca = marcaState.value,
                estoque = estoqueState.value,
                preco = precoState.value,
                descricao = descricaoState.value,
                categoria = categoriaState.value,
                codigoBarra = codigoBarraState.value,
                precoPromocional = precoPromocionalState.value,
                promocao = promocaoState.value,

                onNomeChange = { nomeState.value = it },
                onMarcaChange = { marcaState.value = it },
                onEstoqueChange = { estoqueState.value = it },
                onPrecoChange = { precoState.value = it },
                onDescricaoChange = { descricaoState.value = it },
                onCategoriaChange = { categoriaState.value = it },
                onCodigoBarraChange = { codigoBarraState.value = it },
                onPrecoPromocionalChange = { precoPromocionalState.value = it },
                onPromocaoChange = { promocaoState.value = it },
                atualizar = { listaProdutosState.value = produtoRepository.listarProdutos() }
            )
            ProdutoList(listaProdutosState.value) {
                listaProdutosState.value = produtoRepository.listarProdutos()
            }
        }
    }
}