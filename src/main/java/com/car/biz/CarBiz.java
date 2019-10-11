package com.car.biz;

import java.util.List;
import java.util.Map;

import com.car.vo.Page;
import com.car.vo.T_Car;

public interface CarBiz {
	
	public int AllCarCount(); // 得到所有车辆的数目
	public int CarKeywordCount(String keyword, String dateStart, String dateEnd);	//关键字查询车辆计数
	public List<T_Car> CarSelect(Page page, String keyword, String dateStart, String dateEnd, String orderBy, String SC);      //关键字查询车辆列表
	public List<T_Car> AllCar(Page page, String orderBy, String SC);          //得到所有车辆的列表
	public boolean AddCarInfo(T_Car tCar);//添加汽车
    public boolean DeleteCar(T_Car tCar);//删除汽车*/
	public T_Car CarInfo(String C_VIN);   //得到一个车辆的详细信息
	public boolean UpdateCar(T_Car tcar);          //更新车辆信息
	public List CarTypeCount();//统计车辆类型的数目
	public List CarStatusCount();//统计车辆类型的数目


}
