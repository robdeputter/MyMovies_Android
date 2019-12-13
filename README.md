Creator: Rob De Putter (HOGENT - Group: 3C)

# MyMovies - Android application

MyMovies is an application where you can look up all movies and series. You can request a detailed list to provide more information about a particular film or series.  There is also the possibility to add them to your favourites. 

Furthermore, this app also offers the possibility to consult the latest releases of Netflix, so you can already look forward to a brand new season of your favorite series.

If you like to let your friends know about a movie or series that you liked very much, you can share it through different platforms (mail, messages, messenger,...).

## Technical
This app demonstrates the following views and techniques:

* [Retrofit](https://square.github.io/retrofit/) to make api calls to an HTTP web service
* [Moshi](https://github.com/square/moshi) which handles the deserialization of the returned JSON to Kotlin data objects 
* [Glide](https://bumptech.github.io/glide/) to load and cache images by URL.
  
It leverages the following components from the Jetpack library:

* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Data Binding](https://developer.android.com/topic/libraries/data-binding/) with binding adapters
* [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) with the SafeArgs plugin for parameter passing between fragments

## Working with the app

Clone the repo.

```bash
git clone https://github.com/robdeputter/MyMovies_Android.git
```
## Getting Started

These instructions will get you a copy of the project up and running on your local machine
for development and testing purposes.

### Prerequisites

- Android Studio
- Gradle


### Installing

Checkout the repository, build the APK using Android Studio and test on your physical device or emulator. 

## Built With

* [Android Studio](https://developer.android.com/studio) - The IDE used
* [Gradle](https://gradle.org/) - Build system

## Documentation

[Dokka files](app/javadoc/app/index.md)

## Report Issues

Notice any issues with a repository? Please file a github issue in the repository.
