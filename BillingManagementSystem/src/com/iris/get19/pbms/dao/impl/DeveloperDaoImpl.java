package com.iris.get19.pbms.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.model.DataEntryOperator;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.ProjectAllocation;

@Component
@Repository(value="developerDao")
@Transactional
public class DeveloperDaoImpl implements DeveloperDao {
	                                                                                              
	@Autowired
	private SessionFactory sessionFactory;//To get session factory from dbconfig.java file
	
	public List<Developer> getAllDeveloper() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from Developer");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public Developer getDeveloper(int id,String pass) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			System.out.println(id + pass);
			
			String s= "from Developer where id=:x and password=:y";
			Query<Developer> q = session.createQuery(s);
			q.setParameter("x", id);
			q.setParameter("y", pass);
			List<Developer> allDev = q.list();
			if(allDev.size()==0) {
				return null;
			}
			else {
			Developer dev = (Developer)allDev.get(0);
			return dev;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public boolean setProjectConfig(ProjectAllocation obj) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(obj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean setAttendance(DataEntryOperator obj) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(obj);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Developer> getAll() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from DataEntryOperator");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DataEntryOperator getBill(int id, String month) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from DataEntryOperator where devid=:i and month=:m");
			q.setParameter("i",id);
			q.setParameter("m",month);
			DataEntryOperator deo=new DataEntryOperator();
			deo = (DataEntryOperator)q.getParameterValue(0);
			return deo;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	
	}
}
