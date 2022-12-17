package ovh.equino.gradle.plugins.properties

import org.gradle.api.Plugin
import org.gradle.api.Project
import ovh.equino.gradle.plugins.commons.ProjectPropertiesExtractor
import ovh.equino.gradle.plugins.properties.internal.PropertiesFile

import static ovh.equino.gradle.plugins.properties.internal.PropertiesFile.propertiesFile

class EquinoPropertiesPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.plugins.apply('base')
        project.extensions.create(PropertiesExtension.NAME, PropertiesExtension)

        addPropertiesMethods(project)

        project.afterEvaluate {
            loadProjectProperties(project)
        }
    }

    private static void addPropertiesMethods(Project project) {

        project.ext.intProperty = { String propertyName ->
            loadProjectProperties(project)
            return new ProjectPropertiesExtractor(project).intProperty(propertyName)
                    .orElse(null)
        }

        project.ext.longProperty = { String propertyName ->
            loadProjectProperties(project)
            return new ProjectPropertiesExtractor(project).longProperty(propertyName)
                    .orElse(null)
        }

        project.ext.stringProperty = { String propertyName ->
            loadProjectProperties(project)
            return new ProjectPropertiesExtractor(project).stringProperty(propertyName)
                    .orElse(null)
        }

        project.ext.booleanProperty = { String propertyName ->
            loadProjectProperties(project)
            return new ProjectPropertiesExtractor(project).boolProperty(propertyName)
                    .orElse(null)
        }
    }

    private static void loadProjectProperties(Project project) {
        PropertiesExtension equinoProperties = project.extensions.getByType(PropertiesExtension)
        PropertiesFile propertiesFile = propertiesFile(
                equinoProperties.propertiesDirectory,
                equinoProperties.prefix,
                equinoProperties.propertiesSuffix,
                project
        )
        Properties buildscriptProperties = new Properties()
        buildscriptProperties.load(new FileInputStream(project.file(propertiesFile.filePath)))
        buildscriptProperties.each { prop -> project.ext.set(prop.key, prop.value) }
    }
}
