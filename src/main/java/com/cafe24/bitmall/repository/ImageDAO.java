package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.ImageVO;

@Repository
public class ImageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<ImageVO> select(Long no) {
		return sqlSession.selectList("image.select",no);
	}
	public ImageVO selectOne(Long productNo) {
		return sqlSession.selectOne("image.select_one",productNo);
	}
	
	
}
