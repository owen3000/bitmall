package com.cafe24.bitmall.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	private static String SAVE_PATH = "/bitmall/uploads";
	private static String PREFIX_URL = "/uploads/images/";
	
	public String restore(MultipartFile multipartFile) {
		String url = "";
		try {

			String originFilename = multipartFile.getOriginalFilename();
			if( "".equals(originFilename) ) {
				return url;
			}
			// 확장자 이름 추출
			String extName = 
			originFilename.substring(originFilename.lastIndexOf("."),
										originFilename.length());
			// size
			long size = multipartFile.getSize();
			//저장할 이름
			String saveFilename = getSaveFilename(extName);
			writeFile(multipartFile,saveFilename);
			url = PREFIX_URL+saveFilename;
			System.out.println(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}

	private void writeFile(MultipartFile multipartFile, String saveFilename) throws IOException {
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(
				SAVE_PATH+"/"+saveFilename);
		fos.write(fileData);
		fos.close();
	}

	private String getSaveFilename(String extName) {
		String filename = "";

		Calendar cal = Calendar.getInstance();
		filename += cal.get(Calendar.YEAR);
		filename += cal.get(Calendar.MONTH);
		filename += cal.get(Calendar.DATE);
		filename += cal.get(Calendar.HOUR);
		filename += cal.get(Calendar.MINUTE);
		filename += cal.get(Calendar.SECOND);
		filename += cal.get(Calendar.MILLISECOND);
		filename += extName;
		return filename;
	}
}
