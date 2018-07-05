package com.booking.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.booking.dao.FileDao;
import com.booking.dto.FileDto;
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
	
	@Override
	public Integer selectProductInformationImage(int productId){
		return fileDao.selectProductInformationImage(productId);
	}

	@Override
	public List<Integer> uploadFile(MultipartFile[] files, HttpServletRequest request) {

		String rootPath = request.getSession().getServletContext().getRealPath("/");      	
    	String formattedDate = rootPath + new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd").format(new Date());

        File f = new File(formattedDate);
        if(!f.exists()){ // 파일이 존재하지 않는다면 하위폴더까지 만든다.
            f.mkdirs();
        }
    
        List<Integer> result = null;
        if(files.length > 0){
        	result = new ArrayList<>();
        }
        
		MultipartFile multipartFile = null;
		
		for(int i = 0; i < files.length; i++){
			
			multipartFile = files[i];

			String contentType = multipartFile.getContentType();
            String name = multipartFile.getName();
            String originalFilename = multipartFile.getOriginalFilename();
            long size = multipartFile.getSize();
            
            String uuid = UUID.randomUUID().toString();
            String saveFileName = formattedDate + File.separator + uuid; // 저장 절대 경로
			
            System.out.println("name :" + name);
            System.out.println("originalFilename : " + originalFilename);
            System.out.println("saveFileName : " + saveFileName);

            int USER_ID = 10;			//수정하기
            contentType = "한줄평이미지"; 	//수정하기
 
            try(
                InputStream in = multipartFile.getInputStream();
                FileOutputStream fos = new FileOutputStream(saveFileName)){
                int readCount = 0;
                byte[] buffer = new byte[512];
                while((readCount = in.read(buffer)) != -1){
                    fos.write(buffer,0,readCount);
                }
                
                FileDto fileDto = new FileDto();
                fileDto.setUser_id(USER_ID);
                fileDto.setFileName(originalFilename);
                fileDto.setSaveFileName(saveFileName);
                fileDto.setFileLength((int)size);
                fileDto.setContentType(contentType);
                
                result.add(fileDao.insertImage(fileDto));
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
		}
		return result;
		
	}

}
