package org.free.software.libraries;

/**
 * Created by Freak on 04/03/2018.
 */
public class LibraryIdentifier {
    private final LibraryVersion version;
    private final String name;

    public LibraryIdentifier(String name, String version) {
        this.name = name;
        this.version = new LibraryVersion(version);
    }

    public String compiledVersionName() {
        return name + "-" + version.toString() + ".jar";
    }

    public String sourcedVersionName() {
        return name + "-" + version.toString() + "-sources.jar";
    }
}
