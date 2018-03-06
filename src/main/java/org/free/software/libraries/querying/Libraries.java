package org.free.software.libraries.querying;

import org.free.software.libraries.Library;
import org.free.software.libraries.LibraryIdentifier;

/**
 * Created by Freak on 04/03/2018.
 */
public interface Libraries {
    Library getByIdentifier(LibraryIdentifier libraryIdentifier);
}
