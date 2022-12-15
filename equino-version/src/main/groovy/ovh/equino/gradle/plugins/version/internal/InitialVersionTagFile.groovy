package ovh.equino.gradle.plugins.version.internal

import org.gradle.api.Project
import ovh.equino.gradle.plugins.commons.EquinoPluginFile

class InitialVersionTagFile extends EquinoPluginFile {

    private static final String INITIAL_VERSION_TAG_DIRECTORY = 'ovh.equino.version'
    private static final String INITIAL_VERSION_TAG_FILE = 'initialVersion'

    private InitialVersionTagFile(Project project) {
        super(project, INITIAL_VERSION_TAG_DIRECTORY, INITIAL_VERSION_TAG_FILE)
    }

    static InitialVersionTagFile initialVersionTagFile(Project project) {
        return new InitialVersionTagFile(project)
    }
}
