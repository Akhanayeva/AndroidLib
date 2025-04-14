pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()

        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Akhanayeva/chatlibrary")
            credentials {
                username = "Akhanayeva"
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}



rootProject.name = "ChatDemoApp"
include(":app")
include(":chatlibrary")
