package org.free.software.libraries.asserts;

import org.assertj.core.api.AbstractAssert;
import org.free.software.libraries.Library;

public class LibraryAssert extends AbstractAssert<LibraryAssert, Library> {

    public LibraryAssert(Library actual) {
        super(actual, LibraryAssert.class);
    }

    public static LibraryAssert assertThat(Library actual) {
        return new LibraryAssert(actual);
    }

    public LibraryAssert hasClasses() {
        isNotNull();

        if (!actual.hasAtLeastOneClass()) {
            failWithMessage("Library didn't have any classes");
        }

        return this;
    }

    public LibraryAssert hasPackages() {
        isNotNull();

        if (!actual.hasAtLeastOnePackage()) {
            failWithMessage("Library didn't have any packages");
        }

        return this;
    }
}