package com.jxufe.ham.bean;

import java.util.Collection;

import com.jxufe.ham.bean.abstractBean.BaseBean;

public class Rolemanagement extends BaseBean{

	private static final long serialVersionUID = -6321765075213299243L;
	
	private int RolemanagementId;//角色控制编号
	
	private Role role;//角色
	
	private Employee employee;//用户
	
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getRolemanagementId() {
		return RolemanagementId;
	}

	public void setRolemanagementId(int rolemanagementId) {
		RolemanagementId = rolemanagementId;
	}
	
}
