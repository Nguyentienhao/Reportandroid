package com.nguyentienhao.haokn.hktshop.view.home

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.Toast
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.view.account.AccountActivity
import com.nguyentienhao.haokn.hktshop.view.categories.FragmentCate
import com.nguyentienhao.haokn.hktshop.view.store.FragmentCateStore
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    private var bottomNavigationView: BottomNavigationView? = null

    private var fragmentManager = supportFragmentManager
    private var fragmentTransaction = fragmentManager.beginTransaction()
    private var fragmentTransaction1 = fragmentManager.beginTransaction()

    private var fragmentCateStore = FragmentCateStore()
    private var fragmentCate = FragmentCate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        /*
        * install actionBar
        * */
        toolBarHome.title = ""
        setSupportActionBar(toolBarHome)

        fragmentTransaction.add(R.id.fragmentContainerStore, fragmentCateStore)
        fragmentTransaction.commit()
        fragmentTransaction1.add(R.id.fragmentContainerCate, fragmentCate)
        fragmentTransaction1.commit()


        /*
        * create event on every item of bottom navigation.
        * */
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itAccount -> {
                    val intent = Intent(this, AccountActivity::class.java)
                    startActivity(intent)
                }
                else -> Toast.makeText(this, "This is else", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    /*
    * funtion create menu for activity main.
    * */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }
}