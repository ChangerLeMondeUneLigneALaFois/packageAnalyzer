package org.free.software.libraries;

import org.free.software.collections.Collection;
import org.free.software.collections.Collections;
import org.free.software.libraries.java.classes.Class;
import org.free.software.libraries.java.packages.Package;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freak on 03/03/2018.
 */
public class Library {

    private final Collection<Class> classes;
    private final Collection<Package> packages;

    public Library() {
        classes = Collections.create();
        packages = Collections.create();
    }

    public Library(Collection<Class> classes, Collection<Package> packages) {
        this.classes = classes;
        this.packages = packages;
    }

    public Library(Collection<Package> packages) {
        this.packages = packages;
        this.classes = Collections.create();
    }

    public Library addClass(Class classObject) {
        Collection<Class> newClasses = Collections.create(classes.asJavaCollection()).add(classObject);
        return new Library(newClasses, packages);
    }

    public boolean hasAtLeastOneClass() {
        return classes.size() > 0;
    }

    public boolean hasAtLeastOnePackage() {
        return packages.size() > 0;
    }

    public Library addPackage(Package aPackage) {
        Collection<Package> newPackages = Collections.create(packages.asJavaCollection()).add(aPackage);
        return new Library(classes, newPackages);
    }
}
