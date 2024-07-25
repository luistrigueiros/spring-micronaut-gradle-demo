plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.4.0"
    id("io.micronaut.aot") version "4.4.0"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
//    annotationProcessor("io.micronaut.json-schema:micronaut-json-schema-processor")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    annotationProcessor("io.micronaut.spring:micronaut-spring-annotation")
    annotationProcessor("io.micronaut.spring:micronaut-spring-boot-annotation")
    annotationProcessor("io.micronaut.spring:micronaut-spring-web-annotation")
    annotationProcessor("io.micronaut.validation:micronaut-validation-processor")
    implementation("io.micronaut:micronaut-http-server")
//    implementation("io.micronaut.json-schema:micronaut-json-schema-annotations")
    implementation("io.micronaut.problem:micronaut-problem-json")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.validation:micronaut-validation")
    implementation("jakarta.validation:jakarta.validation-api")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("io.micronaut.spring:micronaut-spring-boot")
    runtimeOnly("io.micronaut.spring:micronaut-spring-web")
    testAnnotationProcessor("io.micronaut.spring:micronaut-spring-boot-annotation")
    testAnnotationProcessor("io.micronaut.spring:micronaut-spring-web-annotation")
    testImplementation("io.micronaut:micronaut-http-client")
//    testImplementation("io.micronaut.json-schema:micronaut-json-schema-validation")
}


application {
    mainClass = "com.example.Application"
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}


graalvmNative.toolchainDetection = false
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
    aot {
    // Please review carefully the optimizations enabled below
    // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
}



