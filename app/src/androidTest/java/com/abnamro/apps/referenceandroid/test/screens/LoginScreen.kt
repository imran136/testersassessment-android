package com.abnamro.apps.referenceandroid.test.screens

import com.abnamro.apps.referenceandroid.R

class LoginScreen {

    fun emailField(): Int {
        return R.id.user_email
    }
    fun passwordField(): Int {
        return R.id.password
    }

    fun submitButton(): Int {
        return R.id.button_submit
    }

    fun resetButton(): Int {
        return R.id.button_reset
    }

    fun successfulLoginMessage(): Int {
        return R.id.successful_login_text_view
    }

}