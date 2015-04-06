package com.framework.core.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.RequestContext;

/**
 * <pre>
 * Copy right information:
 * Project:[xxxx]
 * JDK version used: 1.7
 * Description:[核心Action]
 * Modification history	:
 * date			ver.	author			what is modified
 * ---------	----	---------	---------------------------
 * 2015-04-06	1.0		zhangxh		          new
 * </pre>
 * 
 * @author zhangxh
 * @version 1.0
 */
@Controller
public class BaseAction {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected RequestContext requestContext = null;
	
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,HttpServletResponse response){
		this.request = request;
		this.response = response;
		requestContext = new RequestContext(request);
	}
	protected BaseAction() {}
	
	
	/**
	 * 获取所有参数
	 * @author zhangxiaohong 2015-04-06
	 * @return
	 */
	public Map<String,String> getAllParameters(){
		Map<String,String> map = new HashMap<String,String>();
				for(Enumeration<String>  emumers = request.getParameterNames(); emumers.hasMoreElements();){
					
					String paramName = emumers.nextElement();
					
					String paramValue = request.getParameter(paramName);
					if(null != paramValue){
						map.put(paramName, paramValue.trim());
					//	map.put(paramName,new String(paramValue.trim().getBytes("ISO-8859-1"), "utf-8"));
					}else{
						map.put(paramName, "".trim());
					//	map.put(paramName,new String("".trim().getBytes("ISO-8859-1"), "utf-8"));
					}
					
				}
				return map;
	}
	
	
}
