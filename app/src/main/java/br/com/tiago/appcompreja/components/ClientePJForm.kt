package br.com.tiago.appcompreja.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tiago.appcompreja.R
import br.com.tiago.appcompreja.database.repository.ClientePJRepository
import br.com.tiago.appcompreja.model.ClientePJ

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientePJForm(
    nome: String,
    cnpj: String,
    endereco: String,

    onNomeChange: (String) -> Unit,
    onCnpjChange: (String) -> Unit,
    onEnderecoChange: (String) -> Unit,


    atualizar: () -> Unit
) {
    val context = LocalContext.current
    val clientePJRepository = ClientePJRepository(context)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 32.dp)

    )
    {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 0.dp, max = 450.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xfff9f6f6)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {


            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())

            ) {
                Text(
                    text = "Cadastro de Cliente",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.laranja)
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nome,
                    onValueChange = { onNomeChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Nome do Cliente",
                            color = colorResource(id = R.color.laranja)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words
                    ),

                    )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = cnpj,
                    onValueChange = { onCnpjChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "CNPJ",
                            color = colorResource(id = R.color.laranja),

                            )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)

                )

                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = endereco,
                    onValueChange = { onEnderecoChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Endereço",
                            color = colorResource(id = R.color.laranja)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
                Spacer(modifier = Modifier.height(8.dp))
             }

                Button(
                    onClick = {
                        val clientePJ = ClientePJ(
                            nome = nome,
                            cnpj = cnpj,
                            endereco = endereco,

                        )
                        clientePJRepository.salvar(clientePJ)
                        atualizar()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.branco_creme),
                        contentColor = colorResource(id = R.color.laranja)
                    )
                ) {
                    Text(
                        text = "CADASTRAR",
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }
        }

}
