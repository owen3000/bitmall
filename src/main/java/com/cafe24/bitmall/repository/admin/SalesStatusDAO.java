package com.cafe24.bitmall.repository.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.SalesStatusVO;

@Repository("adminSalesStatusDAO")
public class SalesStatusDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<SalesStatusVO> select() {
		return sqlSession.selectList("admin_sales_status.select_list");
	}

	
}
