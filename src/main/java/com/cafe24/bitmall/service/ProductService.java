package com.cafe24.bitmall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.bitmall.repository.EventDAO;
import com.cafe24.bitmall.repository.ImageDAO;
import com.cafe24.bitmall.repository.OptDAO;
import com.cafe24.bitmall.repository.ProductDAO;
import com.cafe24.bitmall.vo.EventVO;
import com.cafe24.bitmall.vo.ImageVO;
import com.cafe24.bitmall.vo.OptVO;
import com.cafe24.bitmall.vo.ProductVO;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private EventDAO eventDAO;
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Autowired
	private OptDAO optDAO;
	
	
	public List<HashMap<String, Object>> getList() {
		List<HashMap<String, Object>> list = productDAO.select();
		for (int i = 0; i < list.size(); i++) {
			String images = (String) list.get(i).get("originalName");
			String[] result = images.split("/");
			list.get(i).put("originalName", result[0]);
		}
		for (int i = 0; i < list.size(); i++) {
			String images = (String) list.get(i).get("saveName");
			String[] result = images.split("/");
			list.get(i).put("saveName", result[0]);
		}
	
		//이벤트 정보 추가
		for (int i = 0; i < list.size(); i++) {
			Long lProductNo = Long.parseLong(list.get(i).get("no").toString());
			List<EventVO> eventList = eventDAO.select(lProductNo);
			list.get(i).put("eventList", eventList);
		}
		
		return list;
	}
	
	public List<ImageVO> getImageListByNo(Long no) {
		return imageDAO.select(no);
	}
	

	public Map<String, Object> getDetail(Long no) {
		Map<String, Object> map = new HashMap<String,Object>();
		ProductVO productVO = productDAO.select(no);
		System.out.println(productVO);
		List<ImageVO> imageList = imageDAO.select(productVO.getNo());
		List<EventVO> eventList = eventDAO.select(productVO.getNo());
		List<OptVO> optList = optDAO.select(productVO.getNo());
		
		for (int i = 0; i < optList.size(); i++) {
			List<OptVO> temp = optDAO.select(optList.get(i).getName());
			if("사이즈".equals(optList.get(i).getName())) {
				map.put("size", temp);
			}else if("색상".equals(optList.get(i).getName())) {
				map.put("color", temp);
			}

			
		}
		
		//discount 계산
		int discount = 0;
		for (int i = 0; i < eventList.size(); i++) {
			discount += eventList.get(i).getRate();
		}
	
		map.put("productVO", productVO);
		map.put("imageList", imageList);
		map.put("eventList", eventList);
		map.put("discount", discount);
		return map;
	}
	

}
