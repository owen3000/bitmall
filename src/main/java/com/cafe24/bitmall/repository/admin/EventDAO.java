package com.cafe24.bitmall.repository.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.CategoryVO;
import com.cafe24.bitmall.vo.EventVO;

@Repository("adminEventDAO")
public class EventDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<EventVO> select() {
		return sqlSession.selectList("admin_event.select_list");
	}

	
}
