package ovh.equino.gradle.plugins.properties.internal

import org.gradle.api.Project
import ovh.equino.gradle.plugins.commons.EquinoPluginFile

class PropertiesFile extends EquinoPluginFile {

    private PropertiesFile(String directory, String prefix, String suffix, Project project) {
        super(project, directory, "${prefix}${suffix}")
    }

    static PropertiesFile propertiesFile(String directory, String prefix, String suffix, Project project) {
        return new PropertiesFile(directory, prefix, suffix, project)
    }

}
