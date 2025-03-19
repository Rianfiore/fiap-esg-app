package br.com.fiap.compareja.screens.market_store

import TopBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.fiap.compareja.ui.theme.BrancoPuro

@Composable
fun MarketStoreScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BrancoPuro)
            .verticalScroll(scrollState)
    ) {
        TopBar()

        MarketInfoCard()

        SearchBar()

        Category("Hortifruti", listOf(
            Product("Cebolinha", "R$ 1,90", "Hortcultura", "un", PriceChangeLevel.HIGH),
            Product("Tomate Italiano", "R$ 3,90", "Red Velvet", "kg", PriceChangeLevel.LOW),
            Product("Laranja Pera", "R$ 10,80", "Orange Inc.", "un", PriceChangeLevel.NORMAL)
        ))

        Category("Açougue", listOf(
            Product("Alcatra", "R$ 30,00", "Carne Prime", "kg", PriceChangeLevel.HIGH),
            Product("Linguiça Toscana", "R$ 15,50", "Sabor Real", "kg", PriceChangeLevel.NORMAL),
            Product("Peito de Frango", "R$ 18,90", "Frango Bom", "kg", PriceChangeLevel.LOW)
        ))

        Category("Laticínios", listOf(
            Product("Leite Integral", "R$ 3,50", "Leite Natural", "litro", PriceChangeLevel.NORMAL),
            Product("Queijo Mussarela", "R$ 25,00", "Queijos Delícia", "kg", PriceChangeLevel.HIGH),
            Product("Iogurte Natural", "R$ 2,80", "Laticínios Pura Vida", "un", PriceChangeLevel.LOW)
        ))

    }
}