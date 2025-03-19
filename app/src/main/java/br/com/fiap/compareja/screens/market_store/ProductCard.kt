package br.com.fiap.compareja.screens.market_store

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import br.com.fiap.compareja.ui.theme.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*

enum class PriceChangeLevel {
    HIGH,
    NORMAL,
    LOW
}

@Composable
fun ProductCard(
    name: String,
    price: String,
    brand: String,
    unit: String,
    priceChangeLevel: PriceChangeLevel
) {
    Box(modifier = Modifier.width(120.dp)) {
        Column {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .size(120.dp)
                    .padding(4.dp)
                    .border(1.dp, LaranjaClaro, RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                ) {

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(8.dp)
                            .background(
                                color = when (priceChangeLevel) {
                                    PriceChangeLevel.HIGH -> Color(0xFFE57373)
                                    PriceChangeLevel.NORMAL -> Color(0xFF9E9E9E)
                                    PriceChangeLevel.LOW -> Color(0xFF81C784)
                                },
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(start = 4.dp, end = 8.dp)
                    ) {
                        when (priceChangeLevel) {
                            PriceChangeLevel.HIGH -> {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Arrow Up", tint = Color.White, modifier = Modifier.size(20.dp))
                                    Text("Preço alto", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                            PriceChangeLevel.NORMAL -> {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "Dash", tint = Color.White, modifier = Modifier.size(20.dp))
                                    Text("Preço méd.", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                            PriceChangeLevel.LOW -> {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Arrow Down", tint = Color.White, modifier = Modifier.size(20.dp))
                                    Text("Preço baixo", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.padding(start = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row {
                    Text(
                        price,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Laranja,
                        lineHeight = 20.sp
                    )
                    Text(
                        "/",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = Laranja,
                        lineHeight = 20.sp
                    )
                    Text(
                        unit,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = Laranja,
                        lineHeight = 20.sp
                    )
                }

                Column {
                    Text(
                        name,
                        fontSize = 12.sp,
                        color = Laranja,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 16.sp
                    )
                    Text(
                        brand,
                        fontSize = 12.sp,
                        color = LaranjaClaro,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 16.sp
                    )
                }
            }

        }
    }
}
