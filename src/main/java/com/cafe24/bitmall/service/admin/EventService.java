package com.cafe24.bitmall.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.admin.EventDAO;
import com.cafe24.bitmall.vo.EventVO;

@Service("adminEventService")
public class EventService {
	
	@Autowired
	private EventDAO eventDAO;
	
	
	public List<EventVO> getList() {
		
		return eventDAO.select();
	}


}
