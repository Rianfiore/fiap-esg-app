package br.com.fiap.compareja.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductStockScreen() {
//    Criar tela de Estoque aqui
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFED145B))
        .padding(32.dp)){
        Text(text = "Estoque de produtos", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}