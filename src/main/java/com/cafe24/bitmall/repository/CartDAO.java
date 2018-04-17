package com.cafe24.bitmall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.CartVO;

@Repository
public class CartDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(CartVO vo) {
		int count = sqlSession.insert("cart.insert", vo);
		return count == 1;
	}
	public boolean insert(Map<String, Long> map) {
		int count = sqlSession.insert("cart.insert_cart_option", map);
		return count == 1;
	}
	public List<HashMap<String, Object>> select(Long userNo) {
		return sqlSession.selectList("cart.select_cart", userNo);
	}
	public boolean delete(Long userNo) {
		int count = sqlSession.delete("cart.delete", userNo);
		return count == 1;
	}
	public boolean deleteOne(Long cartNo) {
		int count = sqlSession.delete("cart.delete_One", cartNo);
		return count == 1;
	}
	
	
}
