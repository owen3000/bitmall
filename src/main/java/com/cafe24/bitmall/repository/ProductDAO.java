package com.cafe24.bitmall.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.ProductVO;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<HashMap<String, Object>> select() {
		return sqlSession.selectList("product.select");
	}
	
	public ProductVO select(Long no) {
		return sqlSession.selectOne("product.select_by_no",no);
	}

}
