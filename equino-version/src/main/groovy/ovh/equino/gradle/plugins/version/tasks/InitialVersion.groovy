package ovh.equino.gradle.plugins.version.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ovh.equino.gradle.plugins.version.VersionExtension
import ovh.equino.gradle.plugins.version.internal.InitialVersionTagFile

import static ovh.equino.gradle.plugins.version.internal.InitialVersionTagFile.initialVersionTagFile

abstract class InitialVersion extends DefaultTask implements EquinoVersionTask {

    static final String NAME = 'initialVersion'

    InitialVersion() {
        setGroup(GROUP)
    }

    @TaskAction
    void execute() {
        VersionExtension equinoVersion = project.extensions.getByType(VersionExtension)
        InitialVersionTagFile initialVersionTagFile = initialVersionTagFile(project)
        initialVersionTagFile.delete()
        String initialVersionTag = equinoVersion.initialVersionTag
        initialVersionTagFile.recreate().append(initialVersionTag)
    }
}
