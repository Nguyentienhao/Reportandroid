package com.nguyentienhao.haokn.hktshop.contract.categories

import com.nguyentienhao.haokn.hktshop.BasePresenter
import com.nguyentienhao.haokn.hktshop.BaseView
import com.nguyentienhao.haokn.hktshop.model.categories.Categories
import com.nguyentienhao.haokn.hktshop.model.store.Stores

interface CateContract {
    interface View : BaseView<Presenter> {
        fun initCateRecyclerView()
    }

    interface  Presenter: BasePresenter {
        fun addDataInRecycler(): ArrayList<Categories>
    }
}