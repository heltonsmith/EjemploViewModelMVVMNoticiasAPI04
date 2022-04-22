package com.heltonbustos.viewmodel4noticiasapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heltonbustos.viewmodel4noticiasapi.repository.interactor.NoticiasInteractor
import com.heltonbustos.viewmodel4noticiasapi.repository.retrofit.Noticias
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    val noticias: MutableLiveData<Noticias> = MutableLiveData()
    private val interactor = NoticiasInteractor()

    fun obBtnTraerNoticias(){
        CoroutineScope(Dispatchers.IO).launch {
            noticias.postValue(interactor.traerRespuesta("es"))
        }
    }

}