package com.cafe24.bitmall.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.bitmall.repository.admin.ImageDAO;
import com.cafe24.bitmall.repository.admin.OptDAO;
import com.cafe24.bitmall.repository.admin.ProductDAO;
import com.cafe24.bitmall.service.FileUploadService;
import com.cafe24.bitmall.vo.ImageVO;
import com.cafe24.bitmall.vo.ProductVO;
import com.cafe24.util.PagingBean;
import com.cafe24.util.WebUtil;

@Service("adminProductService")
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private OptDAO optDAO;
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Autowired
	private FileUploadService fileUploadService;

	@Transactional
	public boolean insert(ProductVO pvo, String[] event, MultipartFile[] mpf, String[] opt) {
		// product insert
		if( !productDAO.insert(pvo) ) {
			System.out.println("[ProductService:insert] 상품 등록 실패 !");
			return false;
		}
		
		// product_event insert
		if( !("none".equals(event[0])) ) {
			for (int i = 0; i < event.length; i++) {
				Map<String, Long> map = new HashMap<String,Long>();
				map.put("productNo", pvo.getNo());
				Long eventNo = WebUtil.checkParameter(event[i].trim(), -1L);
				if( eventNo == -1L ) {
					System.out.println("[ProductService:insert] if( eventNo == -1L )");
					break;
				}
				map.put("eventNo", eventNo);
				if( !productDAO.insert(map) )
					System.out.println("[ProductService:insert] if( !productDAO.insert(map) )");
			}			
		}
		
		// product_opt insert
		if( !("none".equals(opt[0])) ) {
			for (int i = 0; i < opt.length; i++) {
				Map<String, Long> map = new HashMap<String,Long>();
				map.put("productNo", pvo.getNo());
				Long optNo = WebUtil.checkParameter(opt[i].trim(), -1L);
				if( optNo == -1L ) {
					System.out.println("[ProductService:insert] if( optNo == -1L )");
					break;
				}
				map.put("optNo", optNo);
				if( !optDAO.insert(map) )
					System.out.println("[ProductService:insert] if(optDAO.insert(map))");
			}	
		}

		// image insert
		if( mpf.length != 0 ) {
			String originFilename = "";
			String saveFilename = "";
			String url = "";
			for (int i = 0; i < mpf.length; i++) {
				originFilename = mpf[i].getOriginalFilename();
				url = fileUploadService.restore(mpf[i]);
				if( !("".equals(url)) ) {
					saveFilename = 
							url.substring(url.lastIndexOf("/")+1,url.length());
				}
				ImageVO ivo = new ImageVO();
				ivo.setOriginalName(originFilename.trim());
				ivo.setSaveName(saveFilename.trim());
				ivo.setProductNo(pvo.getNo());
				if( !imageDAO.insert(ivo) ) 
					System.out.println("[ProductService:insert] if( !imageDAO.insert(ivo) ) ");
			}
		}

		return true;
	}
	
	public List<HashMap<String, String>> getList(PagingBean pb ){

		return productDAO.select(pb);
	}
	
	public Long getTotalCount(Map<String, String> opts) {
		
		return productDAO.select(opts);
	}

}
