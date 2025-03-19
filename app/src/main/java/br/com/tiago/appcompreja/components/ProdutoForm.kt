package br.com.tiago.appcompreja.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import br.com.tiago.appcompreja.database.repository.ProdutoRepository
import br.com.tiago.appcompreja.model.Produto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdutoForm(
    nome: String,
    marca: String,
    estoque: String,
    preco: String,
    descricao: String,
    categoria: String,
    codigoBarra: String,
    precoPromocional: String,
    promocao: Boolean,

    onNomeChange: (String) -> Unit,
    onMarcaChange: (String) -> Unit,
    onEstoqueChange: (String) -> Unit,
    onPrecoChange: (String) -> Unit,
    onDescricaoChange: (String) -> Unit,
    onCategoriaChange: (String) -> Unit,
    onCodigoBarraChange: (String) -> Unit,
    onPrecoPromocionalChange: (String) -> Unit,
    onPromocaoChange: (Boolean) -> Unit,
    atualizar: () -> Unit
) {
    val context = LocalContext.current
    val produtoRepository = ProdutoRepository(context)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 32.dp) // Espaço em cima e embaixo

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
                    text = "Cadastro de produtos",
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
                            text = "Nome do produto",
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
                    value = marca,
                    onValueChange = { onMarcaChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Marca",
                            color = colorResource(id = R.color.laranja),

                            )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = preco,
                    onValueChange = { onPrecoChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Preço",
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
                OutlinedTextField(
                    value = estoque,
                    onValueChange = { onEstoqueChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Estoque",
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

                OutlinedTextField(
                    value = descricao,
                    onValueChange = { onDescricaoChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Descrição",
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
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = categoria,
                    onValueChange = { onCategoriaChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Categoria",
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
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = codigoBarra,
                    onValueChange = { onCodigoBarraChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Código de barras",
                            color = colorResource(id = R.color.laranja)

                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    )

                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = precoPromocional,
                    onValueChange = { onPrecoPromocionalChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Preço Promocional",
                            color = colorResource(id = R.color.laranja)

                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = colorResource(id = R.color.laranja),
                        focusedBorderColor = colorResource(id = R.color.laranja)
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    )

                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = promocao, onCheckedChange = {
                            onPromocaoChange(it)
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = colorResource(id = R.color.laranja),
                            uncheckedColor = colorResource(id = R.color.laranja),
                            checkmarkColor = colorResource(id = R.color.branco_creme)
                        )
                    )
                    Text(
                        text = "Em promoção",
                        color = colorResource(id = R.color.laranja)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        val produto = Produto(
                            nome = nome,
                            marca = marca,
                            preco = preco,
                            estoque = estoque,
                            descricao = descricao,
                            categoria = categoria,
                            codigoBarra = codigoBarra,
                            precoPromocional = precoPromocional,
                            isPromocao = promocao
                        )
                        produtoRepository.salvar(produto)
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
}
