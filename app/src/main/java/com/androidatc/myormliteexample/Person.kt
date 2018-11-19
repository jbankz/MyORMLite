package com.androidatc.myormliteexample

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable


@DatabaseTable(tableName = "person")
data class Person(
        @DatabaseField(generatedId = true)
        var accountId: Int? = null,

        @DatabaseField
        var name: String? = null
)

class PersonDao {
    companion object {
        lateinit var dao: Dao<Person, Int>
    }

    init {
        dao = DatabaseHelper.getDao(Person::class.java)
    }

    fun add(person: Person) = dao.createOrUpdate(person)
    fun update(person: Person) = dao.update(person)
    fun delete(person: Person) = dao.delete(person)
    fun queryForAll() = dao.queryForAll()
    fun removeAll() {
        for (table in queryForAll()) {
            dao.delete(table)
        }
    }
}
