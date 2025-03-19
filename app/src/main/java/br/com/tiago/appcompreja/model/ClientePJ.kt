package br.com.tiago.appcompreja.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_cliente_pj")
data class ClientePJ(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val nome: String,
    val cnpj: String,
    val endereco: String
)
