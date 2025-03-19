package br.com.fiap.compareja.screens.market_store

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.*
import br.com.fiap.compareja.ui.theme.*

@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(BrancoPuro)
            .border(1.dp, color = LaranjaClaro, shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            textStyle = TextStyle(fontSize = 16.sp),
            modifier = Modifier.fillMaxWidth().padding(end = 40.dp).align(Alignment.Center)
        )
        if (searchText.isEmpty()) {
            Text(
                "Pesquisar por palavra-chave",
                color = LaranjaClaro,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .align(Alignment.Center)

            )
        }

        IconButton(
            onClick = { /* Realizar ação de busca */ },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Buscar",
                tint = LaranjaClaro
            )
        }
    }
}




