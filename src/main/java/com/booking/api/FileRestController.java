package com.booking.api;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;
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
    public FileSystemResource downloadFile(@PathVariable int id, @RequestParam(required = false) Integer size, HttpServletRequest request) throws IOException{
    	
    	String rootPath = request.getSession().getServletContext().getRealPath("/");
    	String originalFileName = fileService.selectSaveFileName(id);    	
    	String filePath = rootPath + originalFileName;
    	
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("File Not Found ID=[ "+id+" ]");
        } else {
        	if(size != null){
	        	BufferedImage image = ImageIO.read(file);
	        	int imageWidth = image.getWidth();
	        	int imageHeight = image.getHeight();
	        	
	        	double ratio = (imageWidth > imageHeight) ?  (double)size/(double)imageWidth : (double)size/(double)imageHeight;
	        	int width = (int)(imageWidth * ratio);
	        	int height = (int)(imageHeight * ratio);
	        	
	    		Image resizeImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    		Graphics graphics = newImage.getGraphics();
	    		graphics.drawImage(resizeImage, 0, 0, null);
	    		graphics.dispose();
	    		
	    		String name = originalFileName.substring(originalFileName.lastIndexOf("\\")+1);
	    		ImageIO.write(newImage, "png", new File(rootPath+"tempImage\\" + name));
	    		file = new File(rootPath+"tempImage\\" + name);
        	}
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
