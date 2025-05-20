package upc.edu.template.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import upc.edu.template.data.repository.EventoRepository
import upc.edu.template.domain.model.Evento

class EventosViewModel(private val eventoRepository: EventoRepository): ViewModel() {
    private val _evento = MutableStateFlow<List<Evento>>(emptyList())
    private val _eventoDetail = MutableLiveData<Evento?>()

    val evento: StateFlow<List<Evento>> = _evento
    val eventoDetail: LiveData<Evento?> get() = _eventoDetail

    fun viewEventos(title: String) {
        viewModelScope.launch {
            try {
                val eventos = eventoRepository.viewEventos(title)
                _evento.value = eventos
            } catch (e: Exception) {
                _evento.value = emptyList()
            }
        }
    }

    fun getEventosById(id: Int) {
        viewModelScope.launch {
            _eventoDetail.value = eventoRepository.getEventoById(id)
        }
    }
}