repositories {
    mavenLocal()
    if (System.getProperty("user.timezone") == "Asia/Shanghai") {
//        maven(url = "https://maven.aliyun.com/repository/public")
    }
    mavenCentral()
    if (System.getProperty("user.timezone") != "Asia/Shanghai")//ScriptAgent
        maven("https://maven.wayzer.workers.dev/")
    else {
        maven {
            url = uri("https://packages.aliyun.com/maven/repository/2102713-release-0NVzQH/")
            credentials {
                username = "609f6fb4aa6381038e01fdee"
                password = "h(7NRbbUWYrN"
            }
        }
    }
    maven(url = "https://www.jitpack.io")
}

dependencies {
    val libraryVersion = "1.8.1.3"
    val mindustryVersion = "v135"
    val pluginImplementation by configurations
    pluginImplementation("cf.wayzer:ScriptAgent:$libraryVersion")
    pluginImplementation("cf.wayzer:LibraryManager:1.4.1")
    pluginImplementation("com.github.Anuken.Mindustry:core:$mindustryVersion")

    val implementation by configurations
    implementation(kotlin("script-runtime"))
    implementation("cf.wayzer:ScriptAgent:$libraryVersion")

    //coreLibrary
    implementation("cf.wayzer:PlaceHoldLib:5.2")
    implementation("io.github.config4k:config4k:0.4.1")
    //coreLib/DBApi
    val exposedVersion = "0.37.3"
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")

    //coreMindustry
    implementation("com.github.Anuken.Mindustry:core:$mindustryVersion")
    //coreMindustry/console
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.2.1")
    implementation("org.jline:jline-terminal:3.19.0")
//    compile("org.jline:jline-terminal-jansi:3.19.0")
    implementation("org.jline:jline-reader:3.19.0")
    //coreMindustry/utilContentsOverwrite
    implementation("cf.wayzer.MindustryContents:contents:1.0.8")

    //mirai
    implementation("net.mamoe:mirai-core-api-jvm:2.10.0")
    //wayzer
    implementation("com.google.guava:guava:30.1-jre")
    //gbot
    implementation("love.forte.simple-robot:component-tencent-guild:0.0.1")

    //docker
    implementation("com.amihaiemil.web:docker-java-api:0.0.13")
}