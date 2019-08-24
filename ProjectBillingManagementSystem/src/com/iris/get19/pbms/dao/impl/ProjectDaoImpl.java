package com.iris.get19.pbms.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.ProjectDao;
import com.iris.get19.pbms.dao.model.Project;

@Repository(value="projectDao")
@Transactional
public class ProjectDaoImpl implements ProjectDao {

		@Autowired
		SessionFactory sf;
	
		
		public List<Project> viewProject() {
		try {
		Session session=sf.getCurrentSession();
		Query q=session.createQuery("From Project");
		
		return q.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return null;
		
	}
	public Project getProjectById(int id) {
		try {
			Session session=sf.getCurrentSession();
			Project p=session.get(Project.class,id);
			return p;
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

	
	
}
