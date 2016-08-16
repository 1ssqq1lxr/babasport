package com.it.babasport.service;

import com.it.babasport.po.bbs_img;

public interface ImgService {
	public void insertImg(bbs_img img);

	public String getUrl(Integer id);

	public void deleteByProductId(int id);
}
