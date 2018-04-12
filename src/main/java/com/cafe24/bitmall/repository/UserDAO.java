package com.cafe24.bitmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public UserVO select(UserVO vo) {
		return sqlSession.selectOne("user.login", vo);
	}
	
	public boolean insert(UserVO vo) {
		int count = sqlSession.insert("user.insert", vo);
		return count == 1;
	}
	
	public String select(String id) {
		return sqlSession.selectOne("user.select_id", id);
	}
	
	public UserVO select(Long no) {
		return sqlSession.selectOne("user.select_one", no);
	}
	
	public boolean update(UserVO vo) {
		int count = sqlSession.update("user.update", vo);
		return count == 1;
	}
	
}
