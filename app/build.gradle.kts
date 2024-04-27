plugins {
    id("io.ktor.plugin") version "2.3.10"
    kotlin("jvm") version "2.0.0-RC1"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-netty")

    implementation("ch.qos.logback:logback-classic:1.5.6")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "io.github.t45k.ktor_trial"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
