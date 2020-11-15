package com.twinrock.activityinteracteg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.twinrock.activityinteracteg.R

class SecondActivity : AppCompatActivity(), View.OnClickListener {
     val TAG = "-SecondActivity-"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textView = findViewById<TextView>(R.id.textViewQuestion)
        val edittextReply = findViewById<EditText>(R.id.edittextReply)
        val buttonReply = findViewById<Button>(R.id.buttonReply)

        var question = intent.getStringExtra("question")
        textView.text = question

        buttonReply.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        Log.i("-SecondActivity-", "myClickListener.click-----")
        val replyText = findViewById<EditText>(R.id.edittextReply)
        if (TextUtils.isEmpty(replyText.text)) {
            replyText.setError("Required")
            return
        }
        Log.i("TAG", "res  ${replyText.text}")
        intent.putExtra("answer", replyText.text.toString())
        setResult(101, intent)
        finish()
    }

}
