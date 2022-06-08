package com.example.listacompra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import com.example.listacompra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    private var lista = mutableMapOf<String, Double>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
    }

    fun addItem (view:View){
        //PRIMERO CONFIRMAMOS QUE LAS VISTAS ESTÁN VACÍAS//
        if (b.etArticulo.text.isNotEmpty() and b.etPrecio.text.isNotEmpty()){
            //VAMOS AÑANDIENDO LO QUE PONEMOS AL MAPA LLAMADO *lista*//
            lista.put(b.etArticulo.text.toString(), b.etPrecio.text.toString().toDouble())
            b.etArticulo.text.clear()
            b.etPrecio.text.clear()
            msj(lista.toString())
        } else {
            msj("Todos los campos son obligatorios")
        }

    }

    fun nextActivity(view:View){
        val myIntent = Intent(this@MainActivity, ResultActivity::class.java)
        lista.forEach{ k,v ->
            myIntent.putExtra(k,v)
        }
//        val suma= lista.values.sum()
//        myIntent.putExtra("SUMA",suma)
        startActivity(myIntent)

    }

    fun msj (str:String){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

}