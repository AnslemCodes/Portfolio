package com.example.portfolioapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var mLoginBtn : Button
    lateinit var mCreateUser : TextView
    lateinit var mLoginEmail : EditText
    lateinit var mLoginPassword : EditText

    companion object{
        val String = "message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLoginBtn = findViewById(R.id.loginBtn)
        mCreateUser = findViewById(R.id.Register)
        mLoginEmail = findViewById(R.id.input_email)
        mLoginPassword = findViewById(R.id.input_password)


        mCreateUser.setOnClickListener(View.OnClickListener {
            val intent = Intent( this , SignUpActivity::class.java)
            startActivity(intent)
        })







    }

    fun openMain (view: View){

        //get the stored user details from shared pref
        val sharedPref = getSharedPreferences(SignUpActivity.USER_SHARED_PREF, Context.MODE_PRIVATE)
        val email = sharedPref.getString(SignUpActivity.EMAIL,"N/A")
        val password = sharedPref.getString(SignUpActivity.PASSWORD,"N/A")



        //validate email and password
        if (email.equals(input_email.text.toString()) && password.equals(input_password.text.toString())){
            Toast.makeText(this,"Successful",Toast.LENGTH_SHORT).show()

            val message : String = mLoginEmail.getText().toString()

            val intent = Intent( this , MainActivity::class.java)
            startActivity(intent)


        }else {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
        }

    }
}
