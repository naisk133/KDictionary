package com.sk.nai.kdictionary.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.sk.nai.kdictionary.R
import com.sk.nai.kdictionary.fragment.CalculatorFragment
import com.sk.nai.kdictionary.fragment.DetailFragment
import com.sk.nai.kdictionary.toIntChecked

class MainActivity : AppCompatActivity(), CalculatorFragment.OnButtonClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CalculatorFragment()).commit()
        }
    }

    override fun onClicked(fragment: Fragment) {
        Log.wtf("MainActivity","onClicked called")
        when (fragment) {
            is CalculatorFragment -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.container, DetailFragment()).addToBackStack(null).commit()
            }
            is DetailFragment -> {
                //TODO add DetailFragment OnClickListener
                Log.wtf("MainActivity","onClicked from detailFragment")
            }
            else -> {
                Log.wtf("MainActivity","onClicked from other Fragments")
            }
        }
    }
}
