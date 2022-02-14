buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath ("de.jensklingenberg.cabret:cabret-gradle:1.0.3")
        classpath("com.apollographql.apollo3:apollo-gradle-plugin:${Versions.apollo}")
    }

}