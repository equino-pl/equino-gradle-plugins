package ovh.equino.gradle.plugins.version.internal

import org.gradle.api.Project
import ovh.equino.gradle.plugins.commons.GitBranch

import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerBranchFile.versionIncrementerBranchFile
import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerBranchFile.versionIncrementerMasterBranchFile

class VersionIncrementerCleaner {

    static void cleanUpVersionIncrementer(Project project) {
        GitBranch gitBranch = new GitBranch()
        if (gitBranch.isMaster()) {
            return
        }

        deleteNotUserVersionIncrementerFiles(project, gitBranch.name)
    }

    private static void deleteNotUserVersionIncrementerFiles(Project project, String branchName) {
        VersionIncrementerBranchFile versionIncrementBranchFile = versionIncrementerBranchFile(project, branchName)
        Optional<String> versionIncrementer = versionIncrementBranchFile.read()
        versionIncrementBranchFile.directory.deleteDir()

        versionIncrementer.ifPresent(incrementer -> {
            versionIncrementBranchFile
                    .recreate()
                    .append(incrementer)
            versionIncrementerMasterBranchFile(project)
                    .recreate()
                    .append(incrementer)
        })
    }
}
