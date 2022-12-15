package ovh.equino.gradle.plugins.commons

import org.gradle.api.Project

final class ProjectPropertiesExtractor {

    private final Project project;

    ProjectPropertiesExtractor(Project project) {
        this.project = project
    }

    final Optional<String> stringProperty(String propertyName) {
        Optional.ofNullable(project.findProperty(propertyName))
                .map(Object::toString)
    }

    final Optional<Boolean> boolProperty(String propertyName) {
        stringProperty(propertyName)
                .map(Boolean::valueOf)
    }

    final Optional<Integer> intProperty(String propertyName) {
        stringProperty(propertyName)
                .map(Integer::valueOf)
    }

    final Optional<Long> longProperty(String propertyName) {
        stringProperty(propertyName)
                .map(Long::valueOf)
    }
}
