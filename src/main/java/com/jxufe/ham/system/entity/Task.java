package com.jxufe.ham.system.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jxufe.ham.common.entity.BaseBean;

/**
 * @Description: 
 * @ClassName: Task
 * @author hongch
 * @date 2017年3月23日 下午4:35:42
 */
public class Task extends BaseBean {

	//序列化ID
	private static final long serialVersionUID = 423611441373822314L;
	
	private int taskId;//任务编号
	
	private Date planDo;//计划完成时间
	
	private Date publishDate;//发布时间
	
	private boolean taskStatue;//任务状态
	
	private Integer taskLevel;//任务优先级
	
	private String taskInfo;//任务详情
	
	@JsonIgnore
	private Set<Taskmanagement> taskmanagements = new HashSet<Taskmanagement>(0);
	

	public Task() {
		super();
	}

	public Task(int taskId, Date planDo, Date publishDate, boolean taskStatue) {
		super();
		this.taskId = taskId;
		this.planDo = planDo;
		this.publishDate = publishDate;
		this.taskStatue = taskStatue;
	}

	public Task(int taskId, Taskmanagement taskmanagement, Date planDo, Date publishDate, boolean taskStatue, Integer taskLevel,
			String taskInfo, Set<Taskmanagement> taskmanagements) {
		super();
		this.taskId = taskId;
		this.taskmanagements = taskmanagements;
		this.planDo = planDo;
		this.publishDate = publishDate;
		this.taskStatue = taskStatue;
		this.taskLevel = taskLevel;
		this.taskInfo = taskInfo;
		this.taskmanagements = taskmanagements;
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Date getPlanDo() {
		return this.planDo;
	}

	public void setPlanDo(Date planDo) {
		this.planDo = planDo;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public boolean getTaskStatue() {
		return this.taskStatue;
	}

	public void setTaskStatue(boolean taskStatue) {
		this.taskStatue = taskStatue;
	}

	public Integer getTaskLevel() {
		return this.taskLevel;
	}

	public void setTaskLevel(Integer taskLevel) {
		this.taskLevel = taskLevel;
	}

	public String getTaskInfo() {
		return this.taskInfo;
	}

	public void setTaskInfo(String taskInfo) {
		this.taskInfo = taskInfo;
	}
	
	
	public Set<Taskmanagement> getTaskmanagements() {
		return taskmanagements;
	}

	public void setTaskmanagements(Set<Taskmanagement> taskmanagements) {
		this.taskmanagements = taskmanagements;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", planDo=" + planDo + ", publishDate=" + publishDate + ", taskStatue="
				+ taskStatue + ", taskLevel=" + taskLevel + ", taskInfo=" + taskInfo + "]";
	}


	
}
