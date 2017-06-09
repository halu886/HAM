package com.jxufe.ham.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxufe.ham.common.dao.HibernateDao;
import com.jxufe.ham.common.service.BaseService;
import com.jxufe.ham.system.dao.HouseDao;
import com.jxufe.ham.system.dao.HousekeyDao;
import com.jxufe.ham.system.entity.House;
import com.jxufe.ham.system.entity.Housekey;

@Service
public class HouseService extends BaseService<House, Integer>{

	@Autowired
	private HouseDao houseDao;
	
	@Autowired
	private HousekeyDao housekeyDao;
	
	@Override
	public HibernateDao<House, Integer> getEntityDao() {
		return this.houseDao;
	}
	
	@Override
	public void save(House entity) {
		if(entity.getRentStatue()){
			entity.setSaleStatue(false);
		}else if (entity.getSaleStatue()) {
			entity.setRentStatue(false);
		}
		Housekey housekey = new Housekey();
		housekey.setHousekeyStatue(false);
		Integer houseKeyId = housekeyDao.save(housekey);
		Housekey housekey2 = housekeyDao.find(2);
		entity.setHousekey(housekeyDao.find(houseKeyId));
		super.save(entity);
	}

	public List<House> search(String string,Object... values) {
		return houseDao.find(string, values);
	}
}
