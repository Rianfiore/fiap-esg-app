package br.com.tiago.appcompreja.database.repository

import android.content.Context
import br.com.tiago.appcompreja.database.dao.ProdutoDb
import br.com.tiago.appcompreja.model.Produto


class ProdutoRepository(context: Context) {
    private val db = ProdutoDb.getDatabase(context).produtoDao()

    fun salvar(produto: Produto): Long {
        return db.salvar(produto)
    }

    fun atualizar(produto: Produto): Int {
        return db.atualizar(produto)
    }

    fun excluir(produto: Produto): Int {
        return db.excluir(produto)
    }

    fun listarProdutos(): List<Produto> {
        return db.listarProdutos()
    }

    fun buscarProdutoPeloId(id: Int): Produto {
        return db.buscarProdutoPeloId(id)
    }

}