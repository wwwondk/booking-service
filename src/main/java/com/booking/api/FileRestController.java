package com.booking.api;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
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
@PropertySources({
	@PropertySource(value="classpath:/auth.properties", ignoreResourceNotFound=true),
	@PropertySource("/auth.properties")
})
public class FileRestController {
	
	@Value("${naver.login.client.id.query}")
	private String clientIdQuery;
	
    private FileService fileService;

    @Autowired
    public FileRestController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{id}")
    public FileSystemResource downloadFile(@PathVariable int id, @RequestParam(required = false) Integer size, HttpServletRequest request){
    	
    	String rootPath = request.getSession().getServletContext().getRealPath("/");
    	String originalFileName = fileService.selectSaveFileName(id);    	
    	String filePath = rootPath + originalFileName;
    	
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("File Not Found ID=[ "+id+" ]");
        } else {
        	if(size != null){
 
				try {
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
		    		
		    		String name = originalFileName.substring(originalFileName.lastIndexOf("/")+1);
		    		File tempFile = new File(rootPath+"/"+size+"/tempImage/" + name);
		    		if(!tempFile.exists()){
		    			tempFile.mkdirs();
		    			ImageIO.write(newImage, "png", tempFile);
		    		}
		    		file = tempFile;
				} catch (IOException e) {
					
				}

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
