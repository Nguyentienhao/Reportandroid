package com.nguyentienhao.haokn.hktshop.contract.stores

import com.nguyentienhao.haokn.hktshop.BasePresenter
import com.nguyentienhao.haokn.hktshop.BaseView
import com.nguyentienhao.haokn.hktshop.model.store.Stores

interface CateContract {
    interface View : BaseView<Presenter> {
        fun initCateRecyclerView()
    }

    interface  Presenter: BasePresenter {
        fun addDataInRecycler(listStores: ArrayList<Stores>)
    }
}