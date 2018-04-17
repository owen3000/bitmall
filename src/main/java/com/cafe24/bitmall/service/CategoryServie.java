package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.CategoryDAO;
import com.cafe24.bitmall.vo.CategoryVO;

@Service
public class CategoryServie {
	@Autowired
	private CategoryDAO categoryDAO;

	public List<CategoryVO> getList() {
		
		return categoryDAO.select();
	}

}
