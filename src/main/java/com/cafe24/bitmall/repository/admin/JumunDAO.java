package com.cafe24.bitmall.repository.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.util.PagingBean;

@Repository("adminJumunDAO")
public class JumunDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<HashMap<String, Object>> select(PagingBean pb) {
		return sqlSession.selectList("admin_jumun.select_list",pb);
	}
	public Long select(Map<String, String> opts) {
		return sqlSession.selectOne("admin_jumun.select_totalCount",opts);
	}
	public boolean update(Map<String, String> noAndState) {
		int count = sqlSession.update("admin_jumun.update_order_state",noAndState);
		return count == 1 ;
	}
	
}
