import com.expediagroup.graphql.plugin.gradle.tasks.GraphQLGenerateSDLTask

plugins {
    id("io.ktor.plugin") version "2.3.10"
    kotlin("jvm") version "2.0.0-RC1"

    id("com.expediagroup.graphql") version "7.1.1"
}

repositories {
    mavenCentral()
}

val graphqlKotlinVersion = "7.1.1"

dependencies {
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-netty")

    implementation("com.expediagroup:graphql-kotlin-ktor-server:$graphqlKotlinVersion")

    implementation("ch.qos.logback:logback-classic:1.5.6")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

val graphqlGenerateSDL by tasks.getting(GraphQLGenerateSDLTask::class) {
    packages.set(listOf("io.github.t45k.ktor_trial"))
    schemaFile.set(file("${project.projectDir}/schema.graphql"))
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
