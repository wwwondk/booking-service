package com.booking.service;

import java.util.List;

import com.booking.dao.ProductPriceDao;
import com.booking.dto.ProductDto;
import com.booking.dto.ProductSummaryDto;

public interface ProductService {
	public List<ProductDto> getList(int categoryId, int page);
	public List<ProductDto> selectAll(int page);
	public List<ProductDto> selectByCategory(int categoryId, int page);
	public ProductSummaryDto selectProductSummary(int productId);
	public List<ProductPriceDao> selectProductPrice(int productId);
}
