package com.framework.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.RequestContext;

import com.framework.core.dao.BaseDao;

/**
 * <pre>
 * Copy right information:
 * Project:
 * File Name:BaseService.java
 * JDK version used: 1.7
 * Commends:
 *
 * 业务模块基类
 * Modification history	:
 * date			ver.	author			what is modified
 * ---------	----	---------	---------------------------
 * 20154-4-6	1.0		zhangxh		 new
 * </pre>
 * 
 * @author zhangxh
 * @version 1.0
 */
@Service
public class BaseService {
    
	@Autowired
	protected BaseDao hibernateDao;
}
