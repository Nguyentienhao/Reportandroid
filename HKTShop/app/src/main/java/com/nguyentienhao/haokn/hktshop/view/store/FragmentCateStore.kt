package com.nguyentienhao.haokn.hktshop.view.store

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nguyentienhao.haokn.hktshop.R

class FragmentCateStore: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_store, container, false)

        return view
    }
}