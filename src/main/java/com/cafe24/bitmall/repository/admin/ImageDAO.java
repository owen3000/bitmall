package com.cafe24.bitmall.repository.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.ImageVO;

@Repository("adminImageDAO")
public class ImageDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(ImageVO vo) {
		int count = sqlSession.insert("admin_image.insert", vo);
		return count == 1;
	}

	
}
