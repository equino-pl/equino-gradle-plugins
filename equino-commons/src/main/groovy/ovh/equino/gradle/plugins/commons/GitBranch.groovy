package ovh.equino.gradle.plugins.commons

class GitBranch {

    String getName() {
        String branch = ""
        Process proc = "git rev-parse --abbrev-ref HEAD".execute()
        proc.in.eachLine { line -> branch = line }
        proc.waitFor()
        branch
    }

    boolean isMaster() {
        return 'master' == name
    }
}
