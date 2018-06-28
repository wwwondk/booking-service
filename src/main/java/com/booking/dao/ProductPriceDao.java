package com.booking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.booking.dto.ProductPriceDto;

@Repository
public interface ProductPriceDao {
	public List<ProductPriceDto> selectProductPrice(int productId);
}
