package com.gzeinnumer.textwatcherexample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gzeinnumer.textwatcherexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.edExample.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                Log.d("MyZein", "Selesai $s")
                with(Toast.makeText(applicationContext, "Selesai $s", Toast.LENGTH_SHORT)){
                    setGravity(Gravity.START,0,0)
                    show()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("MyZein", "Sebelum $s")
                with(Toast.makeText(applicationContext, "Sebelum $s", Toast.LENGTH_SHORT)){
                    setGravity(Gravity.CENTER,0,0)
                    show()
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("MyZein", "Sedang $s")
                with(Toast.makeText(applicationContext, "Sedang $s", Toast.LENGTH_SHORT)){
                    setGravity(Gravity.END,0,0)
                    show()
                }
            }
        })
    }
}
