package com.sk.nai.kdictionary

/**
 * Created by naisk133 on 20/12/2559.
 */
fun String.toIntChecked(): Int {
    return if (this == "") 0 else this.toInt()
}