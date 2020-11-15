package com.twinrock.activityinteracteg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.twinrock.activityinteracteg.R

class MainActivity : AppCompatActivity() {

    val TAG = "-MainActivity-"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSendToSecond = findViewById<Button>(R.id.buttonSendToNextScreen)
        val editText = findViewById<EditText>(R.id.editText)
        btnSendToSecond.setOnClickListener {
            if (TextUtils.isEmpty(editText.text)){
                editText.setError("Required")
                return@setOnClickListener
            }
            intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("question", editText.text.toString())
            startActivityForResult(intent, 101)
        }
        Log.i(TAG, "onCreate------")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            101 -> {
                var res = data?.getStringExtra("answer").toString()
                findViewById<TextView>(R.id.textViewAnwer).setText(res)
            }
        }
    }
}