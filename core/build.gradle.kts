
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

configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
    coordinates(
        groupId = project.group.toString(),
        artifactId = "krotoDC-core",
        version = project.version.toString()
    )
    
    pom {
        name.set("krotoDC core library")
        description.set("provides runtime support for krotoDC generated code")
    }
}
