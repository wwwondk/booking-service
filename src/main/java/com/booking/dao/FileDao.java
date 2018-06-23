package com.booking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface FileDao {
	public String selectSaveFileName(int fileId);
	public List<Integer> selectProductImageList(int productId);
	public List<Integer> selectProductNoticeImageList(int productId);
}
