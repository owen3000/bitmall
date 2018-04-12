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
	
	/*public void joinUser(UserVO vo) {
		UserVO uvo = userDAO.insert(vo);
		BlogVO bvo = new BlogVO();
		bvo.setNo(uvo.getNo());
		bvo.setTitle("My Blog");
		CategoryVO cvo = new CategoryVO();
		cvo.setBlogNo(bvo.getNo());
		cvo.setCategory("미분류");
		cvo.setDescription("카테고리를 지정하지 않은경우");
		blogDAO.insert(bvo);
		categoryDAO.insert(cvo);
	}*/

}
