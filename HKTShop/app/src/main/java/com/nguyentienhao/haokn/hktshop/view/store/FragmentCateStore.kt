package com.nguyentienhao.haokn.hktshop.view.store

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.adapter.StoreRecycleViewAdapter
import com.nguyentienhao.haokn.hktshop.contract.stores.StoreContract
import com.nguyentienhao.haokn.hktshop.model.store.Stores
import com.nguyentienhao.haokn.hktshop.presenter.stores.StorePresenter

class FragmentCateStore : Fragment(), StoreContract.View {
    private var listStores: ArrayList<Stores>? = null
    override var presenter: StoreContract.Presenter? = null
    private var view1: View? = null

    override fun initStoresRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView: RecyclerView? = view1?.findViewById(R.id.recycleViewStore)
        recyclerView?.layoutManager = linearLayoutManager
        val adapter = StoreRecycleViewAdapter(context!!, listStores)
        recyclerView?.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view1 = inflater.inflate(R.layout.fragment_store, container, false)

        presenter = StorePresenter()

        listStores = presenter?.addDataInRecycler()


        initStoresRecyclerView()

        return view1
    }
}