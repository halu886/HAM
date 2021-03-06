package com.jxufe.ham.authority.entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jxufe.ham.common.entity.BaseBean;

public class Function extends BaseBean{

	
	private static final long serialVersionUID = 4832132372549417852L;
	
	private int functionId;//权限过滤编号
	
	private String value;//过滤url
	
	private Authority authorityID;//权限
	
	private Role roleID;//角色
	
	private String type;//类型

	
	
	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Function(int functionId, String value, Authority authorityID, Role roleID, String type) {
		super();
		this.functionId = functionId;
		this.value = value;
		this.authorityID = authorityID;
		this.roleID = roleID;
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
//	public Authority getAuthority() {
//		return authority;
//	}
//	public void setAuthority(Authority authority) {
//		this.authority = authority;
//	}
	public Role getRoleID() {
		return roleID;
	}
	public void setRoleID(Role roleID) {
		this.roleID = roleID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	
	@OneToOne
    @JoinColumn(name = "authorityid")
	public Authority getAuthorityID() {
		return authorityID;
	}
	public void setAuthorityID(Authority authorityID) {
		this.authorityID = authorityID;
	}

	@Override
	public String toString() {
		return "Function [functionId=" + functionId + ", value=" + value + ", authorityID=" + authorityID + ", roleID="
				+ roleID + ", type=" + type + "]";
	}
	
}
