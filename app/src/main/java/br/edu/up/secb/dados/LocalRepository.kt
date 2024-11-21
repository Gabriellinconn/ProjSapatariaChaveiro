package br.edu.up.secb.dados

import kotlinx.coroutines.flow.Flow

class LocalRepository(
    private val dao : SapatosAfazer
) : IRepository {

    override fun listarAfazeres(): Flow<List<SapatosAfazer>> {
        return dao.listarSapatosAfazer()
    }

    override suspend fun buscarAfazerPorId(idx: Int): Afazer {
        return dao.buscarSapatoPorId(idx)
    }

    override suspend fun gravarAfazer(afazer: Afazer) {
        dao.gravarSapato(afazer)
    }

    override suspend fun excluirAfazer(afazer: Afazer) {
        dao.excluirSapato(afazer)
    }

}