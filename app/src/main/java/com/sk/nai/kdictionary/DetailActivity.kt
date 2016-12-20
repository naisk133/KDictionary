package com.sk.nai.kdictionary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initViews(savedInstanceState)
    }

    private fun initViews(savedInstanceState: Bundle?) {
        textView = findViewById(R.id.text_view) as TextView?
        if (intent != null) {
            textView?.text = intent.getStringExtra("Result")
        }
    }
}
