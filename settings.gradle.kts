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
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://storage.googleapis.com/download.flutter.io")
        maven(url = "/Users/fauzanakmalmahdi/Documents/Main/Flutter Project/flutter_module1/build/host/outputs/repo")
        maven {
            url = uri("/Users/fauzanakmalmahdi/Documents/Main/Android Project/AppSample1/app/build")
        }
    }
}

rootProject.name = "AppSample2"
include(":app")
 