package com.jxufe.ham.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jxufe.ham.service.WorkrecordService;

@Controller
@RequestMapping("/workrecord")
public class WorkrecordController {
	
	private Log log = LogFactory.getLog(WorkrecordController.class);
	
	@Autowired
	private WorkrecordService workrecordService;
	
	public WorkrecordController() {
		
	}
	
	
	
	
	
}