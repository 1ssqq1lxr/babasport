package com.it.babasport.service;

import java.util.List;

import com.it.babasport.po.bbs_city;

public interface CityService {

	List<bbs_city> findCitysByProvince(int pid);

}
