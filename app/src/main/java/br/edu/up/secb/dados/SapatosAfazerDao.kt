package br.edu.up.secb.dados

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow



// Objetos de manipulação do banco de dados
@Dao
interface SapatosAfazerDao {

    //Listar
    @Query("select * from SapatosAfazer")
    fun listarAfazeres(): Flow<List<SapatosAfazer>>
    //suspend fun listarAfazeres(): List<Afazer>

    //Buscar por Id
    @Query("select * from sapatosafazer where sapatoId = :idx")
    suspend fun buscarAfazerPorId(idx: Int): SapatosAfazer

    //Gravar @Update @Insert
    @Upsert
    suspend fun gravarAfazer(afazer: SapatosAfazer)

    //Excluir
    @Delete
    suspend fun excluirAfazer(afazer: SapatosAfazer)

}