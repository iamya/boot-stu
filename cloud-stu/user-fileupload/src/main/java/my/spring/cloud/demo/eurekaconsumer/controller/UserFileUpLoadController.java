package my.spring.cloud.demo.eurekaconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UserFileUpLoadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFileUpLoadController.class);

    @PostMapping( "/upload")
    public @ResponseBody String handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {

        LOGGER.info("file name : {}", file.getOriginalFilename());
        LOGGER.info("file size : {}", file.getSize());

        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, fileToSave);

        LOGGER.info("file store path: {}", fileToSave.getAbsolutePath());
        return fileToSave.getAbsolutePath();
    }
}
