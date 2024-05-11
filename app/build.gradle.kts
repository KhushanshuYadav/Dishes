plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.khushanshu.recipeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.khushanshu.recipeapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //ADDING DEPENDENCIES FOR OUR PROJECT MIGHT BE OLDER VERSIONS OF THEM

    //dependency for Compose ViewModel
    //It provides integration between Lifecycle ViewModel and Jetpack Compose, specifically designed for Android development.
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2");

    //dependency for network call i.e to send request for data to api and to receive data from it
    //t simplifies making HTTP calls to REST APIs by providing a type-safe interface.
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    //JSON to kotlin object making as we receive JSON objects need to convert it to kotlin to work
    //t integrates with Gson, a popular JSON parsing library, to automatically convert JSON data in the response body to your defined model objects in Java.
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //to load image from database via link we obtain from response
    //Coil Compose is an image loading library specifically designed for use with Jetpack Compose, the modern UI framework for Android. It leverages the capabilities of Coil, another popular image loading library for Android, to provide functionalities like asynchronous image loading, caching, and transformations within Jetpack Compose.
    implementation("io.coil-kt:coil-compose:2.4.0")




    implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}