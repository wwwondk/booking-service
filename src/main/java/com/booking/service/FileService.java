package com.booking.service;

import java.util.List;

public interface FileService {
	public String selectSaveFileName(int fileId);
	public List<Integer> selectProductImageList(int productId);
	public List<Integer> selectProductNoticeImageList(int productId);
}
