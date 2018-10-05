package com.nguyentienhao.haokn.hktshop.view.signInSignUp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nguyentienhao.haokn.hktshop.R

class FragmentSignIn: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_fragment_signin, container, false)

        return view
    }
}