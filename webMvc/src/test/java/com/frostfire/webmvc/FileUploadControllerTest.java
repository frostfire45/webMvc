package com.frostfire.webmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FileUploadControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Value("${app.document-root}")String documentRoot;

    @Test
    public void test_uploadOfJpegFile() throws Exception {
        String fileName = "sample-file-mock.jpeg";
        MockMultipartFile sampleFile = new MockMultipartFile(
                "myfile",
                fileName,
                "image/jpeg",
                "This is the file content".getBytes());

        MockMultipartHttpServletRequestBuilder multipartRequest =
                MockMvcRequestBuilders.multipart("/upload/image");

        mockMvc.perform(multipartRequest.file(sampleFile))
                .andExpect(status().isOk());
    }

    @Test
    public void test_uploadOfTextFile() throws Exception {
        String fileName = "sample-file-mock.txt";
        MockMultipartFile sampleFile = new MockMultipartFile(
                "myfile",
                fileName,
                "text/plain",
                "This is the file content".getBytes());

        MockMultipartHttpServletRequestBuilder multipartRequest =
                MockMvcRequestBuilders.multipart("/upload/image");

        mockMvc.perform(multipartRequest.file(sampleFile))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void test_handleFileUpload_NoFileProvided() throws Exception {
        MockMultipartHttpServletRequestBuilder multipartRequest =
                MockMvcRequestBuilders.multipart("/upload/image");

        mockMvc.perform(multipartRequest)
                .andExpect(status().isBadRequest());
    }

}