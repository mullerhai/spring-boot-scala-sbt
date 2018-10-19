
/*
  General Scala attributes
 */
scalaVersion := "2.11.7"

/*
  General project attributes
 */
organization := "de.codecentric"
name := "SpringBootScala"
version := "0.1"
maintainer := "Björn Jacobs <bjoern.jacobs@codecentric.de>"
description := "A demo how to use Spring Boot with Scala for building a basic microservice"
organizationHomepage := Some(url("http://www.codecentric.de"))

resolvers += "spring-cloud" at "https://repo.spring.io/milestone"

/*
  Project dependencies
 */
libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "2.0.5.RELEASE",
  "org.springframework.boot" % "spring-boot-configuration-processor" % "2.0.5.RELEASE"
)

/*
  Packaging plugin
 */

// enable the Java app packaging archetype and Ash script (for Alpine Linux, doesn't have Bash)
enablePlugins(JavaAppPackaging, AshScriptPlugin)

// set the main entrypoint to the application that is used in startup scripts
mainClass in Compile := Some("de.codecentric.microservice.MyServiceApplication")

// the Docker image to base on (alpine is smaller than the debian based one (120 vs 650 MB)
dockerBaseImage := "mullerhelen/centos7-jdk8:0.2"

// creates tag 'latest' as well when publishing
dockerUpdateLatest := true


exportJars := true
mainClass in assembly := Some("de.codecentric.microservice.MyServiceApplication")
mainClass in (Compile ,run):= Some("de.codecentric.microservice.MyServiceApplication")
assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*)               => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".properties" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".xml"        => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".types"      => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".class"      => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".json"       => MergeStrategy.last
  case PathList(ps @ _*) if ps.last endsWith ".provides"   => MergeStrategy.last
  case PathList(ps @ _*) if ps.last endsWith ".factories"  => MergeStrategy.last
  case "application.conf"                                  => MergeStrategy.concat
  case "unwanted.txt"                                      => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}


libraryDependencies += "org.springframework" % "spring-core" % "4.1.6.RELEASE" exclude("commons-logging", "commons-logging")
//
libraryDependencies += "org.springframework.boot" % "spring-boot" % "2.0.5.RELEASE"
//
libraryDependencies += "org.springframework.boot" % "spring-boot-autoconfigure" % "2.0.5.RELEASE"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-logging" % "2.0.5.RELEASE"
libraryDependencies += "org.yaml" % "snakeyaml" % "1.14"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-webflux" % "2.0.5.RELEASE"



//libraryDependencies += "org.springframework.cloud" % "spring-cloud-dependencies" % "Finchley.RELEASE" pomOnly()

//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-stream-kafka" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-netflix-hystrix-dashboard" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-netflix-eureka-server" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-spring-service-connector" % "2.0.2.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-context" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-commons" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-stream" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-config" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-cloudfoundry-connector" % "2.0.2.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-config-monitor" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-config-server" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-deployer-resource-docker" % "1.3.4.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-openfeign" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-netflix-ribbon" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-consul-discovery" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-consul-core" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-zuul" % "1.4.6.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-zipkin" % "2.0.0.RELEASE"
//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-sleuth" % "2.0.0.RELEASE"


//libraryDependencies += "org.springframework.cloud" % "spring-cloud-starter-netflix-eureka-server" % "2.0.1.RELEASE"

//// https://mvnrepository.com/artifact/org.springframework/spring-webflux
//libraryDependencies += "org.springframework" % "spring-webflux" % "5.1.1.RELEASE"
////libraryDependencies += "org.springframework.boot" % "spring-boot-starter-actuator" % "2.0.5.RELEASE"
//libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "2.0.5.RELEASE"
// if you remove commentout the following line, this script set the environment properties to the Spring Boot's LaunchScript regardless of the value of the configuration file
//assemblyOption in assembly := (assemblyOption in assembly).value.copy(prependShellScript = Some({
//  val props = Map[String, String](
//    "initInfoProvides"         -> "yakumobooks.com"
//    ,"initInfoShortDescription" -> "task scheduler application"
//    ,"initInfoDescription"      -> ""
//    // ,"confFolder"               -> ""
//    // ,"pidFolder"                -> ""
//    // ,"logFolder"                -> ""
//    ,"mode"                     -> "service"
//    // ,"useStartStopDaemon"       -> ""
//  )
//  val scu="https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-tools/spring-boot-loader-tools/src/main/resources/org/springframework/boot/loader/tools/launch.script"
//  val placeholder_regex = "\\{\\{(\\w+)(:.*?)?\\}\\}(?!\\})".r
//  val launchScriptsUrl = s"https://raw.githubusercontent.com/spring-projects/spring-boot/v${springBootVersion}/spring-boot-tools/spring-boot-loader-tools/src/main/resources/org/springframework/boot/loader/tools/launch.script"
//  scala.io.Source.fromURL(scu, "UTF-8")
//          .getLines
//          .toSeq
//          .map(placeholder_regex.replaceAllIn(_, m =>
//            props.getOrElse(m.group(1), s"${m.group(2).replace("$","\\$").substring(1)}").stripLineEnd))
//
//}))
//
////assemblyJarName in assembly := s"${name.value}-${version.value}.jar"
//assemblyJarName in assembly := s"${name.value}.jar"
