package com.booking.api;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.service.FileService;

@RestController
@RequestMapping("/files")
public class FileRestController {
	
    private FileService fileService;

    @Autowired
    public FileRestController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{id}")
    public FileSystemResource getFile(@PathVariable int id) {
    	System.out.println(fileService.selectSaveFileName(id));
        File file = new File(fileService.selectSaveFileName(id));
        if (!file.exists()) {
            throw new RuntimeException("File Not Found");
        } else {
            return new FileSystemResource(file);
        }
    }
}
