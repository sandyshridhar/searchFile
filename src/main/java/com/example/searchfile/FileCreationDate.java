package com.example.searchfile;

import javax.persistence.*;

@Entity
public class FileCreationDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String file_creation_date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile_creation_date() {
        return file_creation_date;
    }

    public void setFile_creation_date(String file_creation_date) {
        this.file_creation_date = file_creation_date;
    }


}
