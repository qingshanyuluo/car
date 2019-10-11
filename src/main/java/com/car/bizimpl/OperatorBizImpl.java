package com.car.bizimpl;

import com.car.biz.OperatorBiz;
import com.car.dao.OperatorDao;
import com.car.daoimpl.OperatorDaoImpl;
import com.car.vo.T_Operator;

public class OperatorBizImpl implements OperatorBiz {
	OperatorDao dao =new OperatorDaoImpl();

	@Override
	public T_Operator Login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.Login(username, password);
	}

}
