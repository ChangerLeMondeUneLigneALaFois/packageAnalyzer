package org.free.software.libraries.maven;

import org.apache.commons.lang3.StringUtils;
import org.free.software.libraries.LibraryVersion;

/**
 * Created by Freak on 04/03/2018.
 */
public class LibraryIdentifier {
    private final LibraryVersion version;
    private final LibraryName name;
    private final Group group;

    public LibraryIdentifier(LibraryName name, LibraryVersion version, Group group) {
        this.name = name;
        this.version = version;
        this.group = group;
    }

    public String compiledFilename() {
        return name.toString() + "-" + version.toString() + ".jar";
    }

    public String sourcesFilename() {
        return name.toString() + "-" + version.toString() + "-sources.jar";
    }

    public String testsFilename() {
        return getFullName() + "-tests.jar";
    }

    private String getFullName() {
        return name.toString() + "-" + version.toString();
    }

    public String toSlashSeparatedGroupName() {
        return group.toSlashSeparatedString();
    }

    public boolean contains(String packageName) {
        return toSlashSeparatedGroupName().contains(StringUtils.removeEnd(packageName, "/"));
    }
}
