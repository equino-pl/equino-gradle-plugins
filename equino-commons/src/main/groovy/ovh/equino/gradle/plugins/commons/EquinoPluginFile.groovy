package ovh.equino.gradle.plugins.commons

import org.gradle.api.Project

abstract class EquinoPluginFile {

    protected Project project

    final String dirPath
    final String fileName
    final String filePath

    final File directory
    final File file

    protected EquinoPluginFile(Project project, String dirPath, String fileName) {
        this.project = project
        this.dirPath = dirPath
        this.fileName = fileName
        this.filePath = "${dirPath}/${fileName}"
        this.directory = project.file(dirPath)
        this.file = project.file(filePath)
    }

    <T extends EquinoPluginFile> T create() {
        project.mkdir(dirPath)
        file.createNewFile()
        (T) this
    }

    <T extends EquinoPluginFile> T delete() {
        if (exists()) {
            file.delete()
        }
        (T) this
    }

    <T extends EquinoPluginFile> T recreate() {
        delete()
        create()
        (T) this
    }

    boolean exists() {
        return file.exists()
    }

    Optional<String> read() {
        if (!exists()) {
            return Optional.empty()
        }
        Optional.of(file.getText())
    }

    void append(String content) {
        file.append(content)
    }

    void append(InputStream content) {
        file.append(content)
    }

}
