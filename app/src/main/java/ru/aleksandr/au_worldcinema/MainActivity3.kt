package ru.aleksandr.au_worldcinema

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.trackPipAnimationHintView
import retrofit2.Call
import retrofit2.Response
import retrofit2.create
import ru.aleksandr.au_worldcinema.Result
import ru.aleksandr.au_worldcinema.databinding.ActivityMain2Binding
import ru.aleksandr.au_worldcinema.databinding.ActivityMain3Binding
import ru.aleksandr.au_worldcinema.databinding.ActivityResultBinding

var TokenAPI:String=""
var IdAPI:String=""
var NickNameAPI:String=""
var AvatarAPI:String=""
var EmailAPI:String=""
class MainActivity3 : AppCompatActivity() {
    private lateinit var preff: SharedPreferences
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)
        var button_reg = findViewById<Button>(R.id.button_goto_reg)
        var button_vhod = findViewById<Button>(R.id.buttonvhod)
//        if (preff.getString("check", "").toString().isNotEmpty() && preff.getString("email", "").toString().isNotEmpty() && preff.getString("pass", "").toString().isNotEmpty()) {
//            Toast.makeText(this, "Вы нажимали 'Запомнить меня'", Toast.LENGTH_SHORT).show()
//            val intenn = Intent(this, Result::class.java)
//            startActivity(intenn)
//        }

        button_vhod.setOnClickListener {
//            if (binding.editTextTextEmailAddress.text.toString() == preff.getString("email", "") && binding.editTextTextPassword.text.toString() == preff.getString("pass", "")) {
//                if (!binding.checkBox.isChecked) {
//                    val editor = preff.edit()
//                    editor.putString("check", "check")
//                    editor.apply()
//                }
//                binding.apply {
//                    editTextTextEmailAddress.text.clear()
//                    editTextTextPassword.text.clear()
//                }
//                val intenn = Intent(this, Result::class.java)
//                startActivity(intenn)
//            }
//            else {
//                Toast.makeText(this, "Что-то не верно", Toast.LENGTH_SHORT).show()
//            }
            if (binding.editTextTextEmailAddress.text.toString().isNotEmpty() && binding.editTextTextPassword.text.toString().isNotEmpty()) {
                val log = RetrofitClass().getRetrofit()
                val getApi = log.create(RetrofitInterface::class.java)
                val hashMap: HashMap<String, String> = HashMap()
                hashMap.put("email", binding.editTextTextEmailAddress.text.toString())
                hashMap.put("password", binding.editTextTextPassword.text.toString())
                val log_call: retrofit2.Call<RetrofitDataclass> = getApi.getAuth(hashMap)
                log_call.enqueue(object: retrofit2.Callback<RetrofitDataclass> {
                    override fun onResponse(call: Call<RetrofitDataclass>, response: Response<RetrofitDataclass>) {
                        if (response.isSuccessful) {
                            TokenAPI = response.body()?.token.toString()
                            EmailAPI = response.body()?.email.toString()
                            NickNameAPI = response.body()?.nickName.toString()
                            AvatarAPI = response.body()?.avatar.toString()
                            IdAPI = response.body()?.id.toString()
                            val inte = Intent(this@MainActivity3, Result::class.java)
                            startActivity(inte)
                            finish()
                        }
                        else {
                            Toast.makeText(this@MainActivity3, "ТАКОГО НЕТ ЧЕЛОВЕКА", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<RetrofitDataclass>, t: Throwable) {
                        Toast.makeText(this@MainActivity3, "ONFAILURE", Toast.LENGTH_SHORT).show()
                    }
                }
                )
            }
            else {
                Toast.makeText(this@MainActivity3, "ОШИБКА ВВОДА", Toast.LENGTH_SHORT).show()
            }
        }
        button_reg.setOnClickListener {
            val inten = Intent(this, MainActivity2::class.java)
            startActivity(inten)
        }

    }

}
