package br.com.tiago.appcompreja.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tiago.appcompreja.R
import br.com.tiago.appcompreja.database.repository.ClientePJRepository
import br.com.tiago.appcompreja.database.repository.ProdutoRepository
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto

@Composable
fun ClientePJCard(
    clientePJ: ClientePJ,
    context: Context,
    atualizar: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.branco_creme))

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(2f)
            ) {
                Text(text = "Nome: ${clientePJ.nome}", fontSize = 16.sp)
                Text(text = "CNPJ: ${clientePJ.cnpj}", fontSize = 16.sp)
                Text(text = "Endereço: ${clientePJ.endereco}", fontSize = 16.sp)



            }
            IconButton(onClick = {
                val clientePJRepositoryRepository = ClientePJRepository(context)
                clientePJRepositoryRepository.excluir(clientePJ)
                atualizar()
            }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Excluir produto")
            }
        }
    }
}
