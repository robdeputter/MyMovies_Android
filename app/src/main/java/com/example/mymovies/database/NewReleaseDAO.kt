package com.example.mymovies.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NewReleaseDAO{

    @Insert
    fun insert(newRelease: DatabaseNewRelease)

    @Update
    fun update(newRelease: DatabaseNewRelease)

    @Delete
    fun delete(newRelease: DatabaseNewRelease)

    @Query("SELECT * from databasenewrelease WHERE imdbId = :key")
    fun get(key: String): DatabaseNewRelease?

    @Query("DELETE FROM databasenewrelease")
    fun clear()

    @Query("SELECT * FROM databasenewrelease ORDER BY title ASC")
    fun getAllNewReleases(): LiveData<List<DatabaseNewRelease>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg newReleases: DatabaseNewRelease?)
}