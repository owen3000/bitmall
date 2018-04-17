package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.EventVO;

@Repository
public class EventDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<EventVO> select(Long no) {
		return sqlSession.selectList("event.select_event",no);
	}
	
	
}
