package com.getBatch3.BillingManagementBackend.Daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.getBatch3.BillingManagementBackend.models.Role;

@Component
@Repository(value="roleDao")
@Transactional
public class RoleDaoImpl implements RoleDao{
	@Autowired
	private SessionFactory sessionFactory;//To get session factory from dbconfig.java file
	public List<Role> getAllRole() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from Role");
			if (q.getResultList()!=null) {
				System.out.println("Not null");
				return q.list();
			} else {
				System.out.println("Null");
				return null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
