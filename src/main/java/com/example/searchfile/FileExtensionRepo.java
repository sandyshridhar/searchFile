package com.example.searchfile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileExtensionRepo extends CrudRepository<FileExtension,Integer> {

    @Query(value = "SELECT ff.id,fe.files_folder_id,fe.file_extension  FROM filesfolder ff, FILES_FOLDER_FILE_EXTENSION fe WHERE fe.file_extension = ?1 ", nativeQuery = true)
    List<FileExtension> findByType(String filetype);
}
