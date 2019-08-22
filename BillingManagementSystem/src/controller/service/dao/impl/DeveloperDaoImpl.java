package controller.service.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import controller.service.dao.model.*;

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
			String s= "from Developer where Dev_Id=:x and Password=:y";
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
}
