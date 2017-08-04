package com.nnd.tripper.model

/**
 * Created by Android dev on 8/4/17.
 */
class Receipt constructor(val id: Int, val title: String, val date: String, val items: List<ReceiptItem>) {
    var total: Double = 0.0

    init {
        items.forEach { total.plus(it.price.times(it.quantity)) }
    }
}
