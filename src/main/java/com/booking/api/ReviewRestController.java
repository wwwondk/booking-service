package com.booking.api;

import java.util.Iterator;

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
		System.out.println("starPoint: " + starPoint);
		System.out.println("comment : " + comment);
		System.out.println("file size : " + files.length);
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		System.out.println(multipartHttpServletRequest);
		

		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				System.out.println("------------- file start -------------");
				System.out.println("name : " + multipartFile.getName());
				System.out.println("filename : " + multipartFile.getOriginalFilename());
				System.out.println("size : " + multipartFile.getSize());
				System.out.println("-------------- file end --------------\n");
			}
		}

	}
	
}
