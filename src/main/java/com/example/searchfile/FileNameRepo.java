package com.example.searchfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileNameRepo extends JpaRepository<FileName,Integer> {

    @Query(value = "SELECT ff.id,fn.files_folder_id,fn.file_name FROM filesfolder ff, FILES_FOLDER_FILE_NAME fn WHERE fn.file_name = ?1 ", nativeQuery = true)
    List<FileName> findByName(String filename);
}
