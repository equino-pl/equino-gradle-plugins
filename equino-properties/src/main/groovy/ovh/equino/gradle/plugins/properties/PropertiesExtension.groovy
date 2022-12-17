package ovh.equino.gradle.plugins.properties

import org.gradle.api.Project

import static java.util.Objects.nonNull

class PropertiesExtension {

    String propertiesDirectory
    String propertiesSuffix
    String defaultPrefix
    String prefixProperty

    public static final String NAME = 'equinoProperties'

    private final Project project

    PropertiesExtension(Project project) {
        this.project = project
    }

    String getPropertiesDirectory() {
        return isNotEmpty(propertiesDirectory)
                ? propertiesDirectory
                : project.rootDir.path
    }

    String getPropertiesSuffix() {
        return isNotEmpty(propertiesSuffix)
                ? propertiesSuffix
                : '';
    }

    String getDefaultPrefix() {
        return isNotEmpty(defaultPrefix)
                ? defaultPrefix
                : 'build_config'
    }

    String getPrefix() {
        return isNotEmpty(prefixProperty) && project.hasProperty(prefixProperty)
                ? project.findProperty(prefixProperty)
                : getDefaultPrefix()
    }

    private static boolean isNotEmpty(String string) {
        return nonNull(string) && !string.isEmpty()
    }
}
