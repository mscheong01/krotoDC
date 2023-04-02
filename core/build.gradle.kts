
dependencies {
//    implementation(kotlin("stdlib"))
//    implementation("io.grpc:grpc-protobuf:${rootProject.ext["grpcJavaVersion"]}")
    // https://mvnrepository.com/artifact/com.google.protobuf/protobuf-java
    implementation("com.google.protobuf:protobuf-java:${rootProject.ext["protobufVersion"]}")
    implementation("io.grpc:grpc-stub:${rootProject.ext["grpcJavaVersion"]}")
    implementation("io.grpc:grpc-kotlin-stub:${rootProject.ext["grpcKotlinVersion"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${rootProject.ext["coroutinesVersion"]}")
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        named<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name.set("krotoDC core library")
                artifactId = "krotoDC-core"
                description.set("provides runtime support for krotoDC generated code")
            }
        }
    }
}
