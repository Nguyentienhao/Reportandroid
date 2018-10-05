package com.nguyentienhao.haokn.hktshop.view.signInSignUp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.adapter.ViewPagerAdapterSigninSignUp
import kotlinx.android.synthetic.main.activity_signin_signup.*

class SignInSignUpActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_signup)

        val viewPagerAdapterSignInSignUp = ViewPagerAdapterSigninSignUp(supportFragmentManager)

        vPagerSignIn.adapter = viewPagerAdapterSignInSignUp

        viewPagerAdapterSignInSignUp.notifyDataSetChanged()

        setSupportActionBar(toolbarSignIn)

        tabSignIn.setupWithViewPager(vPagerSignIn)
    }
}