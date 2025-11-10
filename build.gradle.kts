plugins {
    kotlin("jvm") version "2.2.21" apply false
    id("com.google.protobuf") version "0.9.4" apply false
    id("com.vanniktech.maven.publish") version "0.34.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.3.1"
}

group = "io.github.mscheong01"
if (project.hasProperty("releaseVersion")) {
    version = project.property("releaseVersion") as String
}

ext["grpcJavaVersion"] = "1.70.0"
ext["grpcKotlinVersion"] = "1.4.0"
ext["protobufVersion"] = "4.30.1"
ext["coroutinesVersion"] = "1.8.1"
ext["kotlinPoetVersion"] = "1.18.1"

repositories {
    mavenCentral()
}

subprojects {
    apply {
        plugin("java")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("com.google.protobuf")
        plugin("com.vanniktech.maven.publish")
        plugin("org.jlleitschuh.gradle.ktlint")
    }

    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            freeCompilerArgs.add("-Xjsr305=strict")
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8)
        }
    }

    configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
        publishToMavenCentral()

        // Release 버전만 서명 (snapshot은 서명 안 함)
        if (project.hasProperty("releaseVersion")) {
            signAllPublications()
        }

        pom {
            name.set(project.name)
            description.set("Kotlin gRPC DataClass serialization library")
            url.set("https://github.com/mscheong01/krotoDC")

            licenses {
                license {
                    name.set("Apache 2.0")
                    url.set("https://opensource.org/licenses/Apache-2.0")
                    distribution.set("repo")
                }
            }

            developers {
                developer {
                    id.set("mscheong01")
                    name.set("Minsoo Cheong")
                    email.set("icycle0409@snu.ac.kr")
                    organization.set("MinsooCheong")
                    organizationUrl.set("https://github.com/mscheong01")
                }
            }

            scm {
                connection.set("scm:git:git@github.com:mscheong01/krotoDC.git")
                developerConnection.set("scm:git:git@github.com:mscheong01/krotoDC.git")
                url.set("https://github.com/mscheong01/krotoDC")
            }
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        ktlint {
            filter {
                exclude { entry ->
                    entry.file.toString().contains("generated")
                }
            }
        }
    }
}

tasks.register("updateVersion") {
    if (rootProject.hasProperty("next")) {
        val file = File(rootProject.rootDir, "gradle.properties")
        val prop = java.util.Properties().apply { load(java.io.FileInputStream(file)) }
        val ver = rootProject.property("next") as String
        if (ver != prop.getProperty("version")) {
            prop.setProperty("version", ver)
            prop.store(java.io.FileOutputStream(file), null)
        }
    }
}
