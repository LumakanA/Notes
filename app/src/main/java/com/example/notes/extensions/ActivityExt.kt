package com.example.notes.extensions

import android.app.Activity
import android.text.Editable
import com.google.android.material.textfield.TextInputEditText

fun Activity.validateName(text: Editable?):String?{
    return if(text.toString().isNotEmpty())
        null
    else {
        "The fields should not be empty"
    }
}
fun Activity.validateEmail(text: Editable?):String? {
    return if (text.toString().length >= 7 && text.toString().contains("@")) {
        null
    } else {
        "Mail must contain at least 7 characters and \"@\""
    }
}
fun Activity.validateEnterPassword(text: Editable?):String? {
    return if (text.toString().length >= 8)  {
        null
    } else {
        "Password must not be shorter than 8 characters"
    }
}
fun Activity.validateConfirmPassword(password: TextInputEditText, confirmedPassword: TextInputEditText):String? {
    val passwordValue = password.text.toString()
    val confirmedPasswordValue = confirmedPassword.text.toString()
    return if (passwordValue != confirmedPasswordValue) {
        "Passwords do not match"
    } else {
        null
    }
}
