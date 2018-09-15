package com.nguyentienhao.haokn.hktshop.view.home

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.widget.Toast
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.adapter.StoreRecycleViewAdapter
import com.nguyentienhao.haokn.hktshop.contract.stores.StoreContract
import com.nguyentienhao.haokn.hktshop.model.store.Stores
import com.nguyentienhao.haokn.hktshop.presenter.stores.StorePresenter
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), StoreContract.View {
    private var listStores: ArrayList<Stores>? = null
    private var bottomNavigationView: BottomNavigationView? = null


    override var presenter: StoreContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        /*
        * dựt dây tới presenter
        * */
        presenter = StorePresenter()

        /*
        * install actionBar
        * */
        toolBarHome.title = ""
        setSupportActionBar(toolBarHome)

        /*
         * create list stores
         */
        listStores = ArrayList()

        /*
        * call function from presenter
        * */
        presenter?.addDataInRecycler(listStores!!)

        /*
        * inflater RecyclerView and add adapter for store
        * */
        initStoresRecyclerView()

        /*
        * create event on every item of bottom navigation.
        * */
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView?.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_favorites ->
                    Toast.makeText(this, "This is favorites", Toast.LENGTH_SHORT).show()
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

    override fun initStoresRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val recyclerView: RecyclerView = findViewById(R.id.recycleViewStore)

        recyclerView.layoutManager = linearLayoutManager

        val adapter = StoreRecycleViewAdapter(this, listStores)

        recyclerView.adapter = adapter
    }
}