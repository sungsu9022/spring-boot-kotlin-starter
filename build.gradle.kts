import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.31"
	kotlin("plugin.spring") version "1.4.31"
	kotlin("plugin.jpa") version "1.4.31"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.springframework.boot:spring-boot-starter-tomcat")
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
	implementation("javax.servlet:jstl")
	//	runtimeOnly("com.h2database:h2")
	implementation("com.h2database:h2")
	implementation("org.hibernate:hibernate-ehcache")

	implementation("org.springframework.boot:spring-boot-starter-log4j2")
	/**
	 * log4j2의 Dependency 에 포함되면 해당 dependency 제거 필요
	참고 : https://www.mkyong.com/logging/log4j-2-java-lang-noclassdeffounderror-com-lmax-disruptor-eventtranslatorvararg/
	 */
	implementation("com.lmax:disruptor:3.4.2")


	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configurations {
	all {
		exclude("org.springframework.boot",  "spring-boot-starter-logging")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}


val profile = project.findProperty("profile") ?: "local"
println("profile : ${profile}");
sourceSets {
	main {
		resources {
			srcDirs(listOf("src/main/resources", "src/main/resources-${profile}"))
		}
	}
}
