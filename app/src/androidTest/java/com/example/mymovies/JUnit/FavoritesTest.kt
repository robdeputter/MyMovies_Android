package com.example.mymovies.JUnit

import android.graphics.Movie
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.mymovies.database.FavoritesDAO
import com.example.mymovies.database.MyMoviesDatabase
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
class FavoritesTest{

    private lateinit var favoritesDAO: FavoritesDAO
    private lateinit var database : MyMoviesDatabase
    private var movieSerieDetail1 = MovieSerieDetail("12345","Friends" ,"1994","series","posterString","1994","24 min", "Comedy",
        "Jennifer Anniston ,...", "9","23456","Very funny story")

    @Before
    fun createDatabase(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        database = Room.inMemoryDatabaseBuilder(context, MyMoviesDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        favoritesDAO = database.favoritesDAO
    }

    @After
    @Throws(IOException::class)
    fun closeDatabase(){
        database.close()
    }

    @Test
    @Throws(IOException::class)
    fun insertFavorite(){
        val favorite = movieSerieDetail1
        favorite.favoriteRating = 5f

        favoritesDAO.insert(favorite.asDatabaseModel())
        val imdbId = favorite.imdbID

        var favoriteFromDatabase = favoritesDAO.get(imdbId)!!.asDomainModel()
        Assert.assertEquals(favorite.title,favoriteFromDatabase.title)
    }

    @Test
    @Throws(IOException::class)
    fun updateFavorite(){
        val favorite = movieSerieDetail1
        favorite.favoriteRating = 4F

        favoritesDAO.insert(favorite.asDatabaseModel())
        favorite.favoriteRating = 5F
        favoritesDAO.update(favorite.asDatabaseModel())

        val favoriteFromDatabase = favoritesDAO.get(favorite.imdbID)!!.asDomainModel()
        Assert.assertEquals(5F, favoriteFromDatabase.favoriteRating)
    }

    @Test
    @Throws(IOException::class)
    fun deleteFavorite(){
        val favorite = movieSerieDetail1
        favorite.favoriteRating = 4F

        favoritesDAO.insert(favorite.asDatabaseModel())
        favoritesDAO.delete(favorite.asDatabaseModel())
        Assert.assertNull(favoritesDAO.get(favorite.imdbID))
    }
}