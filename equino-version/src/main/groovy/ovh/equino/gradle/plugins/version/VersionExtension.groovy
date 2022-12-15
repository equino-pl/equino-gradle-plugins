package ovh.equino.gradle.plugins.version

import org.gradle.api.Project
import ovh.equino.gradle.plugins.commons.GitBranch
import ovh.equino.gradle.plugins.commons.ProjectPropertiesExtractor

import static ovh.equino.gradle.plugins.version.configuration.VersionIncrementer.MINOR
import static ovh.equino.gradle.plugins.version.internal.InitialVersionTagFile.initialVersionTagFile
import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerBranchFile.versionIncrementerBranchFile

class VersionExtension {

    public static final String NAME = 'equinoVersion'

    private final Project project
    private final ProjectPropertiesExtractor projectPropertiesExtractor
    private final GitBranch gitBranch

    VersionExtension(Project project) {
        this.project = project
        this.projectPropertiesExtractor = new ProjectPropertiesExtractor(project)
        this.gitBranch = new GitBranch()
    }

    String getInitialVersionTag() {
        return projectPropertiesExtractor.stringProperty("${NAME}.initialVersionTag")
                .orElse(initialVersionTagFromFile())
    }

    String getGitUsername() {
        return projectPropertiesExtractor.stringProperty("${NAME}.gitUsername")
                .orElse('')

    }

    String getGitPassword() {
        return projectPropertiesExtractor.stringProperty("${NAME}.gitPassword")
                .orElse('')
    }

    String getIncrementer() {
        versionIncrementerBranchFile(project, gitBranch.name)
                .read()
                .orElse(MINOR.toString())
    }

    private String initialVersionTagFromFile() {
        return initialVersionTagFile(project)
                .read()
                .orElse('0.1.0')
    }

}
