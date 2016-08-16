package com.it.babasport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.it.babasport.po.ColorLoad;

public interface ColorService {
	public List<ColorLoad> load();

	public String getColorNameById(Integer colorId);
}
