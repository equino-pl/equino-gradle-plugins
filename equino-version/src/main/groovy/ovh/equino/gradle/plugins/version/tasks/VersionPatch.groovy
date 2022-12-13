package ovh.equino.gradle.plugins.version.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ovh.equino.gradle.plugins.commons.GitBranch

import static ovh.equino.gradle.plugins.version.configuration.VersionIncrementer.PATCH
import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerBranchFile.versionIncrementerBranchFile
import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerBranchFile.versionIncrementerMasterBranchFile

abstract class VersionPatch extends DefaultTask implements EquinoVersionTask {

    static final String NAME = 'versionPatch'

    private final GitBranch gitBranch

    VersionPatch() {
        setGroup(GROUP)
        this.gitBranch = new GitBranch()
    }

    @TaskAction
    void execute() {
        versionIncrementerBranchFile(project, gitBranch.name)
                .recreate()
                .append(PATCH)
        versionIncrementerMasterBranchFile(project)
                .recreate()
                .append(PATCH)
    }
}
