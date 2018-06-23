package com.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dao.FileDao;
import com.booking.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	private FileDao fileDao;
	
	@Autowired
	public FileServiceImpl(FileDao fileDao){
		this.fileDao = fileDao;
	}

	@Override
	public String selectSaveFileName(int fileId) {
		return fileDao.selectSaveFileName(fileId);
	}

	@Override
	public List<Integer> selectProductImageList(int productId) {
		return fileDao.selectProductImageList(productId);
	}

	@Override
	public List<Integer> selectProductNoticeImageList(int productId) {
		return fileDao.selectProductNoticeImageList(productId);
	}
	
	
}
