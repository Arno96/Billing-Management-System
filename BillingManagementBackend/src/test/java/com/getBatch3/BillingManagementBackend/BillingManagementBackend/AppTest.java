package com.getBatch3.BillingManagementBackend.BillingManagementBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.getBatch3.BillingManagementBackend.DBConfig.DBConfig;
import com.getBatch3.BillingManagementBackend.Daos.DeveloperDao;
import com.getBatch3.BillingManagementBackend.Daos.ProjectDao;
import com.getBatch3.BillingManagementBackend.Daos.RoleDao;
import com.getBatch3.BillingManagementBackend.models.Developer;
import com.getBatch3.BillingManagementBackend.models.Project;
import com.getBatch3.BillingManagementBackend.models.Role;



/**
 * Unit test for simple App.
 */
public class AppTest
{
	
	private static ProjectDao projectDao;
	private static RoleDao roleDao;
	private static DeveloperDao developerDao;
	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		context.refresh();
		
		projectDao=context.getBean("projectDao",ProjectDao.class);
		roleDao=context.getBean("roleDao",RoleDao.class);
		developerDao=context.getBean("developerDao",DeveloperDao.class);
	}
	
	@Test
	@Ignore
	public void getProjectByIdTest() {
		List<Project> obj=projectDao.getAllProject();
		assertNotNull("Project not available",obj);
		
	}
	
	@Test
	@Ignore
	public void getAllRole() {
		List<Role> obj=roleDao.getAllRole();
		assertNotNull("Project not available",obj);
		
	}
	
	@Test
	@Ignore
	public void getAllDeveloper() {
		List<Developer> obj=developerDao.getAllDeveloper();
		assertNotNull("Developer not available",obj);
		
	}

}
