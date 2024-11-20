package br.edu.up.secb.ui.screens.sapataria

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.secb.dados.SapatosAfazer
import br.edu.up.secb.dados.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SapatosAfazerViewModel(
    private val repository : IRepository
) : ViewModel(){

    private val _sapatosAfazer = MutableStateFlow<List<SapatosAfazer>>(emptyList())
    val sapatosAfazer: StateFlow<List<SapatosAfazer>> get() = _sapatosAfazer

    init {
        viewModelScope.launch {
            repository.listarSapatosAfazer().collectLatest { listaDeSapatosAfazer ->
                _sapatosAfazer.value = listaDeSapatosAfazer
            } //.collectLastest
        }
    }

    fun excluir(sapatosAfazer: SapatosAfazer) {
        viewModelScope.launch {
            repository.excluirSapatoAfazer(sapatosAfazer)
        }
    }

    suspend fun buscarporid(sapatoId: Int): SapatosAfazer? {
        return withContext(Dispatchers.IO){
            repository.buscarSapatoPorId(sapatoId)
        }
    }

    fun gravar(sapatosAfazer: SapatosAfazer) {
        viewModelScope.launch {
            repository.gravarSapatoAfazer(sapatosAfazer)
        }
    }

}