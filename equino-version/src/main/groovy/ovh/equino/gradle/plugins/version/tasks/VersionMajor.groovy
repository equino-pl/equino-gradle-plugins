package ovh.equino.gradle.plugins.version.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import ovh.equino.gradle.plugins.commons.GitBranch

import static ovh.equino.gradle.plugins.version.configuration.VersionIncrementer.MAJOR
import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerBranchFile.versionIncrementerBranchFile
import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerBranchFile.versionIncrementerMasterBranchFile

abstract class VersionMajor extends DefaultTask implements EquinoVersionTask {

    static final String NAME = 'versionMajor'

    private final GitBranch gitBranch

    VersionMajor() {
        setGroup(GROUP)
        gitBranch = new GitBranch()
    }

    @TaskAction
    void execute() {
        versionIncrementerBranchFile(project, gitBranch.name)
                .recreate()
                .append(MAJOR)
        versionIncrementerMasterBranchFile(project)
                .recreate()
                .append(MAJOR)
    }
}
