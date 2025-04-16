import com.google.protobuf.gradle.id

repositories {
    maven {
        url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    }
    mavenLocal()
}

dependencies {
//    implementation(kotlin("stdlib"))
//    implementation("io.grpc:grpc-protobuf:${rootProject.ext["grpcJavaVersion"]}")
    // https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java

    // TODO: update example protobuf dependency to 4+
    // implementation("com.google.protobuf:protobuf-java:${rootProject.ext["protobufVersion"]}")
    // implementation("com.google.protobuf:protobuf-java-util:${rootProject.ext["protobufVersion"]}")
    implementation("com.google.protobuf:protobuf-java:3.25.4")
    implementation("com.google.protobuf:protobuf-java-util:3.25.4")

    implementation("io.grpc:grpc-stub:${rootProject.ext["grpcJavaVersion"]}")
    implementation("io.grpc:grpc-kotlin-stub:${rootProject.ext["grpcKotlinVersion"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.ext["coroutinesVersion"]}")
    implementation("io.grpc:grpc-protobuf:${rootProject.ext["grpcJavaVersion"]}")
    implementation("io.github.mscheong01:krotoDC-core:1.1.1")
    runtimeOnly("io.grpc:grpc-netty:${rootProject.ext["grpcJavaVersion"]}")

    testImplementation("javax.annotation:javax.annotation-api:1.3.2")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    // https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("io.grpc:grpc-testing:${rootProject.ext["grpcJavaVersion"]}")
}

protobuf {
    protoc {
        // artifact = "com.google.protobuf:protoc:${rootProject.ext["protobufVersion"]}"
        artifact = "com.google.protobuf:protoc:3.25.4"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${rootProject.ext["grpcJavaVersion"]}"
        }
        id("krotoDC") {
            artifact = "io.github.mscheong01:protoc-gen-krotoDC:1.1.1:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
//            if (it.name.startsWith("generateTestProto")) {
//                it.dependsOn("jar")
//            }

            it.plugins {
                id("grpc")
                id("krotoDC")
            }
        }
    }
}

tasks.withType<AbstractPublishToMaven> {
    enabled = false
}
