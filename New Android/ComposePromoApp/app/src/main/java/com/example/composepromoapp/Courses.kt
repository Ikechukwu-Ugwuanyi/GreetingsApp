package com.example.composepromoapp

import androidx.annotation.DrawableRes

data class Courses(
    val rating: Float,
    val title : String,
    @DrawableRes val img: Int,
    val body: String
)

val course1 = Courses(
    3.2f,
    "The Complete Android 14 Developer Course - Java & Kotlin",
    R.drawable.vector,
    "Learn Android App Development in both Java &amp; Kotlin Languages. You'll master Android from ZERO to HERO"
)

val course2 = Courses(
    4.4f,
    "The Complete Android 14 & Kotlin Development Masterclass",
    R.drawable.vector2,
    "Learn Android 14 App Development From Beginner to Advanced Developer. Build Apps like Trello, 7Min Workout, Weather App"
    + "\n Learn Android 14 App Development From Beginner to Advanced Developer. Build Apps like Trello, 7Min Workout, Weather App"

)

val course3 = Courses(
    3.5f,
    "Android 14 App Development Bootcamp 2023 - Build a portfolio",
    R.drawable.vector3,
    "The Android Development Bootcamp is a brand new, up-to-date course providing the perfect introduction to the real-world Android concepts and skills required to be a successful Android developer in 2023. " +
            "\n Whether you are a complete beginner or are coming from another language or platform, " +
            "\n this course will go from setting up and installing Android Studio to building real apps that are useful and look great. " +
            "\n You'll gain a deep understanding of the core important aspects of Android app development, " +
            "\n and you will be taught by a fully qualified teacher who made a switch from a completely different career into being a Senior Android Engineer at a major UK company making apps for millions of users."
)


val course4 = Courses(
    3.5f,
    "Kotlin Coroutines and Flow for Android Development [",
    R.drawable.vector4,
     "This course will give you a deep understanding of Kotlin Coroutines and Flow and show how to implement the most common use cases for Android applications." +
             "\n This course consists of two big parts: The Coroutines part and the Flow part.\n" +
             "\n" +
             "Before being able to use Flows in our applications, we first need a solid understanding of Coroutines. " +
             "\n That’s why Coroutines are covered first. However, if you already have some experience with Coroutines, then you can also start with the Flow part right away, " +
             "\n and jump back to lessons of the Coroutines part whenever needed.",
)

val course5 = Courses(
    3.5f,
    "Android Jetpack Compose: The Comprehensive Bootcamp",
    R.drawable.vector5,
    "Kotlin Android App Development: Firebase Firestore, Hilt & Dagger, ROOM DB, ViewModel, Navigation & Clean Architecture" +
            "\n Jetpack Compose brings a paradigm shift in Android development - we now describe the UI instead of specifying the steps to build a UI. With Jetpack Compose, development time is accelerated as we can iterate fast with live previews while developing User Interfaces in Android Studio.\n" +
            "\n" +
            "With Jetpack, creating slick animations and using Material Design is a breeze because the toolkit is powered by the Android platform APIs and intuitive Kotlin APIs."
)

val course6 = Courses(
    2.5f,
    "Full Android Development Masterclass | 14 Real Apps-46 Hours",
    R.drawable.vector6,
    "The most comprehensive Android app development course, learn android development with Android Studio &amp; Java and level up " +
            "\n Welcome to the \"Full Android Development Masterclass | 14 Real Apps-46 Hours\" course\n" +
            "The most comprehensive Android app development course, learn android development with Android Studio & Java and level up\n" +
            "\n" +
            "Android tablets and phones are very popular, and apps created for this operating system can reach a large audience Whether you are interested in a career in mobile app development or looking to develop a game or app of your own design independently, let our top rated instructors on Oak Academy help prepare you with an Android development course"

)

val allCourses = listOf(
    course1,
    course2,
    course3,
    course4,
    course5,
    course6
)



