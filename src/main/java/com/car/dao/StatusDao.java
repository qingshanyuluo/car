package com.car.dao;

import java.util.List;
import java.util.Map;

import com.car.vo.Page;
import com.car.vo.T_C_Status;

public interface StatusDao {
	 public int AllStatusCount();// 统计车辆总数
	 public List<T_C_Status> AllStatus(Page page, String orderBy, String SC);          //得到所有充电站的列表
     public int CarKeywordCount(String C_VIN);			//关键字查询充电站计数
	 public List<T_C_Status> CarSelect(Page page, String C_VIN, String orderBy, String SC);     //关键字查询充电站列表
	 
	 
	 public Map<String, Object>  GetRoute(String C_VIN, String dateStart, String dateEnd);
	 
	 public T_C_Status CarLonlat(String C_VIN);     //根据C_VIN询充电站列表
	 
	 
}
