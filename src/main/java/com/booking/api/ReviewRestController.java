package com.booking.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.booking.service.ReviewService;

@RestController
public class ReviewRestController {
	
	private ReviewService reviewService;
	
	@Autowired
	public ReviewRestController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@PostMapping("/comments")
	public void insertReview(@RequestParam int starPoint, @RequestParam String comment,	
			@RequestParam MultipartFile[] reviewFile, HttpServletRequest request) {
	
		System.out.println("starPoint: " + starPoint+ " / comment : " + comment+" / reviewFile : "+reviewFile.length);

		reviewService.insertReview(starPoint, comment, reviewFile, request);

		/*
		String rootPath = request.getSession().getServletContext().getRealPath("/");      	
    	String formattedDate = rootPath + new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd").format(new Date());

        File f = new File(formattedDate);
        if(!f.exists()){ // 파일이 존재하지 않는다면 하위폴더까지 만든다.
            f.mkdirs();
        }
    
		MultipartFile multipartFile = null;
		
		for(int i = 0; i < reviewFile.length; i++){
			multipartFile = reviewFile[i];

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
		*/
		
	}
	
}
