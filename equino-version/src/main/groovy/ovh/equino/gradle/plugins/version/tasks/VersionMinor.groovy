package ovh.equino.gradle.plugins.version.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ovh.equino.gradle.plugins.commons.GitBranch

import static ovh.equino.gradle.plugins.version.configuration.VersionIncrementer.MINOR
import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerBranchFile.versionIncrementerBranchFile
import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerBranchFile.versionIncrementerMasterBranchFile

abstract class VersionMinor extends DefaultTask implements EquinoVersionTask {

    static final String NAME = 'versionMinor'

    private final GitBranch gitBranch

    VersionMinor() {
        setGroup(GROUP)
        this.gitBranch = new GitBranch()
    }

    @TaskAction
    void execute() {
        versionIncrementerBranchFile(project, gitBranch.name)
                .recreate()
                .append(MINOR)
        versionIncrementerMasterBranchFile(project)
                .recreate()
                .append(MINOR)
    }
}
