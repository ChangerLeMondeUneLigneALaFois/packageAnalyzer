package org.free.software.libraries.querying.infrastructure;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.free.software.libraries.Library;
import org.free.software.libraries.maven.LibraryIdentifier;
import org.free.software.libraries.java.classes.Class;
import org.free.software.libraries.java.packages.Package;
import org.free.software.libraries.querying.Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Freak on 05/03/2018.
 */
public class LibrariesCompiledInSameProject implements Libraries {
    public Library getByIdentifier(LibraryIdentifier libraryIdentifier) {
        Path sourcesPath = FileSystems.getDefault().getPath("target", libraryIdentifier.sourcesFilename());
        Path testsPath = FileSystems.getDefault().getPath("target", libraryIdentifier.testsFilename());
        File sourcesFile = sourcesPath.toFile();
        if (!(sourcesFile.exists())) {
            throw new IllegalArgumentException("Non existing library");
        }
        Library library = new Library();
        try {
            JarFile jarFile = new JarFile(sourcesFile);
            ZipInputStream zip = new ZipInputStream(new FileInputStream(sourcesFile));
            for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                if (entry.isDirectory()) {
                    if (libraryIdentifier.contains(entry.getName())) {
                        System.out.println(entry.getName() + " *******");
                    } else {
                        System.out.println(entry.getName());
                    }
                    library = library.addPackage(new Package(entry.getName()));
                } else  if (!entry.isDirectory() && entry.getName().endsWith(".java")) {
                    // This ZipEntry represents a class. Now, what class does it represent?
                    InputStream classFile = jarFile.getInputStream(entry);
                    CompilationUnit cu = JavaParser.parse(classFile);
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
