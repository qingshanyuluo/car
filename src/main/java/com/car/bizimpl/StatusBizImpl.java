package com.car.bizimpl;

import java.util.List;
import java.util.Map;

import com.car.biz.StatusBiz;
import com.car.dao.StatusDao;
import com.car.daoimpl.StatusDaoImpl;
import com.car.vo.Page;
import com.car.vo.T_C_Status;

public class StatusBizImpl implements StatusBiz {
	StatusDao statusdao = new StatusDaoImpl();

	public int AllStatusCount() {
		// TODO Auto-generated method stub
		return statusdao.AllStatusCount();
	}
	
	@Override
	public List<T_C_Status> AllStatus(Page page,String orderBy,String SC) {
		// TODO Auto-generated method stub
		return statusdao.AllStatus(page, orderBy, SC);
	}
	public int CarKeywordCount(String C_VIN){
		// TODO Auto-generated method stub
		return statusdao.CarKeywordCount(C_VIN);
	}
	
	public List<T_C_Status> CarSelect(Page page, String C_VIN,String orderBy, String SC) {
		// TODO Auto-generated method stub
		return statusdao.CarSelect(page, C_VIN, orderBy, SC);
	}
	
	public Map<String, Object>  GetRoute(String C_VIN,String dateStart, String dateEnd) {
		// TODO Auto-generated method stub
		return (Map<String, Object>) statusdao.GetRoute( C_VIN, dateStart, dateEnd);
	}
	
	public T_C_Status CarLonlat( String C_VIN) {
		// TODO Auto-generated method stub
		return statusdao.CarLonlat(C_VIN);
	}
	
}
