package br.edu.up.secb.dados

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SapatosAfazer::class], version = 1)
abstract class SapatosAfazerDatabase: RoomDatabase(){

    abstract fun sapatosAfazerDao(): SapatosAfazerDao

    companion object{
        fun abrirBancoDeDados(context: Context): SapatosAfazerDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                SapatosAfazerDatabase::class.java, "sapatosAfazer.db"
            ).build()
        }
    }
}