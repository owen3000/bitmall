package com.cafe24.bitmall.repository.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.ProductVO;
import com.cafe24.util.PagingBean;

@Repository("adminProductDAO")
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(ProductVO vo) {
		int count = sqlSession.insert("admin_product.insert",vo);
		return count == 1;
	}
	
	public boolean insert(Map<String, Long> map) {
		int count = sqlSession.insert("admin_product.insert_product_event",map);
		return count == 1;
	}

	public List<HashMap<String, String>> select(PagingBean pb) {
		return sqlSession.selectList("admin_product.select_product_list", pb);

	}
	
	public Long select(Map<String, String> opts) {
		return sqlSession.selectOne("admin_product.select_totalCount",opts);
	}
}
