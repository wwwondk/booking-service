package com.booking.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.booking.dto.ProductDetailDto;
import com.booking.dto.ProductDto;
import com.booking.dto.ProductReservationDto;
import com.booking.dto.ProductSummaryDto;

@Repository
public interface ProductDao {
	public List<ProductDto> selectAll(int page);
	public List<ProductDto> selectByCategory(Map<String, Integer> map);
	public ProductSummaryDto selectProductSummary(int productId);
	public ProductDetailDto selectProductDetail(int productId);
	public ProductReservationDto selectProductReservation(int productId);
}
