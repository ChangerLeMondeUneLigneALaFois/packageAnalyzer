package org.free.software.libraries;

import org.free.software.libraries.java.classes.Class;
import org.free.software.libraries.java.packages.Package;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freak on 03/03/2018.
 */
public class Library {

    private final List<Class> classes;
    private final List<Package> packages;

    public Library() {
        classes = new ArrayList<Class>();
        packages = new ArrayList<Package>();
    }

    public Library(List<Class> classes, List<Package> packages) {
        this.classes = classes;
        this.packages = packages;
    }

    public Library(List<Package> packages) {
        this.packages = packages;
        this.classes = new ArrayList<Class>();
    }

    public Library addClass(Class classObject) {
        List<Class> newClasses = new ArrayList<Class>();
        newClasses.addAll(classes);
        newClasses.add(classObject);
        return new Library(newClasses, packages);
    }

    public boolean hasAtLeastOneClass() {
        return classes.size() > 0;
    }

    public boolean hasAtLeastOnePackage() {
        return packages.size() > 0;
    }

    public Library addPackage(Package aPackage) {
        return null;
    }
}
