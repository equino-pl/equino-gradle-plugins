See readme of plugins of interest:

[equino-properties](equino-properties/README.md)    
[equino-version](equino-version/README.md)  

Each plugin may be used as a dependency from Equino Maven repository. 
Credentials to Maven repositories should be kept in local $GRADLE_HOME/gradle.properties  

settings.gradle:
```
pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
            name 'mavenEquino'
            url 'https://maven.cloud.equino.ovh/equino'
            credentials {
                username settings.'mavenEquinoUsername'
                password settings.'mavenEquinoPassword'
            }
        }
        maven {
            name 'mavenEquinoSnapshot'
            url 'https://maven.cloud.equino.ovh/equinoSnapshot'
            credentials {
                username settings.'mavenEquinoSnapshotUsername'
                password settings.'mavenEquinoSnapshotPassword'
            }
        }
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
