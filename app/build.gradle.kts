plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //step1.1: add plugin for kapt & hilt
    //hilt
    id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android")
    //Migrate from kapt to KSP
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.abdul.bhaiya.paging3demo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.abdul.bhaiya.paging3demo"
        minSdk = 24
        targetSdk = 33
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //step1.2: add require dependencies
    //hilt
    val hilt_version = "2.48"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    //kapt("com.google.dagger:hilt-android-compiler:$hilt_version")
    ksp("com.google.dagger:hilt-android-compiler:$hilt_version")
    annotationProcessor ("com.google.dagger:hilt-compiler:$hilt_version")

    //lifecycle with view-model & livedata
    val lifecycle_version = "2.6.2"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    //retrofit
    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    //room
    val room_version = "2.5.2"
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    //kapt("androidx.room:room-compiler:$room_version")
    ksp("androidx.room:room-compiler:$room_version")

    //coroutines
    val coroutines_version = "1.7.1"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

    //paging
    val paging_version = "3.2.1"
    implementation ("androidx.paging:paging-runtime:$paging_version")
}