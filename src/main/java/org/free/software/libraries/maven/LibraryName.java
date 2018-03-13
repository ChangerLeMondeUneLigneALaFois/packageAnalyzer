package org.free.software.libraries.maven;

/**
 * Created by Freak on 12/03/2018.
 */
public class LibraryName {
    private String libraryName;
    private String groupName;

    public LibraryName(String libraryName) {

        this.libraryName = libraryName;
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return libraryName;
    }
}
