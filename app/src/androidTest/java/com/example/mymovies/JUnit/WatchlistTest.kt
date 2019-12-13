package com.example.mymovies.JUnit

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.mymovies.database.MyMoviesDatabase
import com.example.mymovies.database.WatchListDAO
import com.example.mymovies.database.asDomainModel
import com.example.mymovies.models.MovieSerieDetail
import com.example.mymovies.models.asDatabaseModel
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class WatchlistTest {

    private lateinit var watchlistDAO: WatchListDAO
    private lateinit var database: MyMoviesDatabase
    private var movieSerieDetail1 = MovieSerieDetail("12345", "Friends", "1994", "series", "posterString", "1994", "24 min", "Comedy",
        "Jennifer Anniston ,...", "9", "23456", "Very funny story")

    @Before
    fun createDatabase() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        database = Room.inMemoryDatabaseBuilder(context, MyMoviesDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        watchlistDAO = database.watchListDAO
    }

    @After
    @Throws(IOException::class)
    fun closeDatabase() {
        database.close()
    }

    @Test
    @Throws(IOException::class)
    fun insertFavorite() {
        val watchlistEntity = movieSerieDetail1
        watchlistEntity.inWatchList = true

        watchlistDAO.insert(watchlistEntity.asDatabaseModel())
        val imdbId = watchlistEntity.imdbID

        var favoriteFromDatabase = watchlistDAO.get(imdbId)!!.asDomainModel()
        Assert.assertEquals(watchlistEntity.title, favoriteFromDatabase.title)
    }

    @Test
    @Throws(IOException::class)
    fun updateFavorite() {
        val watchlistEntity = movieSerieDetail1
        watchlistEntity.inWatchList = true
        watchlistEntity.favoriteRating = 2F

        watchlistDAO.insert(watchlistEntity.asDatabaseModel())
        watchlistEntity.favoriteRating = 4F
        watchlistDAO.update(watchlistEntity.asDatabaseModel())

        val favoriteFromDatabase = watchlistDAO.get(watchlistEntity.imdbID)!!.asDomainModel()
        Assert.assertEquals(4F, favoriteFromDatabase.favoriteRating)
    }

    @Test
    @Throws(IOException::class)
    fun deleteFavorite() {
        val watchlistEntity = movieSerieDetail1
        watchlistEntity.favoriteRating = 4F

        watchlistDAO.insert(watchlistEntity.asDatabaseModel())
        watchlistDAO.delete(watchlistEntity.asDatabaseModel())
        Assert.assertNull(watchlistDAO.get(watchlistEntity.imdbID))
    }
}