package com.cafe24.bitmall.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.admin.SalesStatusDAO;
import com.cafe24.bitmall.vo.SalesStatusVO;

@Service("adminSalesStatusService")
public class SalesStatusService {
	
	@Autowired
	private SalesStatusDAO salesStatusDAO;
	
	
	public List<SalesStatusVO> getList() {
		
		return salesStatusDAO.select();
	}


}
