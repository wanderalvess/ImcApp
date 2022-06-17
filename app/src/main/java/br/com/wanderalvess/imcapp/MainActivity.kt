package br.com.wanderalvess.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        height?.doAfterTextChanged { text ->
            //Toast.makeText(this,text.toString(),Toast.LENGTH_SHORT).show()
        }
        weight?.doOnTextChanged{ text, _, _, _ ->
            //calculateBTN?.text = text
        }
        calculateBTN?.setOnClickListener {
            calculateIMC(weight.text.toString(), height.text.toString())
        }
    }

    private fun calculateIMC(weight: String, height: String) {
        val weight = weight.toFloatOrNull()
        val height = height.toFloatOrNull()

        if (weight != null && height != null) {
            val imc = weight / (height * height)
            calculateBTN.text = "seu IMC é \n %.2f".format(imc)
        }
    }
}