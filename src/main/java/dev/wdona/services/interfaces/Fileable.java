package dev.wdona.services.interfaces;

import java.io.File;

public interface Fileable {
    default boolean isArchivoExisting(File file) {
        return file.exists() && file.isFile();
    }
}
