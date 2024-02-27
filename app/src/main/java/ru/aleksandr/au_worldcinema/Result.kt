package ru.aleksandr.au_worldcinema

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import ru.aleksandr.au_worldcinema.databinding.ActivityResultBinding


class Result : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    lateinit var preff: SharedPreferences
    private lateinit var data1: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        data1 = getSharedPreferences(TABLE, MODE_PRIVATE)
        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)
        binding.apply {
            textView.text = preff.getString("name", "")!!
            textView2.text = preff.getString("fam", "")!!
            textView3.text = preff.getString("email", "")!!
            textView4.text = preff.getString("pass", "")!!
            textViewBool.text = preff.getString("check", "")!!
        }
        val buttondel = findViewById<Button>(R.id.button_del)
        buttondel.setOnClickListener {
            val editor = preff.edit()
            editor.putString("check", "")
            editor?.apply()
            finish()
            System.out.close()
        }
        Glide.with(this).load("https://i.playground.ru/p/fc-1eRRfl-PC8tSdjRWn-A.png").into(binding.imageView4)



    }
}


