package com.frostfire.webmvc.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@RestController
public class FileUploadController {

    @Value("${app.document-root}")
    private String path;

    @RequestMapping(value = "/upload/image", method = RequestMethod.POST )
    @ResponseBody
    public ResponseEntity<String> uploadSingleFileImage(@RequestParam("myfile") MultipartFile file){
        try {
            // Check if the file's content type is acceptable
            if (!Objects.equals(file.getContentType(), "image/jpeg")) {
                return getJpegFileContentResponse();
            }
            if (file.isEmpty()){
                return getFileEmtpyResponse();
            }
            // Check the file's size
            if (file.getSize() > 1_000_000) { // 1 MB limit
                return getFileSizeResponse();
            }
            return processFileForResponse(file);

        } catch (IOException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not upload the file: " + e.getMessage());
        }
    }

    @RequestMapping(value = "/upload/csv", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> uploadCsvFile(@RequestParam("myfile") MultipartFile file){
        try{
            if (!Objects.equals(file.getContentType(), "text/csv")) {
                return getCsvFileContentResponse();
            }
            if (file.isEmpty()){
                return getFileEmtpyResponse();
            }
            if (file.getSize() > 1_000_000) {
                return getFileSizeResponse();
            }
            return processFileForResponse(file);

        } catch (IOException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not upload the file: " + e.getMessage());
        }
    }
    private ResponseEntity<String> processFileForResponse(MultipartFile fileIn) throws IOException {
        // Set path to where the file should go.
        java.io.File uploadedFile = new java.io.File(path + fileIn.getOriginalFilename());
        // Test if the file on the path exists
        if(!uploadedFile.exists()) {
            // Save the file to the server
            fileIn.transferTo(uploadedFile);
            System.out.println("File Uploaded");
            return ResponseEntity.ok("File uploaded successfully: " + fileIn.getOriginalFilename());
        }
        else {
            System.out.println("File Already Exists");
            return ResponseEntity.ok("File Already Exists: " + fileIn.getOriginalFilename());
        }
    }
    private ResponseEntity<String> getFileEmtpyResponse(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("File is empty.");
    }
    private ResponseEntity<String> getJpegFileContentResponse(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid file type. Only JPEG files are allowed.");

    }
    private ResponseEntity<String> getCsvFileContentResponse(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid file type. Only CSV files are allowed.");
    }
    private ResponseEntity<String> getFileSizeResponse(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("File is too large. The size limit is 1 MB.");
    }
}
