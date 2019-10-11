package com.car.bizimpl;

import com.car.biz.PasswordBiz;
import com.car.dao.PasswordDao;
import com.car.daoimpl.PasswordDaoImpl;

import com.car.vo.T_Operator;

public class PasswordBizImpl implements PasswordBiz {

	PasswordDao dao=new PasswordDaoImpl();

	@Override
	public T_Operator SelectOperator(String OID){
		return dao.SelectOperator(OID);
	}
	
	@Override
	public Boolean AlterOperatorPW(String OID,String PW){
		int temp=dao.AlterOperatorPW(OID, PW);
		if(temp>0){
			return true;
		}else{
			return false;
		}
	}

}
