package com.car.daoimpl;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.apache.log4j.Logger;




import com.car.daoimpl.OperatorDaoImpl;
import com.car.util.MD5Util;
import com.car.util.DBHelper;
import com.car.dao.OperatorDao;
import com.car.vo.T_Operator;

public class OperatorDaoImpl implements OperatorDao {
	private DBHelper DB;
	public OperatorDaoImpl() {
		DB=new DBHelper();
		
	}
	MD5Util MyMD5 = new MD5Util();
	private static Logger logger = Logger.getLogger(OperatorDaoImpl.class);
	
	@Override
	public T_Operator Login(String username, String password)  {
		// TODO Auto-generated method stub
		T_Operator operator = new T_Operator();
		String sql = "select * from t_operator where O_ID =?";
		Result rs;
		rs = DB.executeQuery_new(sql, username);
		if(rs!=null && rs.getRowCount()!=0){   
		        Map row = rs.getRows()[0]; 
	
				String opassword = MyMD5.convertMD5(row.get("O_Password").toString());
				System.out.println("你需要登入的密码MD5解析后为："+opassword);
				if (!password.equals(opassword)) {
					
				} else {
					operator.setO_ID(String.valueOf(row.get("O_ID")));
					operator.setO_Password(opassword);
					operator.setO_Name(String.valueOf(row.get("O_Name")));
					operator.setO_IDCard(String.valueOf(row.get("O_IDCard")));
					operator.setO_Department(String.valueOf(row.get("O_Department")));
					operator.setO_Address(String.valueOf(row.get("O_Address")));
					operator.setO_Tel(String.valueOf(row.get("O_Tel")));
					operator.setO_Memo(String.valueOf(row.get("O_Memo")));
					operator.setO_Time(Timestamp.valueOf(row.get("O_Time").toString()));
				}
			}
		
		return operator;
	}

}
