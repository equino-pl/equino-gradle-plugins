package ovh.equino.gradle.plugins.version

import org.gradle.api.Plugin
import org.gradle.api.Project
import ovh.equino.gradle.plugins.version.tasks.InitialVersion
import ovh.equino.gradle.plugins.version.tasks.VersionMajor
import ovh.equino.gradle.plugins.version.tasks.VersionMinor
import ovh.equino.gradle.plugins.version.tasks.VersionPatch
import ovh.equino.gradle.plugins.version.tasks.internal.CreateVersionMarker
import pl.allegro.tech.build.axion.release.ReleasePlugin

import static ovh.equino.gradle.plugins.version.internal.VersionIncrementerCleaner.cleanUpVersionIncrementer

class EquinoVersionPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.plugins.apply('base')
        project.plugins.apply(ReleasePlugin)

        project.tasks.register(VersionPatch.NAME, VersionPatch)
        project.tasks.register(VersionMinor.NAME, VersionMinor)
        project.tasks.register(VersionMajor.NAME, VersionMajor)
        project.tasks.register(InitialVersion.NAME, InitialVersion)

        project.tasks.register(CreateVersionMarker.NAME, CreateVersionMarker)
        project.build.finalizedBy(CreateVersionMarker.NAME)

        VersionExtension versionExtension = project.extensions.create(VersionExtension.NAME, VersionExtension)
        setupReleasePlugin(project, versionExtension)


        cleanUpVersionIncrementer(project)

        project.allprojects {
            it.version = project.scmVersion.version
        }
    }

    void setupReleasePlugin(Project project, VersionExtension versionExtension) {
        project.scmVersion {
            tag {
                initialVersion({ config, position -> versionExtension.initialVersionTag
                })
            }
            checks {
                aheadOfRemote.set(false)
                snapshotDependencies.set(false)
                uncommittedChanges.set(true)
            }
            versionCreator('versionWithCommitHash')
            snapshotCreator({ version, position -> '' })
            ignoreUncommittedChanges.set(false)
            repository {
                customUsername.set(versionExtension.gitUsername)
                customPassword.set(versionExtension.gitPassword)
            }
            versionIncrementer(versionExtension.incrementer)
        }
    }
}
