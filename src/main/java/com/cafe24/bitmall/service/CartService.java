package com.cafe24.bitmall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.bitmall.repository.CartDAO;
import com.cafe24.bitmall.repository.ImageDAO;
import com.cafe24.bitmall.vo.CartVO;
import com.cafe24.bitmall.vo.ImageVO;

@Service
public class CartService {
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Transactional
	public boolean insertProduct(CartVO vo,List<Long> optNoList) {
		boolean result = false;
		result = cartDAO.insert(vo);
		
		for (int i = 0; i < optNoList.size(); i++) {
			Map<String, Long> map = new HashMap<String,Long>();
			map.put("cartNo", vo.getNo());
			if( optNoList.get(i) != -1L) {
				map.put("optNo", optNoList.get(i));
				result = cartDAO.insert(map);
			}
		}
		return result;
	}
	
	public List<HashMap<String, Object>> getList(Long userNo){
		List<HashMap<String, Object>> list = cartDAO.select(userNo);
		// image 추가
		for (int i = 0; i < list.size(); i++) {
			ImageVO imageVO = imageDAO.selectOne( new Long( (Integer)list.get(i).get("productNo")) );
			list.get(i).put("imageVO", imageVO);
		}
		
		return list;
	}
	
	public boolean deleteCart(Long userNo) {
		return cartDAO.delete(userNo);
	}
	
	public boolean deleteOne(Long cartNo) {
		return cartDAO.deleteOne(cartNo);
	}

}
