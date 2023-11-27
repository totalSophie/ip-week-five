plugins {
    id("java")
}

group = "org.herosquad"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.sparkjava:spark-core:2.9.3")
    implementation("org.slf4j:slf4j-simple:1.7.32")
    implementation("com.sparkjava:spark-template-freemarker:2.3")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}