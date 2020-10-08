package com.example.iepirkumi

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Iepirkumu_saraksts::class])
abstract class Iepirkumu_Datubaze: RoomDatabase() {
    abstract fun Iepirkumu_saraksts(): ShoppingItemDao
}