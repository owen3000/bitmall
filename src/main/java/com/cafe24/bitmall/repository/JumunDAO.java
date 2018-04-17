package com.cafe24.bitmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.DeliverySiteVO;

@Repository
public class JumunDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<HashMap<String, Object>> select(Map<String, Long> map ) {
		return sqlSession.selectList("jumun.select_jumuns", map);
	}
	
	public Long selectTotalCount(Long userNo) {
		return sqlSession.selectOne("jumun.select_totalCount", userNo);
	}
	public DeliverySiteVO selectDeliverySite(Map<String, Long> map) {
		return sqlSession.selectOne("jumun.select_delivery_site", map);
	}
	
	public List<HashMap<String, Object>> selectInfo(Map<String, Long> map) {
		return sqlSession.selectList("jumun.select_jumun", map);
	}
}
