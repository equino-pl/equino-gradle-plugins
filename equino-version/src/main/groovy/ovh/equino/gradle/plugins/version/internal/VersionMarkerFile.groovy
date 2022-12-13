package ovh.equino.gradle.plugins.version.internal

import org.gradle.api.Project
import ovh.equino.gradle.plugins.commons.EquinoPluginFile

class VersionMarkerFile extends EquinoPluginFile {

    private static final String VERSION_MARKER_DIRECTORY = 'build/ovh.equino.version'
    private static final String VERSION_MARKER_FILE = 'currentVersion'

    private VersionMarkerFile(Project project) {
        super(project, VERSION_MARKER_DIRECTORY, VERSION_MARKER_FILE)
    }

    static VersionMarkerFile versionMarkerFile(Project project) {
        return new VersionMarkerFile(project)
    }
}
