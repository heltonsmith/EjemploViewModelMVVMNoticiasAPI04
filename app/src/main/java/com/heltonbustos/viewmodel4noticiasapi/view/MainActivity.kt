package com.heltonbustos.viewmodel4noticiasapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.heltonbustos.viewmodel4noticiasapi.viewmodel.ViewModel
import com.heltonbustos.viewmodel4noticiasapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: ViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        observar()

        binding.btnTraerNoticias.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.obBtnTraerNoticias()
        }
    }

    private fun observar() {
        mainViewModel.noticias.observe(this, Observer {
            binding.txtNoticias.text = "Noticias: \n"
            binding.txtNoticias.append("${Gson().toJson(it)}")
            binding.progressBar.visibility = View.GONE
        })
    }


}