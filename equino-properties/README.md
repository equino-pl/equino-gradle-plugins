When applied to a project, this plugin allows loading project properties according to plugin's DSL configuration.  
Properties are loaded from `${propertiesDirectory}/${prefixProperty.value}${propertiesSuffix}` file.   
propertiesDirectory and propertiesSuffix may be provided with DSL configuration.
prefixProperty is a name of a project property, which value will be used as file prefix.

Apply plugin using:
```
plugins {
    id: 'ovh.equino.properties' version: '0.0.1'
}
```

or (legacy way):
```
apply plugin: 'ovh.equino.properties'
```

Example DSL configuration:
```
// Project properties configuration block (optional)
// If the properties configuration block is specified but the file is not found, properties will not be loaded 
// and the error message will be printed.
equinoProperties {

    // Directory where project property files resides (optional)
    // Defaults to project.rootDir
    propertiesDirectory = 'src/main/resources'
    
    // Sufix of the property files (optional)
    // If not specified, suffix will not be included in path
    propertiesSuffix = '_deploy.properties'
    
    // Project property, that defines property file prefix (optional)
    // If specified, prefix may be delivered using this property (e.i. gradle -Pdeploy.env=DEV)
    prefixProperty = 'deploy.env'
    
    // Default prefix, which will be used when prefixProperty will not be specified (optional)
    // Defaults to 'build_config'
    defaultPrefix = 'LOCAL'
}
```

Example usage (with DSL configuration above):

Load project properties from `src/main/resources/PROD_deploy.properties` file:
```gradle build -Pdeploy.env=PROD```

Load project properties from `src/main/resources/LOCAL_deploy.properties` file (default prefix specified in prefixProperty):
```gradle build```

Load project properties from `${project.rootDir}/build_config` file (default path, if DSL configuration is not provided):
```gradle build```


Helper methods (build.gradle):
```
// Returns project's loaded String property or null if property not defined
String stringProperty(String propertyName)

// Returns project's loaded Integer property or null if property not defined
Integer intProperty(String propertyName)

// Returns project's loaded Long property or null if property not defined
Long longProperty(String propertyName)

// Returns project's loaded Boolean property or null if property not defined
Boolean boolProperty(String propertyName)
```
