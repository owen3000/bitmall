package com.cafe24.bitmall.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.admin.UserDAO;
import com.cafe24.bitmall.vo.UserVO;
import com.cafe24.util.PagingBean;

@Service("adminUserService")
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public UserVO login(UserVO vo) {
		return userDAO.select(vo);
	}
	
	public Long confirmAuth(UserVO vo) {
		
		return userDAO.confirmAuth(vo);
	}
	
	public Long getTotalCount(String option, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("option", option);
		map.put("keyword", keyword);
		return userDAO.select(map);
	}
	
	public List<UserVO> getList(PagingBean pb) {
		
		return userDAO.select(pb);
	}
	
	public boolean delete(Long no) {
		
		return userDAO.delete(no);
	}
	

}
