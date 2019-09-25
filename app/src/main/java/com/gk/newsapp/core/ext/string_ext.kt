package com.gk.newsapp.core.ext

import java.util.regex.Pattern

fun String.isValidEmailAddress(): Boolean {
    val emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$"

    val pat = Pattern.compile(emailRegex)
    return if (this == null) false else pat.matcher(this).matches()
}

fun String.concatLastName(text: String): String {
    return "$this $text"
}