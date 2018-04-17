package com.cafe24.bitmall.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.bitmall.repository.OrderDAO;
import com.cafe24.bitmall.vo.DeliverySiteVO;
import com.cafe24.bitmall.vo.OrderProductOptVO;
import com.cafe24.bitmall.vo.OrderProductVO;
import com.cafe24.bitmall.vo.OrderVO;

@Service
public class OrderService {
	@Autowired
	private OrderDAO orderDAO;

	
	@Transactional
	public boolean insertOrder(DeliverySiteVO deliverySiteVO,OrderVO orderVO,
			List<HashMap<String, Object>> cartList) {
		boolean flag = false;
		orderDAO.insert(deliverySiteVO);
		orderVO.setDeliverySiteNo(deliverySiteVO.getNo());
		orderDAO.insert(orderVO);
		
		for (int i = 0; i < cartList.size(); i++) {
			OrderProductVO orderProductVO = new OrderProductVO();
			
			orderProductVO.setOrderNo(orderVO.getNo());
			orderProductVO.setProductNo( new Long( (Integer) cartList.get(i).get("productNo")));
			orderProductVO.setAmount(new Long((Integer) cartList.get(i).get("amount")));
			orderProductVO.setPrice(new Long((Integer) cartList.get(i).get("price")));
			orderDAO.insert(orderProductVO);
			
			String[] optNos = cartList.get(i).get("optNos").toString().split("/");
			for (int j = 0; j < optNos.length; j++) {
				OrderProductOptVO vo = new OrderProductOptVO();
				vo.setOrderProductNo(orderProductVO.getNo());
				vo.setOptNo(Long.parseLong(optNos[j]));
				System.out.println(vo);
				flag = orderDAO.insert(vo);
			}
			
		}
		
		return flag;
	}


}
