package com.example.searchfile;

import javax.persistence.*;

@Entity
public class FileExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    int files_folder_id;
    String file_extension;

    public int getFiles_folder_id() {
        return files_folder_id;
    }

    public void setFiles_folder_id(int files_folder_id) {
        this.files_folder_id = files_folder_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile_extension() {
        return file_extension;
    }

    public void setFile_extension(String file_extension) {
        this.file_extension = file_extension;
    }

    @Override
    public String toString() {
        return "FileExtension{" +
                "id=" + id +
                ", files_folder_id=" + files_folder_id +
                ", file_extension='" + file_extension + '\'' +
                '}';
    }
}
