package com.example.iepirkumi

import android.app.Application
import androidx.room.Room

class app : Application() {

    val db by lazy {
        Room.databaseBuilder(this, Iepirkumu_Datubaze::class.java, "db-iepirkumi")
            .allowMainThreadQueries()
            .build()
    }
}