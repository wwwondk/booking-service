package com.booking.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.ProductDao;
import com.booking.dao.ProductPriceDao;
import com.booking.dto.ProductDto;
import com.booking.dto.ProductSummaryDto;
import com.booking.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	final static int PRODUCT_UNIT = 10;
	private ProductDao productDao;
	private ProductPriceDao productPriceDao;
	
	@Autowired
	public ProductServiceImpl(ProductDao productDao, ProductPriceDao productPriceDao) {
		this.productDao = productDao;
		this.productPriceDao = productPriceDao;
	}

	@Override
	public List<ProductDto> getList(int categoryId, int page) {
		List<ProductDto> list = (categoryId == 0 ? selectAll(page) : selectByCategory(categoryId, page * PRODUCT_UNIT));
		return list;
	}
	
	@Override
	public List<ProductDto> selectAll(int page) {
		return productDao.selectAll(page * PRODUCT_UNIT);
	}

	@Override
	public List<ProductDto> selectByCategory(int categoryId, int page) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("categoryId", categoryId);
		map.put("page", page * PRODUCT_UNIT);
		return productDao.selectByCategory(map);
	}

	@Override
	public ProductSummaryDto selectProductSummary(int productId) {
		return productDao.selectProductSummary(productId);
	}

	@Override
	public List<ProductPriceDao> selectProductPrice(int productId) {
		return productPriceDao.selectProductPrice(productId);
	}

}
