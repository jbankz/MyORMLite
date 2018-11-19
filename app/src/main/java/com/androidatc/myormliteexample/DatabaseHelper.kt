package com.androidatc.myormliteexample

import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils


object DatabaseHelper: OrmLiteSqliteOpenHelper(App.instance, "names.db", null, 1) {
    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTableIfNotExists(connectionSource,
                Person::class.java)
    }

    override fun onUpgrade(database: SQLiteDatabase?, connectionSource: ConnectionSource?, oldVersion: Int,
                           newVersion: Int) {
        TableUtils.dropTable<Person, Any>(connectionSource, Person::class.java, true)
        onCreate(database, connectionSource)
    }
}
