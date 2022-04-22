package com.heltonbustos.viewmodel4noticiasapi.repository.interactor

import com.heltonbustos.viewmodel4noticiasapi.repository.retrofit.Noticias
import com.heltonbustos.viewmodel4noticiasapi.repository.retrofit.RestEngine
import com.heltonbustos.viewmodel4noticiasapi.repository.retrofit.NoticiasAPIService
import retrofit2.Call

class NoticiasInteractor {

    fun traerRespuesta(languages: String): Noticias? {
        val llamada: NoticiasAPIService =
            RestEngine.getRestEngine().create(NoticiasAPIService::class.java)
        val resultado: Call<Noticias> = llamada.obtenerNoticias(languages)
        val p: Noticias? = resultado.execute().body()

        return p
    }

}