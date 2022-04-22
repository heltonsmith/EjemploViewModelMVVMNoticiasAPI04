package com.heltonbustos.viewmodel4noticiasapi.repository.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NoticiasAPIService {

    @Headers(
        value = [
            "X-Api-Key: 838753bb2a8741ea93eb75265ad270d8",
            "content-type: application/json; charset=utf-8"
        ]
    )
    @GET("everything?q=chile")
    fun obtenerNoticias(@Query("language") languages: String): Call<Noticias>

}