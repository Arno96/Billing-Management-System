package com.iris.get19.pbms.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.get19.pbms.dao.DeveloperDao;
import com.iris.get19.pbms.dao.model.Developer;

@Repository(value="developerDao")
@Transactional
public class DeveloperDaoImpl implements DeveloperDao{
	@Autowired
	SessionFactory sf;
	public List<Developer> viewDeveloper() {
		try {
			
		Session session=sf.getCurrentSession();
		Query<Developer> q=session.createQuery("from Developer");
		
		return q.getResultList();
		
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
	


	public Developer getDeveloperById(int id) {
		try {
			Session session=sf.getCurrentSession();
			Developer d=session.get(Developer.class,id);
			return d;
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}



	public boolean validateDeveloper(int id, String password) {
		try {
			System.out.println(id+" and password = "+password);
			
			Session session=sf.getCurrentSession();
			Developer d=session.get(Developer.class,id);
			System.out.println(d);
			
			if(d.getPassword().equals(password)) {
				
				System.out.println("inside admin");
				return true;
				
			}
			else
				return false;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	

}
