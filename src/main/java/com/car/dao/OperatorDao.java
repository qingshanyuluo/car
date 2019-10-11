package com.car.dao;

import com.car.vo.T_Operator;

public interface OperatorDao {
	public T_Operator Login(String username, String password) ;  //客服的登录
}
