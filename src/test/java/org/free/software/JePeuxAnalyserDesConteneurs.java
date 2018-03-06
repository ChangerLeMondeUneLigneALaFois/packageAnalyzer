package org.free.software;

import org.free.software.libraries.Library;
import org.free.software.libraries.LibraryIdentifier;
import org.free.software.libraries.querying.Libraries;
import org.free.software.libraries.querying.infrastructure.LibrariesCompiledInSameProject;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.free.software.libraries.asserts.LibraryAssert.assertThat;

public class JePeuxAnalyserDesConteneurs
{
    @Before
    public void setUp() {
        Libraries libraries = new LibrariesCompiledInSameProject();
    }

    @Test
    public void je_peux_recuperer_une_librairie_depuis_un_jar() {
        LibraryIdentifier identifier = new LibraryIdentifier("packageAnalyzer", "1.0-SNAPSHOT");
        Libraries libraries = new LibrariesCompiledInSameProject();

        Library library = libraries.getByIdentifier(identifier);

        assertThat(library).hasClasses();
        assertThat(library).hasPackages();
    }

    private void it_has_folders_classes_and_packages() {

    }

    private void i_analyze(Library library) {

    }
}
