package com.booking.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.booking.dto.FileDto;

@Repository
public interface FileDao {
	public String selectSaveFileName(int fileId);
	public List<Integer> selectProductImageList(int productId);
	public List<Integer> selectProductNoticeImageList(int productId);
	public Integer selectProductInformationImage(int productId);
	public Integer insertImage(FileDto fileDto);
}
