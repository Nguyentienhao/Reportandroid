package com.nguyentienhao.haokn.hktshop.view.account

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.view.signInSignUp.SignInSignUpActivity
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        txtSignIn.setOnClickListener {
            val intent = Intent(this, SignInSignUpActivity::class.java)
            startActivity(intent)
        }
    }
}