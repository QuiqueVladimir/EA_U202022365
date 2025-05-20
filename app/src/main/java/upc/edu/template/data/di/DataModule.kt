package upc.edu.template.data.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import upc.edu.template.data.remote.ApiConstants
import upc.edu.template.data.remote.EventoService
import upc.edu.template.data.repository.EventoRepository

object DataModule {

    fun getEventoRepository(): EventoRepository{
        return EventoRepository(getEventoService())
    }

    fun getEventoService(): EventoService{
        return getRetrofit().create(EventoService::class.java)
    }

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}