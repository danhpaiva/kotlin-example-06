package com.example.calculadoraimc

import android.icu.text.DecimalFormat
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoraimc.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        processarResultado()

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun processarResultado() {
        val nome = intent.getStringExtra("nome")
        val imc = intent.getDoubleExtra("imc", 0.0)

        binding.tvNome.text = nome
        val formatadorDecimal = DecimalFormat("#0.00")
        binding.tvResultadoImc.text = formatadorDecimal.format(imc)

        when {
            imc <= 18.5 -> {
                binding.imgResultado.setImageDrawable(getDrawable(R.drawable.abaixo_peso))
            }
            imc <= 24.9 -> {
                binding.imgResultado.setImageDrawable(getDrawable(R.drawable.peso_normal))
            }
            imc <= 29.9 -> {
                binding.imgResultado.setImageDrawable(getDrawable(R.drawable.sobrepeso))
            }
            imc <= 34.9 -> {
                binding.imgResultado.setImageDrawable(getDrawable(R.drawable.grau1))
            }
            imc <= 39.9 -> {
                binding.imgResultado.setImageDrawable(getDrawable(R.drawable.grau2))
            }
            imc >= 40 -> {
                binding.imgResultado.setImageDrawable(getDrawable(R.drawable.grau3))
            }
        }
    }
}