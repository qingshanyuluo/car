package com.car.daoimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.car.dao.CarDao;
import com.car.util.DBHelper;
import com.car.vo.Page;
import com.car.vo.T_Car;


public class CarDaoImpl implements CarDao {

	private DBHelper DB;

	public CarDaoImpl() {
		DB = new DBHelper();
	}



	public int AllCarCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) AS cn from t_car";
		int temp = 0;

		Result rs = DB.executeQuery_new(sql);
		if (rs != null && rs.getRowCount() != 0) {
			Map row = rs.getRows()[0];
			temp = Integer.parseInt(row.get("cn").toString());
		}
		return temp;
	}
   
	
	public int CarKeywordCount(String keyword, String dateStart, String dateEnd) {
		// TODO Auto-generated method stub
		String sql; 
		int temp=0;
		keyword="%"+keyword.trim()+"%";
		Result rs=null;
		//如果最小时间和最大时间都不为空
				if((dateStart!=null && !dateStart.equals("")) && (dateEnd!=null && !dateEnd.equals(""))){
					sql="SELECT count(*) As cn FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ?) and (C_Time Between ? and ?) ";
					rs=DB.executeQuery_new(sql,keyword,keyword,keyword,dateStart,dateEnd);
				}
				//如果最小时间不为空，最大时间为空
				if((dateStart!=null && !dateStart.equals("")) && (dateEnd==null || dateEnd.equals(""))){
					sql="SELECT count(*) As cn FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ?) and (C_Time > ?)";
					rs=DB.executeQuery_new(sql,keyword,keyword,keyword,dateStart);
			}
				//如果最小时间为空，最大时间不为空
				if((dateStart==null || dateStart.equals("")) && (dateEnd!=null && !dateEnd.equals(""))){
					sql="SELECT count(*) As cn FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ?) and (C_Time < ?) ";
					rs=DB.executeQuery_new(sql,keyword,keyword,keyword,dateEnd);
			}
				//如果两个时间都为空
				if((dateStart==null || dateStart.equals("")) && (dateEnd==null || dateEnd.equals(""))){
					sql="SELECT count(*) As cn FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ?)  ";
					rs=DB.executeQuery_new(sql,keyword,keyword,keyword);
			}
		
			if(rs!=null && rs.getRowCount()!=0){   
				 Map row = rs.getRows()[0]; 
		         temp=Integer.parseInt(row.get("cn").toString());
			}

		return temp;
	}
	
	public List<T_Car> CarSelect(Page page, String keyword, String dateStart, String dateEnd,
			String orderBy, String SC) {
		// TODO Auto-generated method stub
		//orderBy="t_car."+orderBy;
		String sql;
		Result rs=null;
		keyword="%"+keyword.trim()+"%";
		List<T_Car> cList=new ArrayList<T_Car>();
		
		//如果最小时间和最大时间都不为空
		if((dateStart!=null && !dateStart.equals("")) && (dateEnd!=null && !dateEnd.equals(""))){
				if("asc".equals(SC)){
					sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ? ) and (C_Time Between ? and ?) ORDER BY "+orderBy+"  asc limit ?,?";
				}else{
					sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ? ) and (C_Time Between ? and ?) ORDER BY "+orderBy+"  desc limit ?,?";
				}
				
				rs=DB.executeQuery_new(sql,keyword,keyword,keyword,dateStart,dateEnd,page.getSelectIndex(),page.getShowNumber());
		}
		//如果最小时间不为空，最大时间为空
		if((dateStart!=null && !dateStart.equals("")) && (dateEnd==null || dateEnd.equals(""))){
			if("asc".equals(SC)){
				sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ? ) and (C_Time > ?)  ORDER BY "+orderBy+"  asc limit ?,?";
			}else{
				sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ? ) and (C_Time > ?)  ORDER BY "+orderBy+"  desc limit ?,?";
			}
			
			rs=DB.executeQuery_new(sql,keyword,keyword,keyword,dateStart,page.getSelectIndex(),page.getShowNumber());
	}
		//如果最小时间为空，最大时间不为空
		if((dateStart==null || dateStart.equals("")) && (dateEnd!=null && !dateEnd.equals(""))){
			if("asc".equals(SC)){
				sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ? ) and (C_Time < ?) ORDER BY "+orderBy+"  asc limit ?,?";
			}else{
				sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ? ) and (C_Time < ?) ORDER BY "+orderBy+"  desc limit ?,?";
			}
			
			rs=DB.executeQuery_new(sql,keyword,keyword,keyword,dateEnd,page.getSelectIndex(),page.getShowNumber());
	}
		//如果两个时间都为空
		if((dateStart==null || dateStart.equals("")) && (dateEnd==null || dateEnd.equals(""))){
			if("asc".equals(SC)){
				sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ? )   ORDER BY "+orderBy+"  asc limit ?,?";
			}else{
				sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID and (c.C_ID like ? or U_Name like ? or U_Address like ? )   ORDER BY "+orderBy+"  desc limit ?,?";
			}
			
			rs=DB.executeQuery_new(sql,keyword,keyword,keyword,page.getSelectIndex(),page.getShowNumber());
	}
			if(rs!=null && rs.getRowCount()!=0){   
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map row = rs.getRows()[i];
					T_Car cars = new T_Car();
					cars.setC_ID(Integer.parseInt(row.get("C_ID").toString()));
					cars.setC_Type(String.valueOf(row.get("C_Type")));
					cars.setU_Address(String.valueOf(row.get("U_Address")));
					cars.setC_Time(Timestamp.valueOf(row.get("C_Time").toString()));
					cars.setU_Time(Timestamp.valueOf(row.get("U_Time").toString()));
					cars.setU_Name(String.valueOf(row.get("U_Name")));
					cars.setU_Email(String.valueOf(row.get("U_Email")));
					cars.setC_VIN(Integer.parseInt(row.get("C_VIN").toString()));
					cList.add(cars);
				}
			}
		
		return cList;
	}
	
	
	public List<T_Car> AllCar(Page page,String orderBy,String SC) {
		// TODO Auto-generated method stub
		
		String sql;
		if("asc".equals(SC)){
			sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID ORDER BY "+orderBy+"  asc limit ?,?";
		}else{
			sql="SELECT * FROM t_car c ,t_user u where c.C_ID=u.C_ID ORDER BY "+orderBy+"  desc limit ?,?";
		}
		List<T_Car> cList=new ArrayList<T_Car>();
		
			Result rs=DB.executeQuery_new(sql,page.getSelectIndex(),page.getShowNumber());
			if(rs!=null && rs.getRowCount()!=0){   
				for (int i = 0; i < rs.getRowCount(); i++) {
					Map row = rs.getRows()[i];
					T_Car cars = new T_Car();
					cars.setC_ID(Integer.parseInt(row.get("C_ID").toString()));
					cars.setC_Type(String.valueOf(row.get("C_Type")));
					cars.setU_Time(Timestamp.valueOf(row.get("U_Time").toString()));
					cars.setC_Time(Timestamp.valueOf(row.get("C_Time").toString()));
					cars.setU_Address(String.valueOf(row.get("U_Address")));
					cars.setU_Email(String.valueOf(row.get("U_Email")));
					cars.setU_Name(String.valueOf(row.get("U_Name")));
					cars.setC_VIN(Integer.parseInt(row.get("C_VIN").toString()));
					cList.add(cars);
				}
			}
		return cList;
	}
	
	
	public int AddCarInfo(T_Car tCar) {
		// TODO Auto-generated method stub
		
		String sql1="select * from   t_car c ,t_user u where c.C_ID=u.C_ID  and  c.C_VIN=?";
		Boolean  flag=DB.isExist_new(sql1, tCar.getC_VIN());
		if(!flag){
			
			String sql="insert into t_car(C_ID,C_VIN,C_Type,C_Time) values (?,?,?,?)";
			String sql2="insert into t_user(U_Name,C_ID,U_Time,U_Tel,U_Address,U_Email) values (?,?,?,?,?,?)";
			String sql3="insert into t_c_status(C_ID,C_VIN,C_Time) values (?,?,?)";
			int temp=DB.executeNonQuery(sql,tCar.getC_VIN(),tCar.getC_VIN(),tCar.getC_Type(),new Timestamp(tCar.getC_Time().getTime()));
			int temp1= DB.executeNonQuery(sql2,tCar.getU_Name(),tCar.getC_VIN(),new Timestamp(tCar.getC_Time().getTime()),tCar.getU_Tel(),tCar.getU_Address(),tCar.getU_Email());
			int temp2= DB.executeNonQuery(sql3,tCar.getC_VIN(),tCar.getC_VIN(),new Timestamp(tCar.getC_Time().getTime()));
			
			//System.out.println("temp的值："+temp+"temp1:"+temp1);
			return 1;
		}else{
		  System.out.println("数据已经存在，无法进行再次插入");
		  return 0;
		}
	}
	
	public int DeleteCar(T_Car tCar) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		String sql1 = "DELETE FROM t_car  WHERE C_ID=?";
		String sql2 = "DELETE FROM t_user WHERE C_ID=?";
		String sql3 = "DELETE FROM t_c_status WHERE  C_ID=?";
		
		int temp1=DB.executeNonQuery(sql1,tCar.getC_VIN());
		int temp2=DB.executeNonQuery(sql2,tCar.getC_VIN());
		int temp3=DB.executeNonQuery(sql3,tCar.getC_VIN());
		System.out.println("temp1的得值："+temp1+"temp2的值"+temp2+"temp3的值"+temp3);
		if(temp1!=0&&temp2!=0&&temp3!=0){
			System.out.println("删除成功");
			return 1;
		}else{
			System.out.println("删除失败");
			return 0;
		}
	}

	public int UpdateCar(T_Car tCar) {
		// TODO Auto-generated method stub
		String sql="update t_car set C_Type=?,C_ID=? where C_ID=? ";
		String sql1="update t_user set U_Name=? ,U_Address=? ,U_Email=?, U_Tel=?,U_Time=? where C_ID=? ";
		 //System.out.println("车辆详情"+tCar.getC_ID()+"--"+tCar.getU_Name()+"--"+tCar.getC_Address()+"--"+tCar.getC_Name());
		int temp1=DB.executeNonQuery(sql,tCar.getC_Type(),tCar.getC_VIN(),tCar.getC_VIN());
		int temp2=DB.executeNonQuery(sql1,tCar.getU_Name(),tCar.getU_Address(),tCar.getU_Email(),tCar.getU_Tel(),new Timestamp(tCar.getU_Time().getTime()),tCar.getC_VIN());
		
		System.out.println("temp1的得值："+temp1+"temp2的值"+temp2);
		if(temp1!=0&&temp2!=0){
			System.out.println("更新成功");
			return 1;
		}else{
			System.out.println("更新失败");
			return 0;
		}
		
	}


	
	public T_Car CarInfo(String C_VIN) {
		// TODO Auto-generated method stub
		T_Car cars=new T_Car();
		String sql="select * from   t_car c ,t_user u where c.C_ID=u.C_ID  and  C_VIN=?";
		
		Result rs = DB.executeQuery_new(sql,C_VIN);
		
		if (rs != null && rs.getRowCount() != 0) {
			for (int i = 0; i < rs.getRowCount(); i++) {
				Map row = rs.getRows()[i];
				cars = new T_Car();
				cars.setC_VIN(Integer.parseInt(row.get("C_VIN").toString()));
				cars.setU_Name(String.valueOf(row.get("U_Name")));
				cars.setU_Address(String.valueOf(row.get("U_Address")));
				cars.setU_Tel(String.valueOf(row.get("U_Tel")));
				cars.setC_Type(String.valueOf(row.get("C_Type")));
				cars.setU_Email(String.valueOf(row.get("U_Email")));
				
			}
		}

		return cars;
   }



	@Override
	public List CarTypeCount() {
		// TODO Auto-generated method stub
		String sql="select C_Type ,count(*) as CarTypeCount  from t_car group by C_Type";
		Result rs = DB.executeQuery_new(sql);
		
		List countList=new ArrayList<T_Car>();
		
		int CarTypeCount = 0;
		String C_Type = null;
		if(rs!=null && rs.getRowCount()!=0) {  
			for (int i = 0; i < rs.getRowCount(); i++) {
				Map row = rs.getRows()[i];
				Map data = new LinkedHashMap<String, String>();
				 C_Type=String.valueOf(row.get("C_Type"));
				CarTypeCount=Integer.parseInt(row.get("CarTypeCount").toString());
				 //System.out.println(C_Type+"+++++++"+CarTypeCount );
				data.put("value",CarTypeCount);
				data.put("name", C_Type);
				countList.add(data);
				
			 }
			
			 return countList;
		}else {
	
			 return null;
       }
	}



	@Override
	public List CarStatusCount() {
		// TODO Auto-generated method stub
		
		String sql2="SELECT\r\n" + 
				"zk.c_type,zk.c_status, 0 AS CarStatusCount\r\n" + 
				"FROM\r\n" + 
				"(SELECT\r\n" + 
				"ad.C_Status,af.C_Type\r\n" + 
				"FROM\r\n" + 
				"(SELECT \r\n" + 
				"DISTINCT z.C_Status\r\n" + 
				"FROM\r\n" + 
				"(SELECT C_Type,C_Status,COUNT(*) AS CarStatusCount FROM t_c_status a, t_car b WHERE a.C_VIN=b.C_VIN GROUP BY a.C_Status,C_Type ORDER BY C_Type,C_Status) z) ad ,\r\n" + 
				"(SELECT \r\n" + 
				"DISTINCT zz.C_Type\r\n" + 
				"FROM\r\n" + 
				"(SELECT C_Type,C_Status,COUNT(*) AS CarStatusCount FROM t_c_status a, t_car b WHERE a.C_VIN=b.C_VIN GROUP BY a.C_Status,C_Type ORDER BY C_Type,C_Status) zz) af) zk WHERE zk.c_status \r\n" + 
				"NOT IN(SELECT \r\n" + 
				"DISTINCT z.C_Status\r\n" + 
				"FROM\r\n" + 
				"(SELECT C_Type,C_Status,COUNT(*) AS CarStatusCount FROM t_c_status a, t_car b WHERE a.C_VIN=b.C_VIN GROUP BY a.C_Status,C_Type ORDER BY C_Type,C_Status) z WHERE zk.c_type=z.c_type)\r\n" + 
				"UNION ALL\r\n" + 
				"SELECT C_Type,C_Status,COUNT(*) AS CarStatusCount FROM t_c_status a, t_car b WHERE a.C_VIN=b.C_VIN GROUP BY a.C_Status,C_Type ORDER BY C_Type,C_Status";
		String sql1="select distinct C_Type from t_c_status a, t_car b where a.C_VIN=b.C_VIN group by a.C_Status,C_Type order by C_Type";
		Result rs1 = DB.executeQuery_new(sql1);
		Result rs2 = DB.executeQuery_new(sql2);
		List statusList=new ArrayList<T_Car>();
		Object CarStatusCount = null;
		int C_Status = 0;
		String C_Type = null;
		 List list0=new ArrayList();
		 List list1=new ArrayList();
		 List list2=new ArrayList();
		 List list3=new ArrayList();
		 Map<String, List<String>> typeMap = new LinkedHashMap<String, List<String>>();
		 
		if(rs1!=null && rs1.getRowCount()!=0){  
			
			List<String> listCT= new ArrayList<String>();
			for (int i = 0; i < rs1.getRowCount(); i++) {
				Map row = rs1.getRows()[i];
				String str =  (String) row.get("C_Type");
				//System.out.println(str);
				listCT.add(str);
					
			 }
			typeMap.put("type", listCT);
			statusList.add(typeMap);
		 }
		
		
		Map<String, Map<String,List<Integer>>> Map = new LinkedHashMap<String,Map<String,List<Integer>>>();
		Map<String,List<Integer>> statusMap = new LinkedHashMap<String, List<Integer>>();
		if (rs2 != null && rs2.getRowCount() != 0) {
			
			for (int i = 0; i < rs2.getRowCount(); i++) {
				Map row = rs2.getRows()[i];
				
				C_Type = String.valueOf(row.get("C_Type"));
				C_Status = Integer.parseInt(row.get("C_Status").toString());
				CarStatusCount = row.get("CarStatusCount");
				//System.out.println("====="+C_Type+"===="+C_Status+"==============>"+row.get("CarStatusCount"));
					if(C_Status==0) {
						list0.add(CarStatusCount);
					}else if(C_Status==1) {
						list1.add(CarStatusCount);
					}else if(C_Status==2) {
						list2.add(CarStatusCount);
					}else if(C_Status==3) {
						list3.add(CarStatusCount);
					}												
		   }
			
			
			statusMap.put("stop",list0);
			statusMap.put("run",list1);
			statusMap.put("disfire",list2);
			statusMap.put("downline",list3);
			Map.put("count",statusMap );
			statusList.add(Map);
			
					return statusList;
				}else {
					return null;
				}
				
				
	       }
			
		
		
		
		
		

	  
}
