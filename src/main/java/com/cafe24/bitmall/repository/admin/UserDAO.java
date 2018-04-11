package com.cafe24.bitmall.repository.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.UserVO;
import com.cafe24.util.PagingBean;

@Repository("adminUserDAO")
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public UserVO select(UserVO vo) {
		return sqlSession.selectOne("admin_user.login", vo);
	}
	
	public Long confirmAuth(UserVO vo) {
		return sqlSession.selectOne("admin_user.confirm_auth", vo);
	}
	
	public Long select(Map<String, String> map) {
		return sqlSession.selectOne("admin_user.select_totalCount",map);
	}
	
	public List<UserVO> select(PagingBean pb) {
		return sqlSession.selectList("admin_user.select_list",pb);
	}
	
	public boolean delete(Long no) {
		int count = sqlSession.delete("admin_user.delete",no);
		return count == 1;
	}
	
}
