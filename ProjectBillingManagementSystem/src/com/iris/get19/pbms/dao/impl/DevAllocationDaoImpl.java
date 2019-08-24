package com.iris.get19.pbms.dao.impl;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.DevAllocationDao;
import com.iris.get19.pbms.dao.model.DevAllocation;






@Repository(value="devAllocationDao")
@Transactional
public class DevAllocationDaoImpl implements DevAllocationDao,Serializable {

	@Autowired
	SessionFactory sf;
	
	public boolean allocateDeveloper(DevAllocation da) {
		try {
			Session session=sf.getCurrentSession();
			session.persist(da);
			
		} 
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}



}
