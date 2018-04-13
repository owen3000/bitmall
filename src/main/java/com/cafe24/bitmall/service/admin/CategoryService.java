package com.cafe24.bitmall.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.admin.CategoryDAO;
import com.cafe24.bitmall.vo.CategoryVO;

@Service("adminCategoryService")
public class CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	public List<CategoryVO> getList() {
		
		return categoryDAO.select();
	}


}
