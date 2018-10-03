package com.nguyentienhao.haokn.hktshop.presenter.stores

import com.nguyentienhao.haokn.hktshop.contract.stores.StoreContract
import com.nguyentienhao.haokn.hktshop.model.store.Stores

class StorePresenter: StoreContract.Presenter {

    override fun addDataInRecycler(): ArrayList<Stores> {

        var list: ArrayList<Stores> = ArrayList()

        list.add(Stores(nameStore = "của hàng bà thu", imgStore = "https://i.imgur.com/ZcLLrkY.jpg"))
        list.add(Stores(nameStore = "cửa hàng bà chín", imgStore = "https://i.redd.it/obx4zydshg601.jpg"))
        list.add(Stores(nameStore = "của hàng bà năm", imgStore = "https://i.redd.it/glin0nwndo501.jpg"))
        list.add(Stores(nameStore = "cửa hàng bà bảy", imgStore = "https://i.redd.it/k98uzl68eh501.jpg"))
        list.add(Stores(nameStore = "của hàng bà nà", imgStore = "https://i.redd.it/j6myfqglup501.jpg"))
        list.add(Stores(nameStore = "cửa hàng bà tám", imgStore = "https://i.redd.it/tpsnoz5bzo501.jpg"))

        return list

    }
}