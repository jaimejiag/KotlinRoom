package com.jaime.kotlinroom.data.db.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.jaime.kotlinroom.data.db.KotlinRoomContract

@Entity(tableName = KotlinRoomContract.CategoryEntry.TABLE_NAME)
class Category() {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = KotlinRoomContract.CategoryEntry.COLUMN_NAME)
    var name = ""


    constructor(id: Int, name: String) : this() {
        this.id = id
        this.name = name
    }
}