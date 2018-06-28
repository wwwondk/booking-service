package com.booking.service;

import java.util.List;

import com.booking.dto.ProductDetailDto;
import com.booking.dto.ProductDto;
import com.booking.dto.ProductPriceDto;
import com.booking.dto.ProductReservationDto;
import com.booking.dto.ProductSummaryDto;

public interface ProductService {
	public List<ProductDto> getList(int categoryId, int page);
	public List<ProductDto> selectAll(int page);
	public List<ProductDto> selectByCategory(int categoryId, int page);
	public ProductSummaryDto selectProductSummary(int productId);
	public ProductDetailDto selectProductDetail(int productId);
	public List<ProductPriceDto> selectProductPrice(int productId);
	public ProductReservationDto selectProductReservation(int productId);
}
