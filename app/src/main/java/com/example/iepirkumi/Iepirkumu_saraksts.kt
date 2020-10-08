package com.example.iepirkumi

import androidx.room.*

@Entity
data class Iepirkumu_saraksts(
    val name: String,
    val quantity: Int,
    val unit: String,
    @PrimaryKey(autoGenerate = true) var uid:Long = 0)

@Dao
interface ShoppingItemDao {
    @Insert
    fun insertAll(vararg items: Iepirkumu_saraksts): List<Long>

    @Query("SELECT * FROM Iepirkumu_saraksts")
    fun getAll(): List<Iepirkumu_saraksts>

    @Query("SELECT * FROM Iepirkumu_saraksts WHERE uid = :itemId")
    fun getItemById(itemId: Long): Iepirkumu_saraksts

    @Update
    fun update(item: Iepirkumu_saraksts)

    @Delete
    fun delete(item: Iepirkumu_saraksts)
}
