package com.car.daoimpl;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import org.apache.log4j.Logger;

import com.car.dao.PasswordDao;
import com.car.util.DBHelper;
import com.car.util.MD5Util;
import com.car.vo.T_Operator;

public class PasswordDaoImpl implements PasswordDao {

private DBHelper DB;
	
	public PasswordDaoImpl() {
		DB=new DBHelper();
		
	}
	
	private static Logger logger = Logger.getLogger(PasswordDaoImpl.class);
	
	@Override
	public T_Operator SelectOperator(String OID){
		T_Operator tOperator=new T_Operator();
		String sql = "select * from t_operator where O_ID =?";
		 Result rs;
			rs = DB.executeQuery_new(sql, OID);
			if(rs!=null && rs.getRowCount()!=0){
				MD5Util MyMD5=new MD5Util();
				Map row = rs.getRows()[0]; 
				String opassword=MyMD5.convertMD5(String.valueOf(row.get("O_Password")).trim());//MD5解密
				tOperator.setO_Password(opassword);
				tOperator.setO_ID(OID);
				tOperator.setO_Name(String.valueOf(row.get("O_Name")));
				tOperator.setO_IDCard(String.valueOf(row.get("O_IDCard")));
				tOperator.setO_Department(String.valueOf(row.get("O_Department")));
				tOperator.setO_Duty(String.valueOf(row.get("O_Duty")));
				tOperator.setO_Address(String.valueOf(row.get("O_Address")));
				tOperator.setO_Tel(String.valueOf(row.get("O_Tel")));
				tOperator.setO_Memo(String.valueOf(row.get("O_Memo")));
				
				tOperator.setO_Time(Timestamp.valueOf(String.valueOf(row.get("O_Time")).trim()));
			}
		return tOperator;
	}
	
	@Override
	public int AlterOperatorPW(String OID,String PW){
		// TODO Auto-generated method stub
	    MD5Util MyMD5=new MD5Util();
	    String sql = "update t_operator set O_Password=? where O_ID =?";
	    int temp=-1;
		temp=DB.executeNonQuery(sql,MyMD5.convertMD5(PW),OID);
		
		return temp;
	}

}
