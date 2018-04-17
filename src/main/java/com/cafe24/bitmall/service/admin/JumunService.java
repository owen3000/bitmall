package com.cafe24.bitmall.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.admin.JumunDAO;
import com.cafe24.util.PagingBean;

@Service("adminJumunService")
public class JumunService {
	
	@Autowired
	private JumunDAO jumunDAO;
	
	public List<HashMap<String, Object>> getList( PagingBean pb) {
		return jumunDAO.select(pb);
	}

	public Long getTotalCount(Map<String, String> opts) {
		
		return jumunDAO.select(opts);
	}

}
