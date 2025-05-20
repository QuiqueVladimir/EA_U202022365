package upc.edu.template.domain.model

data class MiEvento(
    val id: Int,
    val title: String,
    val image: String,
    val location: String,
    val date: String,
    val type: String,
    val category: String,
    val website: String,
    val description: String
)
