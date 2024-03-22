import org.gradle.internal.impldep.bsh.commands.dir

plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.farepaymentsysapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.farepaymentsysapp"
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
                "proguard-rules.pro")
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation("androidx.activity:activity:1.8.2")
    implementation("com.android.support:support-annotations:28.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation ("com.github.freddygenicho:mpesa-android:1.1.1")
    implementation ("com.github.jumadeveloper:networkmanager:0.0.2")
    androidTestImplementation ("androidx.test:runner:1.5.2")
    implementation ("com.jakewharton:butterknife:10.1.0")
    annotationProcessor ("com.jakewharton:butterknife-compiler:10.1.0")
    implementation ("com.jakewharton.timber:timber:4.7.1")
    implementation ("com.github.jumadeveloper:networkmanager:0.0.2")
    implementation ("cn.pedant.sweetalert:library:1.3")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:3.12.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation ("com.google.code.gson:gson:2.10")
    implementation ("com.squareup.okio:okio:3.2.0")
    implementation ("javax.annotation:javax.annotation-api:1.3.2")
}