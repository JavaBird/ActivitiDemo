package com.framework.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framework.core.action.BaseAction;

/**
 * <pre>
 * Copy right information:
 * Project:[xxxx]
 * JDK version used: 1.7
 * Description:[登录Action]
 * Modification history	:
 * date			ver.	author			what is modified
 * ---------	----	---------	---------------------------
 * 2015-04-13	1.0		zhangxh		          new
 * </pre>
 * 
 * @author zhangxh
 * @version 1.0
 */
@Controller
@RequestMapping("/admin/")
public class LoginAction  extends BaseAction{

	@RequestMapping("login")
	public String index(){
		
		return "";
				
	}
	
}
