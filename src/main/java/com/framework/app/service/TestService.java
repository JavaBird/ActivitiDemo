package com.framework.app.service;

import org.springframework.stereotype.Service;

import com.framework.app.entity.TbUser;
import com.framework.core.service.BaseService;


@Service
public class TestService extends BaseService {

	public TbUser findById(int i) {
		
	String hql = "from TbUser where id = "+ i;
	
	TbUser tbUser = hibernateDao.executeWithUniqueResult(TbUser.class, hql);
		
		return tbUser;
	}

	
	
}
