package com.nguyentienhao.haokn.hktshop.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.nguyentienhao.haokn.hktshop.view.signInSignUp.fragment.FragmentSignIn
import com.nguyentienhao.haokn.hktshop.view.signInSignUp.fragment.FragmentSignUp

class ViewPagerAdapterSigninSignUp(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(p0: Int): Fragment? {
        return when(p0) {
            0 -> FragmentSignIn()
            1 -> FragmentSignUp()
            else -> null
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Đăng Nhập"
            1 -> "Đăng Ký"
            else -> null
        }
    }
}