package com.jxufe.ham.system.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxufe.ham.system.entity.Task;
import com.jxufe.ham.system.service.TaskService;

@RequestMapping("/task")
@Controller
public class TaskController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String IS_DO = "isDo";
	
	private final String MSG = "msg";
	
	private final String ERROR_MSG = "errorMsg";
	
	@Autowired
	private TaskService taskService;
	
	
	@RequestMapping("/getTaskByEmployeeId")
	public @ResponseBody HashMap<String, Object> getTaskByEmployeeId(){
//		System.out.println("test");
		Integer employeeId = (Integer)SecurityUtils.getSubject().getPrincipal();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		List<Task> tasks = null;
		try {
			tasks = taskService.getTaskByEmployeeId(employeeId);
		} catch (Exception e) {
			logger.error("error"+e.getMessage());
			hashMap.put(IS_DO,false);
			hashMap.put(ERROR_MSG, "查询失败");
			return hashMap;
		}
		System.out.println(tasks);
		hashMap.put("list", tasks);
		hashMap.put(IS_DO, true);
		hashMap.put(MSG, "查询成功");
		return hashMap;
	}
}
