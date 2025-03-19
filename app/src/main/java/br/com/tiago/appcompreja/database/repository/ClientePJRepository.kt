package br.com.tiago.appcompreja.database.repository

import android.content.Context
import br.com.tiago.appcompreja.database.dao.ClientePJDb
import br.com.tiago.appcompreja.database.dao.ProdutoDb
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto


class ClientePJRepository(context: Context) {
    private val db = ClientePJDb.getDatabase(context).clientePJDao()

    fun salvar(clientePJ: ClientePJ): Long {
        return db.salvar(clientePJ)
    }

    fun atualizar(clientePJ: ClientePJ): Int {
        return db.atualizar(clientePJ)
    }

    fun excluir(clientePJ: ClientePJ): Int {
        return db.excluir(clientePJ )
    }

    fun listarClientesPJ(): List<ClientePJ> {
        return db.listarClientesPJ()
    }

    fun buscarClientesPJPeloId(id: Int): ClientePJ {
        return db.buscarClientePJPeloId(id)
    }

}