package ovh.equino.gradle.plugins.version.internal

import org.gradle.api.Project
import ovh.equino.gradle.plugins.commons.EquinoPluginFile
import ovh.equino.gradle.plugins.version.configuration.VersionIncrementer

class VersionIncrementerBranchFile extends EquinoPluginFile {

    private static final String VERSION_INCREMENTER_DIRECTORY = 'ovh.equino.version/incrementer'

    private VersionIncrementerBranchFile(Project project, String branchName) {
        super(project, VERSION_INCREMENTER_DIRECTORY, branchName)
    }

    VersionIncrementerBranchFile append(VersionIncrementer incrementer) {
        super.append(incrementer.toString())
    }

    static VersionIncrementerBranchFile versionIncrementerBranchFile(Project project, String branchName) {
        return new VersionIncrementerBranchFile(project, branchName)
    }

    static VersionIncrementerBranchFile versionIncrementerMasterBranchFile(Project project) {
        return new VersionIncrementerBranchFile(project, 'master')
    }
}
