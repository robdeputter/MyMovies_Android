package com.example.mymovies.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * The database holds your favorites and the latest releases from Netflix
 *
 * [Database] = The list of entities included in the database. Each entity turns into a table in the database.
 */
@Database(
    /**
     * List of entities that are included in the database
     */
    entities = [DatabaseMovieSerieDetail::class, DatabaseNewRelease::class],
    /**
     * Defines the version of your, comes in handy if you want to go back to an older version of your database
     */
    version = 5,
    /**
     * You can set the annotation processor argument ({@code room.schemaLocation}) to tell Room to
     * export the database schema into a folder. Even though it is not mandatory, it is a good
     * practice to have version history of your schema in your codebase and you should commit the
     * schema files into your version control system (but don't ship them with your app!).
     */
    exportSchema = false
)

/**
 * abstract -> Abstract classes are not instantiated directly.
 */
abstract class MyMoviesDatabase : RoomDatabase() {
    abstract val favoritesDAO: FavoritesDAO
    abstract val newReleasesDAO: NewReleaseDAO

    /**
     * [companion] [object] An object which has the same name as the class
     */
    companion object {
        /**
         * [Volatile] =  Marks the JVM backing field of the annotated property as `transient`, meaning that it is not
         * part of the default serialized form of the object.
         * Why do you that? -> Means that writes to this field are immediately made visible to other threads.
         * This field is a singleton (only 1 instance)
         */
        @Volatile
        private var INSTANCE: MyMoviesDatabase? = null

        fun getInstance(context: Context): MyMoviesDatabase {
            /**
             * Multiple threads can ask for the database at the same time, ensure we only initialize
             * it once by using synchronized. Only one thread may enter a synchronized block at a
             * time.
             */

            synchronized(this) {
                /*
                 * Copy the current value of INSTANCE to a local variable so Kotlin can smart cast.
                 * Smart cast is only available to local variables.
                 */
                var instance = INSTANCE
                // If instance is `null` make a new database instance.
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyMoviesDatabase::class.java,
                        "movie_serie_history"
                    )
                        /*
                         * Wipes and rebuilds instead of migrating if no Migration object.
                         * Migration is not part of this lesson. You can learn more about
                         * migration with Room in this blog post:
                         * https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
                         */
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