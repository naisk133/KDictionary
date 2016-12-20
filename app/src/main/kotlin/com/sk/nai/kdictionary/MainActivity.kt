package com.sk.nai.kdictionary

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var editText1: EditText? = null
    private var editText2: EditText? = null
    private var textView: TextView? = null
    private var btnAdd: Button? = null
    private var btnSubtract: Button? = null
    private var btnMultiply: Button? = null
    private var btnDivide: Button? = null
    private var btnNext: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews(savedInstanceState)
    }

    private fun initViews(savedInstanceState: Bundle?) {
        editText1 = findViewById(R.id.edit_text1) as EditText?
        editText2 = findViewById(R.id.edit_text2) as EditText?
        textView = findViewById(R.id.text_view) as TextView?
        btnAdd = findViewById(R.id.button_add) as Button?
        btnSubtract = findViewById(R.id.button_subtract) as Button?
        btnMultiply = findViewById(R.id.button_multiply) as Button?
        btnDivide = findViewById(R.id.button_divide) as Button?
        btnNext = findViewById(R.id.button_next) as Button?

        btnAdd?.setOnClickListener({
            textView?.text = "${editText1?.text.toString().toIntChecked() + editText2?.text.toString().toIntChecked()}"
        })
        btnSubtract?.setOnClickListener({
            textView?.text = "${editText1?.text.toString().toIntChecked() - editText2?.text.toString().toIntChecked()}"
        })
        btnMultiply?.setOnClickListener({
            textView?.text = "${editText1?.text.toString().toIntChecked() * editText2?.text.toString().toIntChecked()}"
        })
        btnDivide?.setOnClickListener({
            if (editText2?.text.toString().toIntChecked() == 0) {
                textView?.text = "Undefined"
            } else {
                textView?.text = "${editText1?.text.toString().toIntChecked() / editText2?.text.toString().toIntChecked()}"
            }
        })
        btnNext?.setOnClickListener({
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("Result", textView?.text.toString())
            startActivity(intent)
        })
    }
}
