package com.nguyentienhao.haokn.hktshop.view.home

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.widget.Toast
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.adapter.StoreRecycleViewAdapter
import com.nguyentienhao.haokn.hktshop.contract.stores.StoreContract
import com.nguyentienhao.haokn.hktshop.model.store.Stores
import com.nguyentienhao.haokn.hktshop.presenter.stores.StorePresenter
import com.nguyentienhao.haokn.hktshop.view.account.AccountActivity
import com.nguyentienhao.haokn.hktshop.view.store.FragmentCateStore
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), StoreContract.View {
    private var listStores: ArrayList<Stores>? = null
    private var bottomNavigationView: BottomNavigationView? = null

    private var fragmentManager = supportFragmentManager
    private var fragmentTransaction = fragmentManager.beginTransaction()
    private var fragmentCateStore = FragmentCateStore()


    override var presenter: StoreContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        /*
        * add fragment category store to HomeActivity
        * */

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

        /*
        * call function from presenter
        * */
        listStores = presenter?.addDataInRecycler()

        Log.d("listStores", ("$listStores tie nao"))
        Log.d("Hao", "Nguyen tien hao")

        /*
        * inflater RecyclerView and add adapter for store
        * */
         initStoresRecyclerView()

        fragmentTransaction.add(R.id.fragmentContainerStore, fragmentCateStore)
        fragmentTransaction.commit()
        /*
        * create event on every item of bottom navigation.
        * */
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView?.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.itAccount ->
                {
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

    override fun initStoresRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val recyclerView: RecyclerView = findViewById(R.id.recycleViewCate)

        recyclerView.layoutManager = linearLayoutManager

        val adapter = StoreRecycleViewAdapter(this, listStores)

        recyclerView.adapter = adapter
    }
}