package com.example.searchfile;

import javax.persistence.*;

@Entity
public class FileName {

    @Id
    int id;
    int files_folder_id;

    String file_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFiles_folder_id() {
        return files_folder_id;
    }

    public void setFiles_folder_id(int files_folder_id) {
        this.files_folder_id = files_folder_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public String toString() {
        return "FileName{" +
                "id=" + id +
                ", files_folder_id=" + files_folder_id +
                ", file_name='" + file_name + '\'' +
                '}';
    }
}
