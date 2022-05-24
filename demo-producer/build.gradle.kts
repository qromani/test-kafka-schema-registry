import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    java
    id("com.google.protobuf") version "0.8.18"
}

group = "br.com.quanto"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

val ghPkgUsername by extra(System.getenv("GH_PACKAGES_USERNAME") ?: project.property("github.username").toString())
val ghPkgPassword by extra(System.getenv("GH_PACKAGES_PASSWORD") ?: project.property("github.token").toString())

repositories {
    mavenCentral()
    maven {
        url = uri("https://packages.confluent.io/maven")
    }
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
    maven {
        url = uri("https://maven.pkg.github.com/contaquanto/qtpb")
        credentials {
            username = ghPkgUsername
            password = ghPkgPassword
        }
    }
}

dependencies {



    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.kafka:spring-kafka")

    implementation("com.google.protobuf:protobuf-gradle-plugin:0.8.18")
    implementation("io.grpc:grpc-stub:1.46.0")
    implementation("io.grpc:grpc-protobuf:1.46.0")
    implementation("com.google.protobuf:protobuf-java:3.20.1")

    implementation("io.confluent:kafka-protobuf-serializer:7.1.1")
    implementation("br.com.quanto.qtpb:action-notification:35b67bb")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

protobuf {
    // protoc {
    //     // The artifact spec for the Protobuf Compiler
    //     artifact = "com.google.protobuf:protoc:3.6.1"
    // }
    
}