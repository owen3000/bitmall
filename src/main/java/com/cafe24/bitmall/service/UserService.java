package com.cafe24.bitmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.UserDAO;
import com.cafe24.bitmall.vo.UserVO;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public UserVO login(UserVO vo) {
		return userDAO.select(vo);
	}
	
	public boolean join(UserVO vo) {
		return userDAO.insert(vo);
	}
	
	public boolean checkId(String id) {
		String temp = userDAO.select(id);
		if( "".equals(temp) || temp == null ) {
			return false;
		}
		return true;
	}
	
	public UserVO get(Long no) {
		return userDAO.select(no);
	}
	
	public boolean update(UserVO vo) {
		return userDAO.update(vo);
	}
	
	

}
