package com.sk.nai.kdictionary.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.sk.nai.kdictionary.R
import com.sk.nai.kdictionary.toIntChecked

class CalculatorFragment : Fragment() {
    private var editText1: EditText? = null
    private var editText2: EditText? = null
    private var textView: TextView? = null
    private var btnAdd: Button? = null
    private var btnSubtract: Button? = null
    private var btnMultiply: Button? = null
    private var btnDivide: Button? = null
    private var btnNext: Button? = null

    private var mCallBack: OnButtonClickListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_calculator, container, false)
        initViews(savedInstanceState, rootView)
        return rootView
    }

    private fun initViews(savedInstanceState: Bundle?, rootView: View) {
        with(rootView) {
            editText1 = findViewById(R.id.edit_text1) as EditText?
            editText2 = findViewById(R.id.edit_text2) as EditText?
            textView = findViewById(R.id.text_view) as TextView?
            btnAdd = findViewById(R.id.button_add) as Button?
            btnSubtract = findViewById(R.id.button_subtract) as Button?
            btnMultiply = findViewById(R.id.button_multiply) as Button?
            btnDivide = findViewById(R.id.button_divide) as Button?
            btnNext = findViewById(R.id.button_next) as Button?
        }

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
            mCallBack?.onClicked(this)?:throw Exception("Must implements onClickedCallbacks")
        })
    }

    interface OnButtonClickListener {

        fun onClicked(fragment: Fragment)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnButtonClickListener) {
            mCallBack = context
        }
    }
}
