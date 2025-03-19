package br.com.fiap.compareja.screens.market_store

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import br.com.fiap.compareja.ui.theme.Laranja

data class Product(val name: String, val price: String, val brand: String, val unit: String, val priceChangeLevel: PriceChangeLevel)


@Composable
fun Category(title: String, products: List<Product>) {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, fontSize = 18.sp, color = Laranja, fontWeight = FontWeight.Bold)
            Text("Ver mais", fontSize = 14.sp, color = Laranja)
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            products.forEach { product ->
                ProductCard(
                    name = product.name,
                    price = product.price,
                    brand = product.brand,
                    unit = product.unit,
                    priceChangeLevel = product.priceChangeLevel
                )
            }
        }
    }
}