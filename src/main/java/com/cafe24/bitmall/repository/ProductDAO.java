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
	
	public List<HashMap<String, Object>> selectList(Long categoryNo) {
		return sqlSession.selectList("product.select",categoryNo);
	}
	public List<HashMap<String, Object>> selectSearchList(String productName) {
		return sqlSession.selectList("product.select_product_search",productName);
	}
	
	public ProductVO select(Long no) {
		return sqlSession.selectOne("product.select_by_no",no);
	}

}
