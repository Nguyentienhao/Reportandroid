package com.nguyentienhao.haokn.hktshop.presenter.categories

import com.nguyentienhao.haokn.hktshop.contract.categories.CateContract
import com.nguyentienhao.haokn.hktshop.model.categories.Categories

class CatePresenter: CateContract.Presenter {

    override fun addDataInRecycler(): ArrayList<Categories> {

        val list: ArrayList<Categories> = ArrayList()

        list.add(Categories("1", "Đồ ăn vặt","https://i.imgur.com/ZcLLrkY.jpg"))
        list.add(Categories("2",  "Chuối","https://i.redd.it/obx4zydshg601.jpg"))
        list.add(Categories("3", "Thiết bị điện tử", "https://i.redd.it/glin0nwndo501.jpg"))
        list.add(Categories("4","Đồ gia dụng", "https://i.redd.it/k98uzl68eh501.jpg"))
        list.add(Categories("5", "Thiết bị xây dựng", "https://i.redd.it/j6myfqglup501.jpg"))
        list.add(Categories("6", "thiết bị y tế", "https://i.redd.it/tpsnoz5bzo501.jpg"))

        return list
    }
}