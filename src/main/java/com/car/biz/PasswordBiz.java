package com.car.biz;


import com.car.vo.T_Operator;

public interface PasswordBiz {
	
	public T_Operator SelectOperator(String OID);
	public Boolean AlterOperatorPW(String OID, String PW);
}
