package upc.edu.template.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import upc.edu.template.data.model.EventoResponse

interface EventoService {
    @GET("events")
    suspend fun searchEvent(@Query("title") title:String): Response<List<EventoResponse>>
    @GET("events")
    suspend fun getEventById(@Query("id") id:Int): Response<EventoResponse>
}