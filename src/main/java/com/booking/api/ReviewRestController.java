package com.booking.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
public class ReviewRestController {

	@PostMapping("/comments")
	public void insertReview(@RequestParam int starPoint, @RequestParam String comment, @RequestParam MultipartFile[] files,
			HttpServletRequest request) {
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		System.out.println(multipartHttpServletRequest);
		
		System.out.println("starPoint: " + starPoint);
		System.out.println("comment : " + comment);

		String rootPath = request.getSession().getServletContext().getRealPath("/");      	
    	String formattedDate = rootPath + new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd").format(new Date());

        File f = new File(formattedDate);
        if(!f.exists()){ // 파일이 존재하지 않는다면
            f.mkdirs(); // 해당 디렉토리를 만든다. 하위폴더까지 한꺼번에 만든다.
        }
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				
				String contentType = multipartFile.getContentType();
                String name = multipartFile.getName();
                String originalFilename = multipartFile.getOriginalFilename();
                long size = multipartFile.getSize();
                
                String uuid = UUID.randomUUID().toString(); // 중복될 일이 거의 없다.
                String saveFileName = formattedDate + File.separator + uuid; // 실제 저장되는 파일의 절대 경로
				
                System.out.println("title :");
                System.out.println("contentType :" + contentType);
                System.out.println("name :" + name);
                System.out.println("originalFilename : " + originalFilename);
                System.out.println("size : " + size);
                System.out.println("saveFileName : " + saveFileName);
                
                try(
                        InputStream in = multipartFile.getInputStream();
                        FileOutputStream fos = new FileOutputStream(saveFileName)){
                    int readCount = 0;
                    byte[] buffer = new byte[512];
                    while((readCount = in.read(buffer)) != -1){
                        fos.write(buffer,0,readCount);
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
			}
		}

	}
	
}
