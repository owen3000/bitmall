package com.cafe24.bitmall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.ImageDAO;
import com.cafe24.bitmall.repository.JumunDAO;
import com.cafe24.bitmall.vo.DeliverySiteVO;
import com.cafe24.bitmall.vo.ImageVO;
import com.cafe24.util.PagingBean;

@Service
public class JumunService {
	@Autowired
	private JumunDAO jumunDAO;
	
	@Autowired
	private ImageDAO imageDAO;
	
	public List<HashMap<String, Object>> getList(PagingBean pb, Long userNo){
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("userNo", userNo);
		map.put("startCount", pb.getStartCount());
		map.put("countList", new Long( pb.getCountList()));
		
		return jumunDAO.select(map);
	}

	public Long getTotalCount(Long userNo) {
		
		return jumunDAO.selectTotalCount(userNo);
	}

	public List<HashMap<String, Object>> getList(Long userNo,Long orderNo){
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("orderNo", orderNo);
		map.put("userNo", userNo);
		
		List<HashMap<String, Object>> list = jumunDAO.selectInfo(map);
		// image 추가
		for (int i = 0; i < list.size(); i++) {
			ImageVO imageVO = imageDAO.selectOne( new Long( (Integer)list.get(i).get("productNo")) );
			list.get(i).put("imageVO", imageVO);
		}
		
		return list;
	}
	
	public DeliverySiteVO getDeliverySite(Long orderNo, Long userNo) {
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("orderNo", orderNo);
		map.put("userNo", userNo);
		
		return jumunDAO.selectDeliverySite(map);
	}
}
