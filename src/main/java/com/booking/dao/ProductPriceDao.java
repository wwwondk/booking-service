package com.booking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceDao {
	public List<ProductPriceDao> selectProductPrice(int productId);
}
