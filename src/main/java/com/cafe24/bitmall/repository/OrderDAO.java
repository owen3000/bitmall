package com.cafe24.bitmall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.DeliverySiteVO;
import com.cafe24.bitmall.vo.OrderProductOptVO;
import com.cafe24.bitmall.vo.OrderProductVO;
import com.cafe24.bitmall.vo.OrderVO;

@Repository
public class OrderDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(DeliverySiteVO vo) {
		int count = sqlSession.insert("order.insert_deliverysitevo", vo);
		return count == 1;
	}
	public boolean insert(OrderVO vo) {
		int count = sqlSession.insert("order.insert_order", vo);
		return count == 1;
	}
	public boolean insert(OrderProductVO vo) {
		int count = sqlSession.insert("order.insert_order_product", vo);
		return count == 1;
	}
	public boolean insert(OrderProductOptVO vo) {
		int count = sqlSession.insert("order.insert_order_product_opt", vo);
		return count == 1;
	}
	
	
}
