/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/5.6.4/userguide/tutorial_java_projects.html
 */

plugins {
    java
    kotlin("jvm") version "1.6.0"
    application
}

application {
    mainClassName = "ru.randomsoftware.java2d.ApplicationKt"
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.0.1-jre")

    // Use JUnit test framework
    testImplementation("junit:junit:4.13.2")
}
