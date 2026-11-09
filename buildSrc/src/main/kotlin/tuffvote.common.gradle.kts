plugins {
    java
    id("com.gradleup.shadow")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")

    implementation(project(":common"))

    compileOnly("org.jetbrains:annotations:26.0.2")
    annotationProcessor("org.jetbrains:annotations:26.0.2")
}

tasks {
    withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
        archiveFileName.set("${rootProject.name}-${project.name}-$version.jar")
    }

    named("build") {
        dependsOn("shadowJar")
    }
}