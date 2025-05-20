package upc.edu.template.data.model

import upc.edu.template.domain.model.Evento

data class EventoResponse(
    val id: Int,
    val title: String?,
    val image: String?,
    val location: String?,
    val date: String?,
    val type: String?,
    val category: String?,
    val website: String?,
    val description: String?
){
    fun toEvento(): Evento {
        return Evento(
            id = id,
            title = title ?: "",
            image = image ?: "",
            location = location ?: "",
            date = date ?: "",
            type = type ?: "",
            category = category ?: "",
            website = website ?: "",
            description = description?: ""
        )
    }
}