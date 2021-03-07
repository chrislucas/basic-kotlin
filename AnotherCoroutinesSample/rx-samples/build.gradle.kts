import org.jetbrains.kotlin.gradle.tasks.KotlinCompile as KotlinCompile

apply ("../tools/dependencies-version.gradle")

plugins {
    java
    kotlin("jvm") version "1.4.20-M1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    mavenCentral()
}


tasks.withType<KotlinCompile> {
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.reactivex.rxjava3:rxjava:3.0.7")
    testImplementation("junit", "junit", "4.13")
}
