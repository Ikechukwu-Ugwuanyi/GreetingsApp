plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.maincomposeuipractice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.maincomposeuipractice"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        compose = true
    }

    composeOptions{
        kotlinCompilerExtensionVersion = "1.9.10"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.compose.foundation:foundation:1.6.3")
    implementation("androidx.compose.material:material:1.6.3")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.material3:material3-window-size-class:1.2.1")
    implementation("androidx.compose.material3:material3-adaptive-navigation-suite:1.0.0-alpha05")

    implementation("androidx.compose.runtime:runtime:1.6.3")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.3")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.6.3")
    implementation("androidx.compose.ui:ui:1.6.3")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha13")
    implementation("androidx.appcompat:appcompat-resources:1.6.1")


}