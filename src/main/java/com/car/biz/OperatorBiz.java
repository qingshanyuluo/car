package com.car.biz;

import com.car.vo.T_Operator;

public interface OperatorBiz {
	public T_Operator Login(String username, String password);    //客服登录
}
