package com.iris.get19.pbms.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.DevAttendanceDao;
import com.iris.get19.pbms.dao.model.DevAttendance;






@Repository(value="devAttendanceDao")
@Transactional
public class DevAttendanceDaoImpl implements DevAttendanceDao {

	
	
	@Autowired
	SessionFactory sf;
	public boolean fillAttendance(DevAttendance de) {
		
		try
		{
			
			Session session=sf.getCurrentSession();
			session.persist(de);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public List<DevAttendance> viewAttendance() {
		try
		{
			
			Session session=sf.getCurrentSession();
			Query q=session.createQuery("from DevAttendance");
			
			return q.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}


		
		
	