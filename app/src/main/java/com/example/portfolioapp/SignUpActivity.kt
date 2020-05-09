package com.example.portfolioapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.input_email
import kotlinx.android.synthetic.main.activity_login.input_password
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {


    lateinit var mRegisterBtn : Button
    lateinit var mRegName : EditText
    lateinit var mRegEmail : EditText
    lateinit var mRegPassword : EditText
    lateinit var mRegLogin : TextView

    companion object {
        const val USER_SHARED_PREF = "com.example.portfolioapp.PREFERENCES"
        const val EMAIL ="EMAIL"
        const val  PASSWORD =" PASSWORD"
        const val NAME = "NAME"
        val String = "message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mRegisterBtn = findViewById(R.id.SignUpBtn)
        mRegName = findViewById(R.id.input_name)
        mRegEmail = findViewById(R.id.input_email)
        mRegPassword = findViewById(R.id.input_password)
        mRegLogin = findViewById(R.id.login)

        mRegLogin.setOnClickListener(View.OnClickListener {
            val intent = Intent( this , LoginActivity::class.java)
            startActivity(intent)
        })




    }
    private fun saveToSharedPref(){
        val sharedPref = getSharedPreferences(USER_SHARED_PREF,Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(EMAIL,input_email.text.toString())
        editor.putString(PASSWORD,input_password.text.toString())
        editor.putString(NAME,input_name.text.toString())
        editor.apply()

    }

    fun openLogin(view: View){
        saveToSharedPref()
        val intent = Intent( this , LoginActivity::class.java)
        startActivity(intent)
    }
}
