package com.nguyentienhao.haokn.hktshop.view.categories

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nguyentienhao.haokn.hktshop.contract.categories.CateContract
import com.nguyentienhao.haokn.hktshop.R
import com.nguyentienhao.haokn.hktshop.adapter.CateRecycleViewAdapter
import com.nguyentienhao.haokn.hktshop.model.categories.Categories
import com.nguyentienhao.haokn.hktshop.presenter.categories.CatePresenter

class FragmentCate: Fragment(), CateContract.View {
    override var presenter: CateContract.Presenter? = null
    private var listCategories: ArrayList<Categories>? = null
    private var v: View? = null

    override fun initCateRecyclerView() {
        val linearLayoutManager: LinearLayoutManager? = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView: RecyclerView? = v?.findViewById(R.id.recycleViewCate)
        recyclerView?.layoutManager = linearLayoutManager
        val adapter = CateRecycleViewAdapter(context!!, listCategories)
        recyclerView?.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_categories, container, false)

        presenter = CatePresenter()

       listCategories = presenter?.addDataInRecycler()

        initCateRecyclerView()

        return v
    }
}