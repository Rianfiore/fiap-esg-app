package br.com.tiago.fiap_esg_app.produto

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.tiago.appcompreja.database.repository.ProdutoRepository
import br.com.tiago.appcompreja.model.Produto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProdutoScreenViewModel(private val context: Context) : ViewModel() {

    private val repository = ProdutoRepository(context)




    private val _nome = MutableLiveData<String>()
    val nomeState: LiveData<String> = _nome

    private val _marca = MutableLiveData<String>()
    val marcaState: LiveData<String> = _marca

    private val _precoNormal = MutableLiveData<String>()
    val precoNormalState: LiveData<String> = _precoNormal

    private val _precoPromocional = MutableLiveData<String>()
    val precoPromocionalState: LiveData<String> = _precoPromocional

    private val _descricao = MutableLiveData<String>()
    val descricaoState: LiveData<String> = _descricao

    private val _categoria = MutableLiveData<String>()
    val categoriaState: LiveData<String> = _categoria

    private val _codigoBarra = MutableLiveData<String>()
    val codigoBarraState: LiveData<String> = _codigoBarra

    private val _estoque = MutableLiveData<String>()
    val estoqueState: LiveData<String> = _estoque

    private val _emPromocao = MutableLiveData<Boolean>()
    val emPromocaoState: LiveData<Boolean> = _emPromocao

    private val _produtos = MutableLiveData<List<Produto>>()
    val produtosState: LiveData<List<Produto>> = _produtos

    fun setNome(nome: String) {
        _nome.value = nome
    }

    fun setMarca(marca: String) {
        _marca.value = marca
    }

    fun setPrecoNormal(preco: String) {
        _precoNormal.value = preco
    }

    fun setPrecoPromocional(preco: String) {
        _precoPromocional.value = preco
    }

    fun setDescricao(descricao: String) {
        _descricao.value = descricao
    }

    fun setCategoria(categoria: String) {
        _categoria.value = categoria
    }

    fun setCodigoBarra(codigo: String) {
        _codigoBarra.value = codigo
    }

    fun setEstoque(estoque: String) {
        _estoque.value = estoque
    }

    fun setEmPromocao(promocao: Boolean) {
        _emPromocao.value = promocao
    }

    fun salvarProduto() {
        val produto = Produto(
            nome = _nome.value ?: "",
            marca = _marca.value ?: "",
            estoque = _estoque.value ?: "",
            preco = _precoNormal.value ?: "",
            descricao = _descricao.value ?: "",
            categoria = _categoria.value ?: "",
            codigoBarra = _codigoBarra.value ?: "",
            precoPromocional = _precoPromocional.value ?: "",
            isPromocao = _emPromocao.value ?: false
        )

        viewModelScope.launch(Dispatchers.IO) {
            repository.salvar(produto)
            carregarProdutos()
        }
    }

    fun carregarProdutos() {
        viewModelScope.launch(Dispatchers.IO) {
            _produtos.postValue(repository.listarProdutos())
        }
    }

}
