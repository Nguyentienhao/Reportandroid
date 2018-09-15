package com.nguyentienhao.haokn.hktshop.contract.stores

import com.nguyentienhao.haokn.hktshop.BasePresenter
import com.nguyentienhao.haokn.hktshop.BaseView
import com.nguyentienhao.haokn.hktshop.model.store.Stores

interface StoreContract {
    interface View : BaseView<Presenter>{
        /**
         * this function use inflater xml and add adapter for RecyclerView for the stores.
         **/
        fun initStoresRecyclerView()
    }

    interface Presenter: BasePresenter {
        /**
         * add data for stores include name store and image store.
         * */
        fun addDataInRecycler(listStores: ArrayList<Stores>)
    }
}