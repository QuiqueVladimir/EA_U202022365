package upc.edu.template.presentation.di

import upc.edu.template.data.di.DataModule
import upc.edu.template.presentation.viewmodel.EventosViewModel

object PresentationModule {

    fun getSearchEventoViewModel(): EventosViewModel {
        return EventosViewModel(DataModule.getEventoRepository())
    }
}