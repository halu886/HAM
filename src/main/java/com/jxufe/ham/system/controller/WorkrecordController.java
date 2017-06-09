package com.jxufe.ham.system.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxufe.ham.system.service.WorkrecordService;

@Controller
@RequestMapping("/workrecord")
public class WorkrecordController {
	
	private Log log = LogFactory.getLog(WorkrecordController.class);
	
	private final String IS_DO = "isDo";//操作结果
	
	private final String MSG = "msg";//成功信息
	
	private final String ERROR_MSG = "errorMsg";//操作失败信息
	
	@Autowired
	private WorkrecordService workrecordService;
	
	public WorkrecordController() {
		super();
	}
	
	@RequestMapping("/signIn")
	public @ResponseBody HashMap<String, Object> signIn(HttpServletRequest request){
		Integer employeeId = (Integer)SecurityUtils.getSubject().getPrincipal();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		boolean result = false;
		try {
			
			result = workrecordService.signIn(employeeId);
		} catch (Exception e) {
			log.error(e);
			hashMap.put(IS_DO, false);
			hashMap.put(ERROR_MSG, "签到失败");
		}
		if(result){
			hashMap.put(IS_DO, true);
			hashMap.put(MSG, "签到成功");
		}else {
			hashMap.put(IS_DO, false);
			hashMap.put(ERROR_MSG, "签到失败");
		}
		
		return hashMap;
	}
	
	
	
}
