package com.jxufe.ham.system.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jxufe.ham.common.dao.HibernateDao;
import com.jxufe.ham.common.entity.PropertyFilter;
import com.jxufe.ham.common.service.BaseService;
import com.jxufe.ham.system.dao.TaskAllotDao;
import com.jxufe.ham.system.dao.TaskDao;
import com.jxufe.ham.system.entity.Employee;
import com.jxufe.ham.system.entity.Task;
import com.jxufe.ham.system.entity.Taskmanagement;

@Service
public class TaskService extends BaseService<Task, Integer>{

	@Autowired
	private TaskDao taskDao;
	
	@Autowired
	private TaskAllotDao taskAllotdao;
	
	@Override
	public HibernateDao<Task, Integer> getEntityDao() {
		return taskDao;
	}

	public List<Task> getTaskByEmployeeId(Integer employeeId) {
		List<PropertyFilter> propertyFilters = new ArrayList<PropertyFilter>();
//		propertyFilters.add(new PropertyFilter("EQI_employeeID",employeeId.toString()));
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		List<Taskmanagement> taskmanagements = taskAllotdao.findBy("employee", employee);
//		System.out.println(taskmanagements);
		List<Integer> taskIds = new ArrayList<Integer>();
		for (Iterator iterator = taskmanagements.iterator(); iterator.hasNext();) {
			Taskmanagement taskmanagement = (Taskmanagement) iterator.next();
			taskIds.add(taskmanagement.getTask().getTaskId());
		}
		List<Task> tasks = taskDao.find(taskIds);
		return tasks;
	}
	
}
