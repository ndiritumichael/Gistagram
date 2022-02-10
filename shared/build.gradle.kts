plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.apollographql.apollo").version(Versions.apollo)
    kotlin("plugin.serialization") version Versions.kotlinSerialization
    id("io.realm.kotlin") version Versions.realm
}

kotlin {
    android()

    /*listOf(
        iosX64(),
        iosArm64()
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }*/

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(Dependencies.koinCore)

                implementation(Dependencies.ktorCore)
                implementation(Dependencies.ktorSerialization)
                implementation(Dependencies.ktorLogging)
                implementation(Dependencies.kotlinSerialization)
                implementation(Dependencies.apolloRuntime)

                implementation(Dependencies.realm)
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
            }
        }

        /*val iosMain by getting {
            dependencies {
                implementation(Dependencies.ktoriOS)
            }
        }*/

        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.1")
            }
        }

        /*val iosX64Main by getting
        val iosArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
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


/*apollo {
    packageName.set("com.vickikbt.gistagram")
    generateOptionalOperationVariables.set(false)
}*/
