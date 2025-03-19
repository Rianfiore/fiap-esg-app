package br.com.tiago.appcompreja.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.tiago.appcompreja.model.ClientePJ
import br.com.tiago.appcompreja.model.Produto

@Dao
interface ClientePJDao {

    @Insert
    fun salvar(clientePJ: ClientePJ): Long

    @Update
    fun atualizar(clientePJ: ClientePJ): Int

    @Delete
    fun excluir(clientePJ: ClientePJ): Int

    @Query("SELECT * FROM tb_cliente_pj WHERE id = :id")
    fun buscarClientePJPeloId(id: Int): ClientePJ

    @Query("SELECT * FROM tb_cliente_pj ORDER BY nome ASC")
    fun listarClientesPJ(): List<ClientePJ>
}