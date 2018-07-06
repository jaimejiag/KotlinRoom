package com.jaime.kotlinroom.data.db


class KotlinRoomContract {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "kotlin_room.db"

    }


    class ProductEntry {

        companion object {
            const val TABLE_NAME = "product"
            const val COLUMN_ID = "id"
            const val COLUMN_NAME = "name"
            const val COLUMN_DESCRIPTION = "description"
            const val COLUMN_PRICE = "price"
            const val COLUMN_CATEGORY = "category";

            val ALL_COLUMNS = arrayOf(COLUMN_ID, COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_PRICE, COLUMN_CATEGORY)

            const val SQL_QUERY_ENTRIES = "SELECT * FROM " + TABLE_NAME
        }
    }


    class CategoryEntry {

        companion object {
            const val TABLE_NAME = "category"
            const val CALUMN_ID = "id"
            const val COLUMN_NAME = "name"

            const val SQL_QUERY_ENTRIES = "SELECT * FROM " + TABLE_NAME
        }
    }
}