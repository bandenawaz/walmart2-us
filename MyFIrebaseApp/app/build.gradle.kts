plugins {
}

    android {
    namespace = "com.example.myfirebaseapp"
    compileSdk = 33

    defaultConfig {
      applicationId = "com.example.myfirebaseapp"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
       release {
           isMinifyEnabled = false
           proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
       }
    }
    }

  dependencies {

  }