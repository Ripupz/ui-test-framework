plugins {
    java
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

dependencies {

    // Cucumber JVM
    testImplementation("io.cucumber:cucumber-java:7.31.0")
    testImplementation("io.cucumber:cucumber-junit:7.31.0")

    // Selenium WebDriver
    testImplementation("org.seleniumhq.selenium:selenium-java:4.11.0")

    // WebDriverManager
    testImplementation("org.seleniumhq.selenium:selenium-firefox-driver:4.11.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")

    // JUnit (Cucumber JUnit runner)
    testImplementation("junit:junit:4.13.2")
}

tasks.test {
    useJUnit()

    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
    }
}
