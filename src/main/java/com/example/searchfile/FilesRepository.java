package com.example.searchfile;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;

@Repository
public interface FilesRepository extends CrudRepository<FilesFolder,Integer> {

//    @Query(value = " select  ff.id,fn.file_name,fn.files_folder_id from FILESFOLDER ff LEFT OUTER JOIN FILES_FOLDER_FILE_NAME fn  on ff.id=fn.files_folder_id  LEFT OUTER JOIN FILES_FOLDER_FILE_EXTENSION  fe ON fe.files_folder_id=ff.id WHERE  file_name='A.class' group by file_name ",nativeQuery = true)
//    FilesFolder searchByFileName(String filename);
//    @Query(value = "SELECT ff.id,fn.file_name FROM  FILESFOLDER ff, FILES_FOLDER_FILE_NAME fn where fn.file_name= '?1' ",nativeQuery = true)
//    FilesFolder searchByFileName(String filename);


    @Query(value = "SELECT ff.id,fn.file_name FROM filesfolder ff, FILES_FOLDER_FILE_NAME fn WHERE fn.file_name ='?1' ", nativeQuery = true)
    FileName findByName(String name);



}
