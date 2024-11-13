package br.edu.up.secb.dados

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class RemoteRepository() : IRepository {

    var db = FirebaseFirestore.getInstance()
    var sapatosAfazerCollection = db.collection("sapatosAfazer")

    //FUNÇÃO NÃO REATIVA OU SEJA NÃO ATUALIZA
//    override fun listarAfazeres(): Flow<List<Afazer>> = flow {
//        val dados = afazerCollection.get().await()
//        val afazeres = dados.documents.mapNotNull { dado ->
//            dado.toObject(Afazer::class.java)
//        }
//        emit(afazeres)
//    }

    //FUNÇÃO REATIVA
    override fun listarSapatosAfazer(): Flow<List<SapatosAfazer>> = callbackFlow {
        val listener = sapatosAfazerCollection.addSnapshotListener {
                dados, erros ->
            if (erros != null){
                close(erros)
                return@addSnapshotListener
            }
            if (dados != null){
                val sapatosAfazer = dados.documents.mapNotNull { dado ->
                    dado.toObject(SapatosAfazer::class.java)
                }
                trySend(sapatosAfazer).isSuccess
            }
        }
        awaitClose{ listener.remove()}
    }

    suspend fun getId(): Int{
        val dados = sapatosAfazerCollection.get().await()
        //Recupera o maior id do firestore no format inteiro
        val maxId = dados.documents.mapNotNull {
            it.getLong("sapatoId")?.toInt()
        }.maxOrNull() ?: 0
        return maxId + 1
    }

    override suspend fun gravarAfazer(sapatosAfazer: SapatosAfazer) {
        val document: DocumentReference
        if (sapatosAfazer.sapatoId == null){ // Inclusão
            sapatosAfazer.sapatoId = getId()
            document = sapatosAfazerCollection.document(sapatosAfazer.sapatoId.toString())
        } else { // Alteração
            document = sapatosAfazerCollection.document(sapatosAfazer.sapatoId.toString())
        }
        document.set(sapatosAfazer).await()
    }

    override suspend fun buscarAfazerPorId(idx: Int): SapatosAfazer? {
        val dados = sapatosAfazerCollection.document(idx.toString()).get().await()
//        val afazer = dados.toObject(Afazer::class.java)
//        return afazer
        return dados.toObject(SapatosAfazer::class.java)
    }

    override suspend fun excluirAfazer(sapatosAfazer: SapatosAfazer) {
        sapatosAfazerCollection.document(sapatosAfazer.sapatoId.toString()).delete().await()
    }
}