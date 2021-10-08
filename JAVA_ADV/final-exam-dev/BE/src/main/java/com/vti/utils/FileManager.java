package com.vti.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

    public boolean isFileOrFolderExist(String path) throws IOException {
        return new File(path).exists();
    }

    public boolean isTypeFileImage(MultipartFile file) {
        return file.getContentType().toLowerCase().contains("image");
    }

    public void createNewMultiPartFile(String path, MultipartFile multipartFile)
            throws IllegalStateException, IOException {
        // write file
        File file = new File(path);
        multipartFile.transferTo(file);
    }

    public String getFormatFile(String input) {
        String[] results = input.split("\\.");
        return results[results.length - 1];
    }
}
