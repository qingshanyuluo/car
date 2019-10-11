package com.car.bizimpl;

import java.util.List;
import java.util.Map;

import com.car.biz.CarBiz;

import com.car.dao.CarDao;
import com.car.daoimpl.CarDaoImpl;
import com.car.vo.Page;
import com.car.vo.T_Car;

public class CarBizImpl implements CarBiz {
	CarDao cardao = new CarDaoImpl();


	public int AllCarCount() {
		// TODO Auto-generated method stub
		return cardao.AllCarCount();
	}
	public int CarKeywordCount(String keyword, String dateStart, String dateEnd){
		// TODO Auto-generated method stub
		return cardao.CarKeywordCount(keyword,dateStart,dateEnd);
	}
	
	public List<T_Car> CarSelect(Page page, String keyword , String dateStart, String dateEnd,
			String orderBy, String SC) {
		// TODO Auto-generated method stub
		return cardao.CarSelect(page, keyword, dateStart, dateEnd, orderBy, SC);
	}
	
	@Override
	public List<T_Car> AllCar(Page page,String orderBy,String SC) {
		// TODO Auto-generated method stub
		return cardao.AllCar(page, orderBy, SC);
	}

	@Override
	public boolean AddCarInfo(T_Car tCar) {
		// TODO Auto-generated method stub
		int temp=cardao.AddCarInfo(tCar);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean DeleteCar(T_Car tCar) {
		// TODO Auto-generated method stub
		int temp=cardao.DeleteCar(tCar);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public T_Car CarInfo(String C_VIN) {
		// TODO Auto-generated method stub
		return cardao.CarInfo(C_VIN);
	}
	@Override
	public boolean UpdateCar(T_Car tCar) {
		// TODO Auto-generated method stub
		int temp=cardao.UpdateCar(tCar);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public List CarTypeCount() {
		// TODO Auto-generated method stub
		return cardao.CarTypeCount();
	}
	@Override
	public List CarStatusCount() {
		// TODO Auto-generated method stub
		return cardao.CarStatusCount();
	}
	
}
