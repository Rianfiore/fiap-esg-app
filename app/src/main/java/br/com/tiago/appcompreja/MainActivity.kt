package br.com.tiago.appcompreja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import br.com.tiago.appcompreja.ui.theme.AppCompreJaTheme
import br.com.tiago.appcompreja.vm.ProdutoScreenViewModelFactory
import br.com.tiago.fiap_esg_app.produto.ProdutoScreenViewModel
import br.com.tiago.fiap_esg_app.produto.ProdutosScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.tiago.appcompreja.vm.ClientePJScreenViewModelFactory
import br.com.tiago.fiap_esg_app.produto.ClientePJScreen
import br.com.tiago.fiap_esg_app.produto.ClientePJScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppCompreJaTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.laranja)
                ) {
                    NavHost(navController = navController, startDestination = "produtos") {
                        composable("produtos") {
                            ProdutosScreen(navController)
                        }
                        composable("clientes") {
                            ClientePJScreen(navController)
                        }
                    }
                }
            }
        }

    }
}