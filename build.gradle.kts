plugins {
    kotlin("jvm") version "2.1.0"
    id("com.gradleup.shadow") version "8.3.5"
    id("application")
}

group = "com.github.manuelarte.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    implementation("org.apache.spark:spark-core_2.13:4.0.0-preview2")
    implementation("org.apache.spark:spark-sql_2.13:4.0.0-preview2")


    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass = "com.github.manuelarte.demo.MainKt"
}

tasks.jar {
    manifest.attributes["Main-Class"] = "com.github.manuelarte.demo.MainKt"
}

tasks.shadowJar {
    isZip64 = true
}