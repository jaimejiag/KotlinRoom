package com.jaime.kotlinroom.data.db.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.jaime.kotlinroom.data.db.KotlinRoomContract


@Entity(tableName = KotlinRoomContract.ProductEntry.TABLE_NAME)
class Product() {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = KotlinRoomContract.ProductEntry.COLUMN_NAME)
    var name = ""

    @ColumnInfo(name = KotlinRoomContract.ProductEntry.COLUMN_DESCRIPTION)
    var description: String = ""

    @ColumnInfo(name = KotlinRoomContract.ProductEntry.COLUMN_PRICE)
    var price = 0.0

    @ColumnInfo(name = KotlinRoomContract.ProductEntry.COLUMN_CATEGORY)
    var category = 0

    @Ignore
    var ca: Category? = null


    constructor(id: Int, name: String, description: String, price: Double, category: Int) : this() {
        this.id = id
        this.name = name
        this.description = description
        this.price = price
        this.category = category
    }


    constructor(name: String, description: String, price: Double, category: Int) : this() {
        this.id = 0
        this.name = name
        this.description = description
        this.price = price
        this.category = category
    }
}