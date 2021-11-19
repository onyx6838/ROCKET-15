package com.vti.service;

import com.vti.utils.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Service
public class FileService implements IFileService{
    @Value("${folder.resource}/documents")
    private String documentFolder;

    @Autowired
    private FileManager fileManager;

    @Override
    public String uploadImage(MultipartFile image) throws IOException {
        String absolutePathFolder = new File(documentFolder).getAbsolutePath();
        String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(Objects.requireNonNull(image.getOriginalFilename()));

        String path = absolutePathFolder + "\\" + nameImage;

        fileManager.createNewMultiPartFile(path, image);

        // TODO save link file to database

        // return link uploaded file
        return nameImage;
    }

    @Override
    public File downloadImage(String nameImage) {

        String path = documentFolder + "/" + nameImage;

        return new File(path);
    }
}
