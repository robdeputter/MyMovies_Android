package com.example.mymovies.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mymovies.models.MovieSerieDetail

@Database(
    entities = [DatabaseMovieSerieDetail::class, DatabaseNewRelease::class],

    version = 5,
    exportSchema = false
)
abstract class MyMoviesDatabase : RoomDatabase() {


    abstract val favoritesDAO: FavoritesDAO
    abstract val newReleasesDAO : NewReleaseDAO


    companion object {

        @Volatile
        private var INSTANCE: MyMoviesDatabase? = null

        fun getInstance(context: Context): MyMoviesDatabase {
            // Multiple threads can ask for the database at the same time, ensure we only initialize
            // it once by using synchronized. Only one thread may enter a synchronized block at a
            // time.
            synchronized(this) {
                // Copy the current value of INSTANCE to a local variable so Kotlin can smart cast.
                // Smart cast is only iavailable to local variables.
                var instance = INSTANCE
                // If instance is `null` make a new database instance.
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyMoviesDatabase::class.java,
                        "movie_serie_history"
                    )
                        // Wipes and rebuilds instead of migrating if no Migration object.
                        // Migration is not part of this lesson. You can learn more about
                        // migration with Room in this blog post:
                        // https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
                        .fallbackToDestructiveMigration()
                        .build()
                    // Assign INSTANCE to the newly created database.
                    INSTANCE = instance
                }
                // Return instance; smart cast to be non-null.
                return instance
            }
        }

    }

}
