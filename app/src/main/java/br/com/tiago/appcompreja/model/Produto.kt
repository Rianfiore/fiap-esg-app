package br.com.tiago.appcompreja.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_produto")
data class Produto(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val nome: String,
    val marca: String,
    val estoque: String,
    val preco: String,
    val descricao: String,
    val categoria: String,
    val codigoBarra: String,
    val precoPromocional: String,
    @ColumnInfo(name = "is_promocao") var isPromocao: Boolean = false,
)
