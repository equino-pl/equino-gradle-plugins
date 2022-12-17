See readme of plugins of interest:

[equino-properties](equino-properties/README.md)    
[equino-version](equino-version/README.md)  

Each plugin may be used as a dependency from Equino Nexus. 
Credentials to Nexus repository should be kept in local $GRADLE_HOME/gradle.properties  

settings.gradle:
```
pluginManagement {
    repositories {
        maven {
            url 'https://nexus.cloud.equino.ovh/repository/m2'
            credentials {
                username settings.'equinoNexus.username'
                password settings.'equinoNexus.password'
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
