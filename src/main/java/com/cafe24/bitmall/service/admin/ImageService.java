package com.cafe24.bitmall.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.admin.ImageDAO;
import com.cafe24.bitmall.vo.ImageVO;

@Service("adminImageService")
public class ImageService {
	
	@Autowired
	private ImageDAO imageDAO;
	
	public List<ImageVO> getByNo(Long no) {
		return imageDAO.select(no);
	}
}
