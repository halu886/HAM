package com.jxufe.ham.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jxufe.ham.bean.Followup;
import com.jxufe.ham.bean.Log;
import com.jxufe.ham.dao.BaseDao;
import com.jxufe.ham.dao.FollowupDao;

@Repository
public class FollowupDaoImpl extends  FollowupDao<Followup> {
	
	@Autowired
	private SessionFactory sessionFactory;
    
    public Session getSession()  
    {  
        return sessionFactory.getCurrentSession();  
    } 
	/*
	 * 
	* Title: insert
	* Description: 
	* @param bean
	* @return
	* @see com.jxufe.ham.test.dao.FollowupDao#insert(com.jxufe.ham.bean.Followup)
	 */
	@Override
	public int insert(Followup bean) {
		return (Integer) getSession().save(bean);
	}

	@Override
	public void delete(Followup bean) {
		getSession().delete(bean);
	}


	@Override
	public Followup select(int id) {
		Session session = getSession();
		Followup list = (Followup) session.get(Followup.class, new Integer(id));		
		return list;
	}

	@Override
	public void update(Followup bean) {
		Session session = getSession();
		Transaction transaction = session.getTransaction();
		session.update(bean);
		transaction.commit();
	}

	@Override
	public List<Followup> queryForPage(String hql, int offset, int length) {
		return null;
	}

	@Override
	public int getCount(String hql) {
		return 0;
	}

	

	

}
