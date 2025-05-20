package upc.edu.template.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import upc.edu.template.data.remote.EventoService
import upc.edu.template.domain.model.Evento

class EventoRepository(private val eventoService: EventoService){
    suspend fun viewEventos(title: String): List<Evento> = withContext(Dispatchers.IO) {
        val response = eventoService.searchEvent(title)
        if (response.isSuccessful) {
            response.body()?.let { it ->
                return@withContext it.map { gameResponse ->
                    gameResponse.toEvento()
                }
            }
        }
        println("Error en la respuesta: ${response.errorBody()?.string()}")
        return@withContext emptyList()
    }

    suspend fun getEventoById(id: Int): Evento ?= withContext(Dispatchers.IO){
        val response = eventoService.getEventById(id)
        if(response.isSuccessful){
            response.body()?.toEvento()
        } else {
            null
        }
    }

}
