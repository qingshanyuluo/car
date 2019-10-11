package com.car.dao;

import java.util.List;
import java.util.Map;

import com.car.vo.Page;
import com.car.vo.T_Car;

public interface CarDao {
	
	public int AllCarCount();// 统计车辆总数
	public int CarKeywordCount(String keyword, String dateStart, String dateEnd);			//关键字查询充电站计数
	public List<T_Car> CarSelect(Page page, String keyword, String dateStart, String dateEnd, String orderBy, String SC);      //关键字查询充电站列表
	public List<T_Car> AllCar(Page page, String orderBy, String SC);          //得到所有充电站的列表
	public int AddCarInfo(T_Car tCar);//添加汽车详情
	public int DeleteCar(T_Car tCar);//删除汽车详情
	public T_Car CarInfo(String C_VIN); //根据汽车ID查询车主信息
	public int UpdateCar(T_Car tcar);         //更新车辆信息
	public List CarTypeCount();//统计车辆类型数据
	public List CarStatusCount();//统计车辆状态数据
}
