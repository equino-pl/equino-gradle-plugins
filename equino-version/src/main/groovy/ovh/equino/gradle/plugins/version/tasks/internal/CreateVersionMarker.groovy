package ovh.equino.gradle.plugins.version.tasks.internal

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import static ovh.equino.gradle.plugins.version.internal.VersionMarkerFile.versionMarkerFile

abstract class CreateVersionMarker extends DefaultTask {

    public static final String NAME = 'createVersionMarker'

    @TaskAction
    def execute() {
        versionMarkerFile(project)
                .recreate()
                .append(project.version.toString())
    }
}
