package upc.edu.template.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

import upc.edu.template.domain.model.Evento
import upc.edu.template.presentation.viewmodel.EventosViewModel

@Composable
fun EventoView(viewModel: EventosViewModel, OnEventoClick: (Int) -> Unit) {
    val eventos = viewModel.evento.collectAsState()

    if (eventos.value.isEmpty()) {
        Text("No hay eventos disponibles")
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(eventos.value) { evento ->
                EventoListItemView(evento, OnEventoClick)
            }
        }
    }
}

@Composable
fun EventoListItemView(
    evento: Evento,
    onEventoClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onEventoClick(evento.id) },
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = evento.image,
                contentDescription = "Imagen del evento",
                modifier = Modifier
                    .padding(end = 8.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = evento.title,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = evento.date,
                    color = Color.Gray
                )
                Text(
                    text = evento.location,
                    color = Color.Gray
                )
            }
        }
    }
}