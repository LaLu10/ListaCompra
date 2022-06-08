package com.example.listacompra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listacompra.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var b:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)
        var Tot=0.0 //CREAMOS LA VARIABLE TOTAL PARA SUMAR LOS PRECIOS//
        b.tvLista.text = "LISTA\n\n"
        val myExtras = intent.extras
        if (myExtras != null){
            val claves = myExtras.keySet()
            //KEYSET DEVUELVE EL SUBCONJUNTO DE LAS CLAVES// NO LOS DEVUELVE ORDENADOS//
            for (key in claves){
                b.tvLista.text = b.tvLista.text.toString()
                    .plus("$key:\t\t\t${myExtras.get(key)}\n")
                Tot += myExtras.get(key).toString().toDouble()
                b.tvTotal.text= "TOTAL: " + Tot.toString() + " euros"
            }
        }
        b.btnVolver.setOnClickListener {
            onBackPressed()
        }

    }
    fun msj (str:String){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}