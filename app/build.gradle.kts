plugins {
    id("java")
    application
    checkstyle
}


group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.run {
    compileJava {
        options.release = 20
    }
}
tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}





