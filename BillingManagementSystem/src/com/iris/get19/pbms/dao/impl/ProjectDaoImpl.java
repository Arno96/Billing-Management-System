package com.iris.get19.pbms.dao.impl;


import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.get19.pbms.dao.ProjectDao;
import com.iris.get19.pbms.dao.model.Project;
import com.iris.get19.pbms.dao.model.ProjectAllocation;
import com.iris.get19.pbms.dao.model.ProjectConfiguration;


@Component
@Repository(value="projectDao")
@Transactional
public class ProjectDaoImpl implements ProjectDao{

	@Autowired
	private SessionFactory sessionFactory;//To get session factory from dbconfig.java file
	
	
	public List<Project> getAllProject() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from Project");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public Project getProjectById(String projectId)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Project c=session.get(Project.class, projectId);
			return c;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public boolean setProjectConfig(ProjectConfiguration obj) {
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
	public List<ProjectConfiguration> getAllProjectConfig() {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProjectConfiguration");
			return q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean setProjectAllocate(ProjectAllocation obj) {
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
	}


