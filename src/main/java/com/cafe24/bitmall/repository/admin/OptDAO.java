package com.cafe24.bitmall.repository.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.OptVO;

@Repository("adminOptDAO")
public class OptDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(String name) {
		int count = sqlSession.insert("admin_opt.insert",name);
		return count == 1;
	}
	
	public boolean insert(OptVO vo) {
		int count = sqlSession.insert("admin_opt.insert_opts",vo);
		return count == 1;
	}
	
	public List<OptVO> select(){
		return sqlSession.selectList("admin_opt.select_list");
	}
	
	public List<OptVO> select(String name){
		return sqlSession.selectList("admin_opt.select_opts",name);
	}
	
	public OptVO select(OptVO vo){
		return sqlSession.selectOne("admin_opt.select_check_opts",vo);
	}
	
	public boolean delete(Long no) {
		int count = sqlSession.insert("admin_opt.delete_opts",no);
		return count == 1;
	}
	
	public boolean update(OptVO vo) {
		int count = sqlSession.update("admin_opt.update_opts",vo);
		return count == 1;
	}
	
	public boolean delete(String name) {
		int count = sqlSession.insert("admin_opt.delete_opt",name);
		return count == 1;
	}
	
	public boolean update(Map<String, String> map) {
		int count = sqlSession.update("admin_opt.update_opt",map);
		return count == 1;
	}
	
	// 상품옵션 테이블 insert
	public boolean insert(Map<String, Long> map) {
		int count = sqlSession.insert("admin_opt.insert_product_opt",map);
		return count == 1;
	}
	
}
