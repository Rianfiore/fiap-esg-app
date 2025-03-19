package br.com.tiago.appcompreja.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.tiago.fiap_esg_app.produto.ClientePJScreenViewModel
import br.com.tiago.fiap_esg_app.produto.ProdutoScreenViewModel


class ClientePJScreenViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientePJScreenViewModel::class.java)) {
            return ClientePJScreenViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
