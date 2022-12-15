package ovh.equino.gradle.plugins.version.configuration

enum VersionIncrementer {

    PATCH('incrementPatch'),
    MINOR('incrementMinor'),
    MAJOR('incrementMajor'),

    final String incrementer

    private VersionIncrementer(String incrementer) {
        this.incrementer = incrementer
    }

    @Override
    String toString() {
        return incrementer;
    }
}