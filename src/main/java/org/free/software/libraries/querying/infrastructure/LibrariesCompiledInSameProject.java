package org.free.software.libraries.querying.infrastructure;

import org.free.software.libraries.Library;
import org.free.software.libraries.LibraryIdentifier;
import org.free.software.libraries.java.classes.Class;
import org.free.software.libraries.querying.Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Freak on 05/03/2018.
 */
public class LibrariesCompiledInSameProject implements Libraries {
    public Library getByIdentifier(LibraryIdentifier libraryIdentifier) {
        Path withSourcesTarget = FileSystems.getDefault().getPath("target", libraryIdentifier.sourcedVersionName());
        File sourcesFile = withSourcesTarget.toFile();
        if (!(sourcesFile.exists())) {
            throw new IllegalArgumentException("Non existing library");
        }
        Library library = new Library();
        try {
            ZipInputStream zip = new ZipInputStream(new FileInputStream(sourcesFile));
            for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                if (entry.isDirectory()) {
                    //library = library.addPackage(entry.getName());
                } else  if (!entry.isDirectory() && entry.getName().endsWith(".java")) {
                    // This ZipEntry represents a class. Now, what class does it represent?
                    String className = entry.getName().replace('/', '.');
                    Class classObject = new Class(className);// including ".class"
                    library = library.addClass(classObject);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Error while browsing jar file");
        }
        return library;
    }
}
