package com.frostfire.webmvc;

import jakarta.annotation.Nullable;
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
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Invalid file type. Only JPEG files are allowed.");
            }
            if (file.isEmpty()){
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("File is empty.");
            }
            // Check the file's size
            if (file.getSize() > 1_000_000) { // 1 MB limit
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("File is too large. The size limit is 1 MB.");
            }
            // Save the file to the server
            file.transferTo(new java.io.File( path + file.getOriginalFilename()));
            return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
        }

        catch (IOException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not upload the file: " + e.getMessage());
        }

        // Add your processing logic here
        //return ResponseEntity.ok("Success");
    }
}
