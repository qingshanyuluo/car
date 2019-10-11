package com.car.daoimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.car.dao.StatusDao;
import com.car.util.DBHelper;
import com.car.vo.Page;
import com.car.vo.T_C_Status;

public class StatusDaoImpl implements StatusDao {
	private DBHelper DB;

	public StatusDaoImpl() {
		DB = new DBHelper();
	}

	
	public int AllStatusCount() {
		// TODO Auto-generated method stub
		String sql = "select count(distinct C_VIN) as cn from t_c_status";
		int temp = 0;

		Result rs = DB.executeQuery_new(sql);
		if (rs != null && rs.getRowCount() != 0) {
			Map row = rs.getRows()[0];
			temp = Integer.parseInt(row.get("cn").toString());
		}
		return temp;
	}
   
	public List<T_C_Status> AllStatus(Page page,String orderBy,String SC) {
		// TODO Auto-generated method stub
		
		String sql;
    	sql="select * FROM t_c_status as a where not exists(select 1 from t_c_status where C_ID=a.C_ID and  C_VIN=a.C_VIN and C_Time>a.C_Time)  ORDER BY "+orderBy+" "+SC+" limit ?,?";
		
		List<T_C_Status> cList=new ArrayList<T_C_Status>();
			Result rs=DB.executeQuery_new(sql,page.getSelectIndex(),page.getShowNumber());
			
			
			System.out.println("共有"+rs.getRowCount()+"条");
			if (rs != null && rs.getRowCount() != 0) {
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map row = rs.getRows()[i];
					T_C_Status tcs = new T_C_Status();
				    tcs.setC_ID(Integer.parseInt(row.get("C_ID").toString()));
				    tcs.setC_VIN(Integer.parseInt(row.get("C_VIN").toString()));
			        tcs.setC_Status(Integer.parseInt(row.get("C_Status").toString()));
				    tcs.setCharge_Status(Integer.parseInt(row.get("Charge_Status").toString()));
				    tcs.setC_Speed(Integer.parseInt(row.get("C_Speed").toString()));
				    tcs.setC_Voltage(Integer.parseInt(row.get("C_Voltage").toString()));
				    tcs.setC_Electricity(Integer.parseInt(row.get("C_Electricity").toString()));
				    	 tcs.setCs_Speed(Integer.parseInt(row.get("Cs_Speed").toString()));
				    tcs.setM_Status(Integer.parseInt(row.get("M_Status").toString()));
				    tcs.setB_Status(Integer.parseInt(row.get("B_Status").toString()));
				    tcs.setGPS_Status(Integer.parseInt(row.get("GPS_Status").toString()));
				   tcs.setC_latitude(Float.valueOf(row.get("C_latitude").toString()));
				    tcs.setC_longitude(Float.valueOf(row.get("C_longitude").toString()));
				    tcs.setC_Time(Timestamp.valueOf(row.get("C_Time").toString()));
					cList.add(tcs);
				}
		
	    }
			return cList;
      }

	
	public int CarKeywordCount(String C_VIN) {
	
		C_VIN="%"+C_VIN.trim()+"%";
		String sql = "SELECT count(distinct C_VIN) As cn FROM t_c_status where C_VIN like ?";
		int temp = 0;
		Result rs = DB.executeQuery_new(sql,C_VIN);
		if (rs != null && rs.getRowCount() != 0) {
			Map row = rs.getRows()[0];
			temp = Integer.parseInt(row.get("cn").toString());
		}
		return temp;
	
		
	}
	
	public List<T_C_Status> CarSelect(Page page, String C_VIN ,String orderBy, String SC) {
		// TODO Auto-generated method stub
		//orderBy="t_car."+orderBy;
		String sql;
		Result rs=null;
		C_VIN="%"+C_VIN.trim()+"%";
		List<T_C_Status> cList=new ArrayList<T_C_Status>();
		
		if("asc".equals(SC)){
			sql="select * from t_c_status as a where not exists(select 1 from t_c_status where C_ID=a.C_ID and  C_VIN=a.C_VIN and C_Time>a.C_Time) and ( C_VIN like ?) ORDER BY "+orderBy+"  asc limit ?,?";
		}else{
			sql="select * from t_c_status as a where not exists(select 1 from t_c_status where C_ID=a.C_ID and  C_VIN=a.C_VIN and C_Time>a.C_Time) and ( C_VIN like ?) ORDER BY "+orderBy+"  desc limit ?,?";
		}
		
		
		rs=DB.executeQuery_new(sql,C_VIN,page.getSelectIndex(),page.getShowNumber());

		System.out.println("共有"+rs.getRowCount()+"条");
		if (rs != null && rs.getRowCount() != 0) {
			for (int i = 0; i < rs.getRowCount(); i++) {
				Map row = rs.getRows()[i];
				T_C_Status tcs = new T_C_Status();
			    tcs.setC_ID(Integer.parseInt(row.get("C_ID").toString()));
			    tcs.setC_VIN(Integer.parseInt(row.get("C_VIN").toString()));
			    tcs.setC_Status(Integer.parseInt(row.get("C_Status").toString()));
			    tcs.setCharge_Status(Integer.parseInt(row.get("Charge_Status").toString()));
			    tcs.setC_Speed(Integer.parseInt(row.get("C_Speed").toString()));
			    tcs.setC_Voltage(Integer.parseInt(row.get("C_Voltage").toString()));
			    tcs.setC_Electricity(Integer.parseInt(row.get("C_Electricity").toString()));
			    tcs.setCs_Speed(Integer.parseInt(row.get("Cs_Speed").toString()));
			  
			    tcs.setM_Status(Integer.parseInt(row.get("M_Status").toString()));
			    tcs.setB_Status(Integer.parseInt(row.get("B_Status").toString()));
			    tcs.setGPS_Status(Integer.parseInt(row.get("GPS_Status").toString()));
			  
			    
			    tcs.setC_latitude(Float.valueOf(row.get("C_latitude").toString()));
			    tcs.setC_longitude(Float.valueOf(row.get("C_longitude").toString()));
			    tcs.setC_Time(Timestamp.valueOf(row.get("C_Time").toString()));
				cList.add(tcs);
			}
		
		}
		return cList;
	}

	
	public Map<String, Object>  GetRoute(String C_VIN,String dateStart, String dateEnd) {
		String sql;
		Result rs=null;
		//如果最小时间和最大时间都不为空
		if((dateStart!=null && !dateStart.equals("")) && (dateEnd!=null && !dateEnd.equals(""))){
			sql="select C_Time, C_longitude, C_latitude from t_c_status where (C_VIN=?) and (C_Time between ? and ?) ";
			rs=DB.executeQuery_new(sql,C_VIN,dateStart,dateEnd);
		}
		//如果最小时间不为空，最大时间为空
		if((dateStart!=null && !dateStart.equals("")) && (dateEnd==null || dateEnd.equals(""))){
			sql="select C_Time, C_longitude, C_latitude from t_c_status where (C_VIN=?) and (C_Time > ?)";
			rs=DB.executeQuery_new(sql,C_VIN,dateStart);
	}
		//如果最小时间为空，最大时间不为空
		if((dateStart==null || dateStart.equals("")) && (dateEnd!=null && !dateEnd.equals(""))){
			sql="select C_Time, C_longitude, C_latitude from t_c_status where (C_VIN=?) and (C_Time < ?) ";
			rs=DB.executeQuery_new(sql,C_VIN,dateEnd);
	}
		//如果两个时间都为空
		if((dateStart==null || dateStart.equals("")) && (dateEnd==null || dateEnd.equals(""))){
			 sql = "select C_longitude,C_latitude from t_c_status where TO_DAYS(C_Time) = TO_DAYS(NOW()) and C_VIN=?";
			rs=DB.executeQuery_new(sql,C_VIN);
	}
		System.out.println("共有"+rs.getRowCount()+"条");
		 List list = new ArrayList();
		 Map<String, Object> data = new HashMap<String, Object>();
		if (rs != null && rs.getRowCount() != 0) {
			for (int i = 0; i < rs.getRowCount(); i++) {
				Map row = rs.getRows()[i];
				
				 float[] name = new float[]{Float.valueOf(row.get("C_longitude").toString()),Float.valueOf(row.get("C_latitude").toString())};
				 list.add(name);
			}
			data.put("name", "路线0");
			data.put("path", list);
			return data;
		}else{
			return null;
		}
		
		
	}

	public T_C_Status CarLonlat( String C_VIN ) {
		// TODO Auto-generated method stub
		//orderBy="t_car."+orderBy;
		String sql;
		Result rs=null;
		sql="select C_longitude , C_latitude  from t_c_status as a where not exists(select 1 from t_c_status where C_ID=a.C_ID and  C_VIN=a.C_VIN and C_Time>a.C_Time) and (C_VIN =?);";		
		rs=DB.executeQuery_new(sql,C_VIN);
		T_C_Status tcs = new T_C_Status();
		System.out.println("共有"+rs.getRowCount()+"条");
		if (rs != null && rs.getRowCount() != 0) {
			for (int i = 0; i < rs.getRowCount(); i++) {
				Map row = rs.getRows()[i];
				
		    
			    tcs.setC_latitude(Float.valueOf(row.get("C_latitude").toString()));
			    tcs.setC_longitude(Float.valueOf(row.get("C_longitude").toString()));

			}
		
		}
		return tcs;
	}
	
	
}
