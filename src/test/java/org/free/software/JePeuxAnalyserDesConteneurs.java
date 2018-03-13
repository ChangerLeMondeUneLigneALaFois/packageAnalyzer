package org.free.software;

import org.free.software.libraries.Library;
import org.free.software.libraries.maven.Group;
import org.free.software.libraries.maven.LibraryIdentifier;
import org.free.software.libraries.maven.LibraryName;
import org.free.software.libraries.LibraryVersion;
import org.free.software.libraries.querying.Libraries;
import org.free.software.libraries.querying.infrastructure.LibrariesCompiledInSameProject;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.free.software.libraries.asserts.LibraryAssert.assertThat;

public class JePeuxAnalyserDesConteneurs {

    private Libraries libraries;

    @Before
    public void setUp() {
        libraries = new LibrariesCompiledInSameProject();
    }

    @Test
    public void a_library_has_folders_classes_and_packages() {
        LibraryIdentifier identifier = new LibraryIdentifier(new LibraryName("packageAnalyzer"), new LibraryVersion("1.0-SNAPSHOT"), new Group("org.free.software"));

        Library library = libraries.getByIdentifier(identifier);

        assertThat(library).hasClasses();
        assertThat(library).hasPackages();
    }
}
