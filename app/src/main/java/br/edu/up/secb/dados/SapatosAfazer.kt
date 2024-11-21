package br.edu.up.secb.dados

import androidx.room.Entity


@Entity
data class SapatosAfazer(
    var pago: Boolean = false,
    var nomeSapato: String,
    var descricao: String,
    var concluido: Boolean = false,
    var preco: Double,
    var formaPagamento: Int, //1 = dinheiro, 2 = cartão, 3 = pix, 4 = não informado
    var par: Boolean = false,
    var sapatoId: Int? = null
){
constructor() : this(false, "", "", false, 0.0, 1, false, null )
}