package com.cafe24.bitmall.repository.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.CategoryVO;

@Repository("adminCategoryDAO")
public class CategoryDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVO> select() {
		return sqlSession.selectList("admin_category.select_list");
	}

	
}
