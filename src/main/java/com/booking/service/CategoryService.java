package com.booking.service;

import java.util.List;

import com.booking.dto.CategoryDto;

public interface CategoryService {
	public List<CategoryDto> selectAll();
	public int getTotalCount(List<CategoryDto> list);
}
