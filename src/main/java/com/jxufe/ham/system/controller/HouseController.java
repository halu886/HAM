package com.jxufe.ham.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.hibernate.sql.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxufe.ham.common.entity.PropertyFilter;
import com.jxufe.ham.system.entity.Employee;
import com.jxufe.ham.system.entity.House;
import com.jxufe.ham.system.service.HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	protected Logger logger = LoggerFactory.getLogger(HouseController.class);
	
	private final String ISDONE = "isDone";// 操作是否成功

	private final String MSG = "msg";// 操作成功信息

	private final String ERROR_MSG = "errorMsg";
	
	/**
	 * 
	* @Title: delete 
	* @Description:删
	* @param id
	 */
	@RequestMapping("/del")
	public @ResponseBody Map<String, Object> delete(Integer id){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			houseService.delete(id);
		} catch (Exception e) {
			logger.debug(e.getCause().getMessage());
			result.put(ISDONE, false);
			result.put(ERROR_MSG, "删除失败");
			return result;
		}
		result.put(ISDONE, true);
		result.put(MSG, "删除成功");
		return result;
	}
	
	@RequestMapping("/add")
	public @ResponseBody HashMap<String, Object> add(House house){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			Integer employeeId = (Integer)SecurityUtils.getSubject().getPrincipal();
			Employee employee = new Employee();
			employee.setEmployeeId(employeeId);
			house.setEmployee(employee);
			houseService.save(house);
		} catch (Exception e) {
			logger.error(e.getMessage());
			hashMap.put(ISDONE, false);
			hashMap.put(ERROR_MSG, "添加失败");
			return hashMap;
		}
		hashMap.put(ISDONE, true);
		hashMap.put(MSG, "添加成功");
		return hashMap;
	}
	
	@RequestMapping("/getHouseByEmployeeID")
	public @ResponseBody HashMap<String, Object> getHouseByEmployeeID(){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<House> houseList = null;
		try {
			Integer employeeId = (Integer)SecurityUtils.getSubject().getPrincipal();
			
			List<PropertyFilter> list = new ArrayList<PropertyFilter>();	
			houseList = houseService.search("from House house where house.employee.employeeId="+employeeId);
		} catch (Exception e) {
			logger.error(e.getMessage());
			hashMap.put(ISDONE, false);
			hashMap.put(ERROR_MSG, "查询失败");
			return hashMap;
		}
		System.out.println(houseList);
		hashMap.put("list", houseList);
		hashMap.put(ISDONE, true);
		hashMap.put(MSG, "添加成功");
		return hashMap;
	}

}
