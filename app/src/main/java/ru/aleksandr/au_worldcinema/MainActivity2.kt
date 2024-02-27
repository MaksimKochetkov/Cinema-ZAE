package ru.aleksandr.au_worldcinema

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.aleksandr.au_worldcinema.databinding.ActivityMain2Binding


const val TABLE = "TABLEE"
//const val CHECKK = "KEY4"
class MainActivity2 : AppCompatActivity() {
    private lateinit var data1: SharedPreferences
    lateinit var preff: SharedPreferences
    private lateinit var binding: ActivityMain2Binding
    @SuppressLint("CommitPrefEdits")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)

        var buttonreg = findViewById<Button>(R.id.button_reg)
        var buttonvhod = findViewById<Button>(R.id.button_vhod)

        buttonreg.setOnClickListener {
            if (binding.editTextName.text.toString().isNotEmpty() && binding.editTextPass.text.toString().isNotEmpty() && binding.editTextEmail.text.toString().isNotEmpty() && binding.editTextFam.text.toString().isNotEmpty() && binding.editTextName.text.toString().isNotEmpty()
            ) {
                if (binding.editTextPass.text.toString() != binding.editTextPassAgain.text.toString()) {
                    Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Регистрация успешно завершена", Toast.LENGTH_SHORT).show()

                    binding.apply {
                        val editor = preff.edit()
                        editor.putString("email", editTextEmail.text.toString())
                        editor.putString("pass", editTextPass.text.toString())
                        editor.putString("name", editTextName.text.toString())
                        editor.putString("fam", editTextFam.text.toString())
                        editor.apply()
                    }
                    val inten = Intent(this, MainActivity3::class.java)
                    startActivity(inten)
                }
            } else {
                Toast.makeText(this, "Какое-то из полей не заполнено", Toast.LENGTH_SHORT).show()
            }
        }
        buttonvhod.setOnClickListener {
            val intenn = Intent(this, MainActivity3::class.java)
            startActivity(intenn)
        }
    }
}

