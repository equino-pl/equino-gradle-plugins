See readme of plugins of interest:

[equino-properties](equino-properties/README.md)    
[equino-version](equino-version/README.md)  

Each plugin may be used as a dependency from Equino Maven repository. 
Credentials to Maven repository should be kept in local $GRADLE_HOME/gradle.properties  

settings.gradle:
```
pluginManagement {
    repositories {
        maven {
            name 'equinoMaven'
            url 'https://reposilite.cloud.equino.ovh/equino'
            credentials {
                username settings.'equinoMaven.username'
                password settings.'equinoMaven.password'
            }
        }
        gradlePluginPortal()
    }
}
```
build.gradle:
```
plugins {
    id 'ovh.equino.properties' version '0.0.1'
    id 'ovh.equino.version' version '0.0.1'
}
```
