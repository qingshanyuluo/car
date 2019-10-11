package com.car.dao;

import com.car.vo.T_Operator;



public interface PasswordDao {


	public T_Operator SelectOperator(String OID);
	public int AlterOperatorPW(String OID, String PW);
}
