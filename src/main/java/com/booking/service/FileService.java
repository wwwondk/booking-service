package com.booking.service;

import java.util.List;

import com.booking.dto.FileDto;

public interface FileService {
	public String selectSaveFileName(int fileId);
	public List<Integer> selectProductImageList(int productId);
	public List<Integer> selectProductNoticeImageList(int productId);
	public Integer selectProductInformationImage(int productId);
	public Integer insertImage(FileDto fileDto);
}
