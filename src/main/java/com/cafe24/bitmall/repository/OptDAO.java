package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.OptVO;

@Repository
public class OptDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<OptVO> select(Long no) {
		return sqlSession.selectList("opt.select_opt",no);
	}
	
	public List<OptVO> select(String name) {
		return sqlSession.selectList("opt.select_opts",name);
	}
	
}
