package com.booking.api;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.booking.service.FileService;

@RestController
@RequestMapping("/files")
@PropertySource("classpath:/auth.properties")
public class FileRestController {
	
	@Value("${naver.login.client.id.query}")
	private String clientIdQuery;
	
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
    
    @GetMapping("/maps")
    public String downloadMapSrc(@RequestParam double pointX, @RequestParam double pointY, ModelAndView model) {
    	String src = "https://openapi.naver.com/v1/map/staticmap.bin?clientId="+ clientIdQuery +
    			"&url=http://localhost&crs=EPSG:4326&center=" + pointX + "," + pointY + "&level=11&w=300&h=250&baselayer=default&markers=" + pointX + "," + pointY;
    	
    	return src;
    }
    
}
