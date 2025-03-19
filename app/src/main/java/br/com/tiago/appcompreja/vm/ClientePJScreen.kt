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
import br.com.tiago.appcompreja.components.ClientePJForm
import br.com.tiago.appcompreja.components.ClientePJList
import br.com.tiago.appcompreja.database.repository.ClientePJRepository

@Composable
fun ClientePJScreen(navController: NavHostController) {

    val context = LocalContext.current
    val clientePJRepository = ClientePJRepository(context)

    var nomeState = remember { mutableStateOf("") }
    var cnpjState = remember { mutableStateOf("") }
    var enderecoState = remember { mutableStateOf("") }

    var listaClientePJState = remember { mutableStateOf(clientePJRepository.listarClientesPJ()) }

    Column (
        modifier = Modifier.padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 16.dp) // espaçamento do topo e laterais

    ){
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick =
            { navController.navigate("produtos") },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text(
                text = "Voltar",
                fontSize = 20.sp,
                color = colorResource(id = R.color.laranja)
            )
        }
        Column {
            Spacer(modifier = Modifier.height(24.dp))


            ClientePJForm(
                nome = nomeState.value,
                cnpj = cnpjState.value,
                endereco = enderecoState.value,


                onNomeChange = { nomeState.value = it },
                onCnpjChange = { cnpjState.value = it },
                onEnderecoChange = { enderecoState.value = it },

                atualizar = { listaClientePJState.value = clientePJRepository.listarClientesPJ() }
            )
            ClientePJList(listaClientePJState.value) {
                listaClientePJState.value = clientePJRepository.listarClientesPJ()
            }
        }
    }
}