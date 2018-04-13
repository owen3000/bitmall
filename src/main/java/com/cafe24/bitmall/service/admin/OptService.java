package com.cafe24.bitmall.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.bitmall.repository.admin.OptDAO;
import com.cafe24.bitmall.vo.OptVO;

@Service("adminOptService")
public class OptService {
	@Autowired
	private OptDAO optDAO;
	
	public boolean insert(String name) {
		return optDAO.insert(name);
	}
	
	@Transactional
	public boolean insertOpts(OptVO vo) {
		OptVO check = optDAO.select(vo);
		
		if(check != null) {
			return false;
		}
		return optDAO.insert(vo);
	}
	
	public List<OptVO> getList(){
		return optDAO.select();
	}
	
	public List<OptVO> getOptsList(String name){
		return optDAO.select(name);
	}
	
	public boolean deleteOpts(Long no) {
		return optDAO.delete(no);
	}
	
	public boolean updateOpts(OptVO vo) {
		return optDAO.update(vo);
	}
	
	public boolean deleteOpt(String name) {
		return optDAO.delete(name);
	}
	
	public boolean updateOpt(String selectName, String updateName) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("updateName", updateName);
		map.put("selectName", selectName);
		return optDAO.update(map);
	}
}
