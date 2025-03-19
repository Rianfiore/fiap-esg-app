package br.com.fiap.compareja.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.compareja.R

@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFEF8EB)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 📌 Título no topo
            Text(
                text = "Encontre sua Economia",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 32.dp)
            )

            Spacer(modifier = Modifier.height(16.dp)) // Espaço entre título e botão

            // 📌 Botão um pouco mais acima
            Button(
                onClick = { /* Ação do botão */ },
                modifier = Modifier
                    .width(200.dp)
                    .padding(bottom = 40.dp), // Move o botão para cima
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6D00)
                )
            ) {
                Text(
                    text = "Ver lista",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp)) // Espaço entre botão e imagem

            // 📌 Imagem abaixo do botão
            val image: Painter = painterResource(id = R.drawable.map)
            androidx.compose.foundation.Image(
                painter = image,
                contentDescription = "Mapa",
                modifier = Modifier
                    .width(400.dp)
                    .height(500.dp)
            )
        }

        // 📌 Bottom Navigation Bar
        BottomNavigationBar()
    }
}

@Composable
fun BottomNavigationBar() {
    androidx.compose.material3.BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xFFFF6D00) // Fundo laranja
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Ação Home */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    tint = Color.White
                )
            }
            IconButton(onClick = { /* Ação Carrinho */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.carrinho),
                    contentDescription = "Carrinho",
                    tint = Color.White
                )
            }
            IconButton(onClick = { /* Ação Perfil */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Perfil",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MapScreenPreview() {
    MapScreen()
}
