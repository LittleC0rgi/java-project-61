plugins {
    id("application")
    id("checkstyle")
    id ("org.sonarqube") version "7.2.3.7755"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

application {
    // Define the main class for the application.
    mainClass = "hexlet.code.App"
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
  properties {
    property ("sonar.projectKey", "LittleC0rgi_java-project-61")
    property ("sonar.organization", "littlec0rgi")
    property("sonar.coverage.exclusions", "**/*")
  }
}