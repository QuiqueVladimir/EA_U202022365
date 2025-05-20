package upc.edu.template.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import upc.edu.template.domain.model.Evento
import upc.edu.template.domain.model.MiEvento

@Entity(tableName = "eventos")
data class EventoEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val image: String,
    val location: String,
    val date: String,
    val type: String,
    val category: String,
    val website: String,
    val description: String
) {
    fun toMiEvento(): MiEvento{
        return MiEvento(
            id = 0,
            title = title,
            image = image,
            location = location,
            date = date,
            type = type,
            category = category,
            website = website,
            description = description
        )
    }
    companion object{
        fun fromEvento(evento: Evento): EventoEntity{
            return EventoEntity(
                id = evento.id,
                title = evento.title,
                image = evento.image,
                location = evento.location,
                date = evento.date,
                type = evento.type,
                category = evento.category,
                website = evento.website,
                description = evento.description
            )
        }

        fun fromMiEvento(evento: MiEvento): EventoEntity{
            return EventoEntity(
                id = evento.id,
                title = evento.title,
                image = evento.image,
                location = evento.location,
                date = evento.date,
                type = evento.type,
                category = evento.category,
                website = evento.website,
                description = evento.description
            )
        }

    }
}