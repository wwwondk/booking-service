package com.booking.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.booking.dao.ReviewDao;
import com.booking.dto.ReviewDetailDto;
import com.booking.dto.ReviewDto;
import com.booking.dto.ReviewWriteDto;
import com.booking.service.FileService;
import com.booking.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewDao reviewDao;
	private FileService fileService;
	
	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao, FileService fileService) {
		this.reviewDao = reviewDao;
		this.fileService = fileService;
	}
	
	@Override
	public List<ReviewDto> selectProductReviewList(int productId, int page, int limit) {
		Map<String, Object> param = new HashMap<>();
		param.put("productId", productId);
		param.put("page", page);
		param.put("limit", 3);
		return reviewDao.selectProductReviewList(param);
	}

	@Override
	public ReviewDetailDto selectReviewAvgCount(int productId) {
		return reviewDao.selectReviewAvgCount(productId);
	}

	@Override
	public void insertReview(int starPoint, String comment, MultipartFile[] reviewFile, HttpServletRequest request) {
		
		// 트랜잭션처리
		int productId = 1;	// 수정하기
		int userId = 10;	// 수정하기
		ReviewWriteDto reviewWriteDto = new ReviewWriteDto();
		reviewWriteDto.setProductId(productId);
		reviewWriteDto.setUserId(userId);
		reviewWriteDto.setScore((float)starPoint);
		reviewWriteDto.setComment(comment);
		
		int reservationUserCommentId = reviewDao.insertReview(reviewWriteDto);

		if(reviewFile.length > 0){
			List<Integer> fileIdList = fileService.uploadFile(reviewFile, request);

			HashMap<String, Object> param = new HashMap<>();
			param.put("reservationUserCommentId", reservationUserCommentId);
			
			for(int i = 0; i < fileIdList.size(); i++){
				param.put("fileId", fileIdList.get(i));
				reviewDao.insertReviewImage(param);
			}
		}
		
	}

}
