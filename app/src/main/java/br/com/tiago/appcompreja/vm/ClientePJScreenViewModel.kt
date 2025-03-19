package br.com.tiago.fiap_esg_app.produto

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.tiago.appcompreja.database.repository.ClientePJRepository
import br.com.tiago.appcompreja.database.repository.ProdutoRepository
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientePJScreenViewModel(private val context: Context) : ViewModel() {

    private val repository = ClientePJRepository(context)


    private val _nome = MutableLiveData<String>()
    val nomeState: LiveData<String> = _nome

    private val _cnpj = MutableLiveData<String>()
    val cnpjState: LiveData<String> = _cnpj

    private val _endereco = MutableLiveData<String>()
    val enderecoState: LiveData<String> = _endereco


    fun setNome(nome: String) {
        _nome.value = nome
    }

    fun setCnpj(cnpj: String) {
        _cnpj.value = cnpj
    }

    fun setEndereco(endereco: String) {
        _endereco.value = endereco
    }
    private val _clientesPJ = MutableLiveData<List<ClientePJ>>()
    val clientesState: LiveData<List<ClientePJ>> = _clientesPJ



    fun salvarClientePJ() {
        val clientePJ = ClientePJ(
            nome = _nome.value ?: "",
            cnpj = _cnpj.value ?: "",
            endereco = _endereco.value ?: ""
        )

        viewModelScope.launch(Dispatchers.IO) {
            repository.salvar(clientePJ)
            carregarClientesPJ()
        }
    }

    fun carregarClientesPJ() {
        viewModelScope.launch(Dispatchers.IO) {
            _clientesPJ.postValue(repository.listarClientesPJ())
        }
    }

}
