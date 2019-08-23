package com.iris.get19.pbms.dao.impl;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.event.internal.DefaultPersistOnFlushEventListener;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.model.DataEntryOperator;
import com.iris.get19.pbms.dao.model.Developer;
import com.iris.get19.pbms.dao.model.ProjectAllocation;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;

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
			Query q=session.createQuery("from DataEntryOperator where devObj.developerId=:i and month=:m");
			q.setParameter("i",id);
			q.setParameter("m",month);
			
			List<DataEntryOperator> deoList=q.getResultList();
			if(deoList.size()!=0) {
				System.out.println("obj");
				return deoList.get(0);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	
	}

	@Override
	public List<ProjectAllocation> getAllAllocate() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProjectAllocation");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public ProjectAllocation getConfig(int id) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			String s= "from ProjectAllocation where devid=:x";
			Query<ProjectAllocation> q = session.createQuery(s);
			q.setParameter("x", id);
			List<ProjectAllocation> allProAllocation = q.list();
			if(allProAllocation.size()==0) {
				return null;
			}
			else {
			ProjectAllocation ProAllocation = (ProjectAllocation)allProAllocation.get(0);
			System.out.println(ProAllocation);
			return ProAllocation;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProjectAllocation getProAllocationObj(int id) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			System.out.println(id);
			String s= "from ProjectAllocation where configid=:x";
			Query<ProjectAllocation> q = session.createQuery(s);
			q.setParameter("x", id);
			List<ProjectAllocation> allProAllocation = q.list();
			if(allProAllocation.size()==0) {
				return null;
			}
			else {
			ProjectAllocation ProAllocation = (ProjectAllocation)allProAllocation.get(0);
			System.out.println(ProAllocation);
			return ProAllocation;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	

	
}
