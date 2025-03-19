package br.com.tiago.appcompreja.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.tiago.appcompreja.model.Produto

@Dao
interface ProdutoDao {

    @Insert
    fun salvar(produto: Produto): Long

    @Update
    fun atualizar(produto: Produto): Int

    @Delete
    fun excluir(produto: Produto): Int

    @Query("SELECT * FROM tb_produto WHERE id = :id")
    fun buscarProdutoPeloId(id: Int): Produto

    @Query("SELECT * FROM tb_produto ORDER BY nome ASC")
    fun listarProdutos(): List<Produto>
}