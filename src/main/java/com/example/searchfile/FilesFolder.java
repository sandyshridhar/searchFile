package com.example.searchfile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filesfolder")
public class FilesFolder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ElementCollection
    List<String> file_name=new ArrayList<>();
    @ElementCollection
    List<String> file_creation_date=new ArrayList<>();
    @ElementCollection
    List<String> file_extension=new ArrayList<>();

    public FilesFolder() {
    }
    public FilesFolder(  List<String> file_name, List<String> file_creation_date, List<String> file_extension) {
        this.file_name = file_name;
        this.file_creation_date = file_creation_date;
        this.file_extension = file_extension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getFile_name() {
        return file_name;
    }

    public void setFile_name(List<String> file_name) {
        this.file_name = file_name;
    }

    public List<String> getFile_creation_date() {
        return file_creation_date;
    }

    public void setFile_creation_date(List<String> file_creation_date) {
        this.file_creation_date = file_creation_date;
    }

    public List<String> getFile_extension() {
        return file_extension;
    }

    public void setFile_extension(List<String> file_extension) {
        this.file_extension = file_extension;
    }

    @Override
    public String toString() {
        return "FilesFolder{" +
                "id=" + id +
                ", file_name=" + file_name +
                ", file_creation_date=" + file_creation_date +
                ", file_extension=" + file_extension +
                '}';
    }
}
