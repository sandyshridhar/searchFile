package com.example.searchfile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class FilesService {

    @Autowired
    FilesRepository filesRepository;
    @Autowired
            FileNameRepo fileNameRepo;
    @Autowired
            FileExtensionRepo fileExtensionRepo;

    List file_Name=null;
    List file_Creation_Date=null;
    List file_Extension=null;

//    @PostConstruct
    public FilesFolder businessLogic() throws IOException {
        log.info("Business Logic method got called fetching filename,filecreationdate,filetype.");
          file_Name=new ArrayList();
          file_Creation_Date=new ArrayList();
          file_Extension=new ArrayList();

        //path of d  particular folder.,
        File folder = new File("C://Users//shridhar.dhuttaragi//Desktop//java");
        //here collected  all the files from tht folder.
        File[] listOfFiles = folder.listFiles();


        //by using forloop ur fetching fileName and filecreationdate, and filetype 1 by 1.
        for (int i = 0; i < listOfFiles.length; i++) {
            try {
                //here finding the file creation date time.
                Path filePath=listOfFiles[i].toPath();
                BasicFileAttributes attributes=Files.readAttributes(filePath, BasicFileAttributes.class);
                String pattern = "yyyy-MM-dd'T'HH:mm:ss";
                DateFormat df = new SimpleDateFormat(pattern);
                Date myDate=null;

                //here finding file type.
                String fileName=listOfFiles[i].toString();
                int index=fileName.lastIndexOf('.');
                String extension=null;
                if(index > 0) {
                      extension = fileName.substring(index + 1);
                }

                if (listOfFiles[i].isFile()) {
                    myDate = (Date) df.parse(String.valueOf(attributes.creationTime()));
                    file_Name.add(listOfFiles[i].getName());
                    file_Creation_Date.add(df.format(myDate));
                    file_Extension.add(extension);
                  //  System.out.println("File name" + listOfFiles[i].getName()+": File Creation date :"+myDate+":File Extension :"+extension);
                } else if (listOfFiles[i].isDirectory()) {
                    myDate = (Date) df.parse(String.valueOf(attributes.creationTime()));
                    file_Name.add(listOfFiles[i].getName());
                    file_Creation_Date.add(df.format(myDate));
                    file_Extension.add(extension);
                   // System.out.println("Directory" + listOfFiles[i].getName()+": Directory Creation date :"+myDate+":Directory Extension :"+extension);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        log.info("successfully fetched filename,date,filetype:)");

       FilesFolder ff= set();
        return ff;
    }
    public FilesFolder set()
    {
        log.info("You called set method here setting filename,date,fileextension to class.");
        FilesFolder ff=new FilesFolder(file_Name,file_Creation_Date,file_Extension);
//        ff.setFile_name(file_Name);
//        ff.setFile_creation_date(file_Creation_Date);
//        ff.setFile_extension(file_Extension);
        filesRepository.save(ff);
        log.info("successfully  saved all data.");
        return ff;
    }

    public List<FilesFolder> findALl() {
        return (List<FilesFolder>) filesRepository.findAll();
    }



//    public FilesFolder findByName(String name) {
//        System.out.println(filesRepository.searchByFileName(name));
//
//        return null;
//    }


        public List<FileName> findByName(String filename) {
            List<FileName> fn= fileNameRepo.findByName(filename);
            return fn;
        }


        public List<FileExtension> findByType(String filetype) {
                 List<FileExtension> fe=fileExtensionRepo.findByType(filetype);
            return fe;
        }



}
