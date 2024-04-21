package com.megayasa.Backend.Utils;

import com.megayasa.Backend.Exceptions.ErrorException;
import com.megayasa.Backend.Exceptions.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PhotoService {

    public String UploadPhoto(String fileName){
        String newPath = DataProperties.UPLOAD_FOLDER;
        File directory = new File(newPath);
        if (!directory.exists()){
            directory.mkdirs();
        }
        File beginFile = null;
        File endFile = null;

        // Set random name photo

        beginFile = new File(fileName);
        endFile = new File(newPath+"/"+ fileName);
        try {
            Files.copy(beginFile.toPath(), endFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileName = newPath + "/" + fileName;
        return fileName;
    }

    public void deletePhoto(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) throw new NotFoundException("Foto tidak ditemukan");

        try {
            file.delete();
        } catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }
    }
}
