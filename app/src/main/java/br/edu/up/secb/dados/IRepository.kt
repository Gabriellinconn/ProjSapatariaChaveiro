package br.edu.up.secb.dados

import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun listarSapatosAfazer(): Flow<List<SapatosAfazer>>
    suspend fun buscarSapatoPorId(idx: Int): SapatosAfazer?
    suspend fun gravarSapatoAfazer(sapatosAfazer: SapatosAfazer)
    suspend fun excluirSapatoAfazer(sapatosAfazer: SapatosAfazer)
}