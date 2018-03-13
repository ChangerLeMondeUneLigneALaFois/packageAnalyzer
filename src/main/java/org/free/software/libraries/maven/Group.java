package org.free.software.libraries.maven;

/**
 * Created by Freak on 13/03/2018.
 */
public class Group {
    private final String group;

    public Group(String group) {
        this.group = group;
    }

    public String toSlashSeparatedString() {
        return group.replace(".", "/");
    }
}
