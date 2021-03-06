plugins {
    kotlin("js")
    `publishing-conventions`
}

dependencies {
    implementation(project(":kotlin-extensions"))

    implementation(kotlinxCoroutines("core"))
    implementation(kotlinxCoroutines("core-common"))
    implementation(kotlinxCoroutines("core-js"))
}
