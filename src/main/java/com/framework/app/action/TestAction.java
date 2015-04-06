package com.framework.app.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.app.entity.TbUser;
import com.framework.app.service.TestService;
import com.framework.core.action.BaseAction;



@Controller
public class TestAction extends BaseAction {

	@Autowired
	private TestService service;
	
	@RequestMapping("/test/index")
	public String index(){
		
		 TbUser tbUser = service.findById(1);
		
		return "testIndex";
	}
}
