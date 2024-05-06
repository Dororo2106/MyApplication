plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    /*converter-name tends to any one from listed conververts*/
    implementation ("com.squareup.retrofit2:adapter-rxjava:2.7.1")
// HttpRequest and converters
// This is used for logging (Log) the responses of the WebServices
    implementation ("com.squareup.okhttp3:logging-interceptor:4.3.0")
// These are HTTP clients
    implementation ("com.squareup.okhttp3:okhttp-urlconnection:4.3.0")
// This is for receiving plain text from the WebServices
    implementation ("com.squareup.retrofit2:converter-scalars:2.7.1")
// This is for using Observable with Retrofit, so we don't have to worry about threading
    implementation ("com.squareup.retrofit2:adapter-rxjava:2.7.1")
// This is the plain JSON to object Parser
    implementation ("com.google.code.gson:gson:2.10")
// This the RXJava specific for Android
    implementation ("io.reactivex:rxandroid:1.2.1")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //ciserone
    implementation("com.github.terrakok:cicerone:7.1")

    implementation ("com.google.dagger:dagger:2.51.1")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.38")
    annotationProcessor ("com.google.dagger:dagger-android-processor:2.51.1")
    implementation ("com.google.dagger:dagger-android-support:2.51.1") // if you use the support libraries



}