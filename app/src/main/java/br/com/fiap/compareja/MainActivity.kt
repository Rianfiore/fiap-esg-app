package br.com.fiap.compareja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.fiap.compareja.screens.map.MapScreen
import br.com.fiap.compareja.ui.theme.CompareJaTheme
import br.com.fiap.compareja.screens.market_store.MarketStoreScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompareJaTheme {
                Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MarketStoreScreen()
                }
            }
        }
    }
}