package upc.edu.template.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

import upc.edu.template.domain.model.Evento
import upc.edu.template.presentation.viewmodel.EventosViewModel

@Composable
fun EventoView(viewModel: EventosViewModel, OnEventoClick: (Int) -> Unit) {
    val eventos = viewModel.evento.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
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
            .padding(8.dp),
        onClick = { onEventoClick(evento.id) }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(evento.title, fontWeight = Bold)
            Text(evento.date)
            Text(evento.location)
        }
    }
}