package br.com.fiap.compareja.screens.market_store

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import br.com.fiap.compareja.ui.theme.*

@Composable
fun MarketInfoCard() {
    Box(modifier = Modifier.fillMaxWidth().padding(start = 48.dp, end = 48.dp).offset(y = (-40).dp), contentAlignment = Alignment.Center ) {

        Card(
            modifier = Modifier
                .border(1.dp, color = LaranjaClaro, shape = RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = BrancoPuro
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp).padding(top = 40.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column( modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "Super Market - Mercado",
                        fontSize = 20.sp,
                        color = Laranja,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 4.dp),
                        thickness = 1.dp,
                        color = CinzaClaro
                    )

                    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Text("1,2 km • Preço: ", fontSize = 14.sp, color = Color.Gray)
                        Text("$$$", fontSize = 14.sp, color = Laranja)
                        Text("$$", fontSize = 14.sp, color = Color.LightGray)
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 4.dp),
                        thickness = 1.dp,
                        color = CinzaClaro
                    )

                    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Avaliação",
                            tint = Laranja,
                            modifier = Modifier.size(16.dp).align(Alignment.CenterVertically).offset(y = (-1).dp)
                        )
                        Text("4.8 ", fontSize = 14.sp, color = Laranja)
                        Text("(1.2 mil avaliações)", fontSize = 14.sp, color = Color.LightGray)
                    }
                }

                Button(
                    onClick = { /* Ver no mapa */ },
                    modifier = Modifier.padding(top = 8.dp).align(Alignment.CenterHorizontally)
                ) {
                    Text("Ver endereço no mapa")
                }

            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-40).dp)
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(color = Color.LightGray, shape = CircleShape)
                    .border(2.dp, color = LaranjaClaro, shape = CircleShape)
            )
        }

    }
}