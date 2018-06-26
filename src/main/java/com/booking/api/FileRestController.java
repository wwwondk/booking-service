package com.booking.api;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

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
    public FileSystemResource downloadFile(@PathVariable int id, HttpServletRequest request) {
    	
    	String rootPath = request.getSession().getServletContext().getRealPath("/");
    	String originalFileName = fileService.selectSaveFileName(id);    	
    	String filePath = rootPath + originalFileName;

        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("File Not Found ID=[ "+id+" ]");
        } else {
            return new FileSystemResource(file);
        }
    }
}
