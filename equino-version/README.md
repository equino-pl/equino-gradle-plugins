When applied to a project, this plugin adds Allegro `axion-release-plugin` handling versioning using GIT tags.

Apply plugin using:
```
plugins {
    id: 'ovh.equino.version' version: '0.0.14'
}
```

or (legacy way):
```
apply plugin: 'ovh.equino.version'
```

Example usage:

Mark version of change as patch:
```
gradle versionPatch
```

Mark version of change as minor (default version change):
```
gradle versionMinor
```

Mark version of change as major:
```
gradle versionMajor
```

Print current version:
```
gradle currentVersion
```

Setup initial version for repository (0.1.0 as default):
```
gradle initialVersion -PequinoVersion.initialVersionTag=0.0.1
```
