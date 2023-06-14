import com.google.protobuf.gradle.id

plugins {
    application
}

java {
    withJavadocJar()
}

application {
    mainClass.set("io.github.mscheong01.krotodc.MainExecutor")
}

dependencies {
//    implementation(kotlin("stdlib"))
//    implementation("io.grpc:grpc-protobuf:${rootProject.ext["grpcJavaVersion"]}")
    // https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java
    implementation("com.google.protobuf:protobuf-java:${rootProject.ext["protobufVersion"]}")

    implementation(kotlin("reflect"))
    implementation("com.squareup:kotlinpoet:${rootProject.ext["kotlinPoetVersion"]}")
    // https://mvnrepository.com/artifact/com.squareup.okhttp/okhttp
    implementation("com.squareup.okhttp:okhttp:2.7.5")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")

    implementation("io.grpc:grpc-stub:${rootProject.ext["grpcJavaVersion"]}")
    implementation("io.grpc:grpc-kotlin-stub:${rootProject.ext["grpcKotlinVersion"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.ext["coroutinesVersion"]}")
    implementation(project(":core"))
    testImplementation("io.grpc:grpc-protobuf:${rootProject.ext["grpcJavaVersion"]}")

    testImplementation("javax.annotation:javax.annotation-api:1.3.2")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    // https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("io.grpc:grpc-testing:${rootProject.ext["grpcJavaVersion"]}")
}

publishing {
    publications {
        named<MavenPublication>("maven") {
            pom {
                name.set("krotoDC")
                artifactId = "protoc-gen-krotoDC"
                description.set(
                    "protoc-gen-krotoDC is a protoc plugin for generating kotlin data classes and " +
                        "grpc service/stub from a .proto input."
                )
            }

            artifact(tasks.jar) {
                classifier = "jdk8"
            }
        }
    }
}

tasks.jar {
    println(application.mainClass.get())
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }

    from(sourceSets.main.get().output)

    val runtimeClasspathJars = configurations.runtimeClasspath.get().filter { it.name.endsWith(".jar") }
    from(runtimeClasspathJars.map { zipTree(it) })

    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

protobuf {

    protoc {
        artifact = "com.google.protobuf:protoc:${rootProject.ext["protobufVersion"]}"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${rootProject.ext["grpcJavaVersion"]}"
        }
//        id("grpckt") {
//            artifact = "io.grpc:protoc-gen-grpc-kotlin:${rootProject.ext["grpcJavaVersion"]}"
//        }
        id("krotoDC") {
            path = tasks.jar.get().archiveFile.get().asFile.absolutePath
        }
    }
    generateProtoTasks {
        all().forEach {
            if (it.name.startsWith("generateTestProto")) {
                it.dependsOn("jar")
            }

            it.plugins {
                id("grpc")
//                id("grpckt")
                id("krotoDC")
            }
        }
    }
}
