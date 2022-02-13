plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.apollographql.apollo").version(Versions.apollo)
    kotlin("plugin.serialization") version Versions.kotlinSerialization
    id("com.squareup.sqldelight")
}

kotlin {
    android()

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(Dependencies.coroutinesKmm)

                implementation(Dependencies.koinCore)

                implementation(Dependencies.kotlinxSerialization)

                implementation(Dependencies.sqlDelight)
                implementation(Dependencies.sqlDelightCoroutines)

                implementation(Dependencies.ktorCore)
                implementation(Dependencies.ktorSerialization)
                implementation(Dependencies.ktorLogging)

                implementation(Dependencies.apolloRuntime)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Dependencies.ktorAndroid)
                implementation(Dependencies.sqlDelightAndroid)
            }
        }

        /*val iosMain by getting {
            dependencies {
                implementation(Dependencies.ktoriOS)
                implementation(Dependencies.sqlDelightiOS)
            }
        }*/

        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.1")
            }
        }

        /*val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
        }*/

    }
}

android {
    compileSdk = AndroidSdk.compileSdkVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
    }
}


/*sqldelight {
    database("AppDatabase") {
        packageName = "com.vickikbt.shared.cache.sqldelight"
    }
}*/

sqldelight {
    database(name = "AppDatabase") {
        packageName = "com.vickikbt.shared.sqldelight"
    }
}
