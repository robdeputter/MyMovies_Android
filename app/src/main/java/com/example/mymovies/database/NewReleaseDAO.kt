package com.example.mymovies.database

import androidx.lifecycle.LiveData
import androidx.room.*


/**
 * NewReleasesDAO is an interface that provides all the methods that are necessary to manipulate the new releases (on Netflix)
 * in the database
 *
 * [Dao] Data Access Objects are the main classes where you define your database interactions. $
 * They can include a variety of query methods.
 */
@Dao
interface NewReleaseDAO{
    /**
     * Add an object of a new release to the database.
     */
    @Insert
    fun insert(newRelease: DatabaseNewRelease)

    /**
     * Update an object of a new release to the database.
     */
    @Update
    fun update(newRelease: DatabaseNewRelease)

    /**
     * Delete an object of a new release to the database.
     */
    @Delete
    fun delete(newRelease: DatabaseNewRelease)

    /**
     * Get a new release by it's imdbId
     */
    @Query("SELECT * from databasenewrelease WHERE imdbId = :key")
    fun get(key: String): DatabaseNewRelease?

    /**
     * Clear the new releases
     */
    @Query("DELETE FROM databasenewrelease")
    fun clear()

    /**
     * Get all the new releases
     */
    @Query("SELECT * FROM databasenewrelease ORDER BY title ASC")
    fun getAllNewReleases(): LiveData<List<DatabaseNewRelease>>

    /**
     * Insert all the new releases
     *
     * "onConflict = = OnConflictStrategy.REPLACE) = if a value in the database has the same imdbId as the one that you want to add,
     * then you replace it with the new value
     *
     * [vararg] => When we call a vararg-function, we can pass arguments one-by-one
     * ==> vararg will insert the new releases, one by one
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg newReleases: DatabaseNewRelease?)
}