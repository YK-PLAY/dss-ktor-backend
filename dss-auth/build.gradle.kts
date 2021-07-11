plugins {
    kotlin("jvm")
    application
}

group = "ykplay.github.com"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
}

dependencies {
    implementation(project(":dss-common"))
    testImplementation(kotlin("test"))

    // java library
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2")

}

tasks.test {
    useJUnitPlatform()
}