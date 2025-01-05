plugins {
    id("java")
}

group = "com.om1cael.vibratite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.xerial:sqlite-jdbc:3.47.2.0")
}