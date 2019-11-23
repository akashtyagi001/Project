package com.iris.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.ProjectDao;
import com.iris.models.Project;
import com.iris.models.ProjectAllocation;
import com.iris.models.ProjectConfiguration;
@Component
@Repository(value="projectDao")
@Transactional
public class ProjectDaoImpl implements ProjectDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Project> getAllProject() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.iris.models.Project");
			if (q.list()!=null) {
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
	public List<ProjectConfiguration> getAllProjectConfig() {
			try {
				Session session=sessionFactory.getCurrentSession();
				Query q=session.createQuery("from com.iris.models.ProjectConfiguration");
				if (q.list()!=null) {
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


	public Project getProjectById(int projectId)

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
	public boolean setProjectConfig(ProjectConfiguration pObj1) {
		try
{
			Session session=sessionFactory.getCurrentSession();
			 Query q=session.createQuery("from com.iris.models.ProjectConfiguration where ProjectId=:projectId and RoleId=:roleId and Loc=:location");
			 q.setParameter("projectId",pObj1.getProjObj());
			   q.setParameter("roleId",pObj1.getRoleObj());
			   q.setParameter("location",pObj1.getLocation());
			   if(q.list().size()==0) {
			    session.save(pObj1);
			    return true;
			   }
			   
}
 catch(Exception e)
 {
  e.printStackTrace();
 }
return false;
	}
	
	
	public ProjectConfiguration getProjectConfig(int id) {
	try
		{
			Session session=sessionFactory.getCurrentSession();
			ProjectConfiguration p = session.get(ProjectConfiguration.class, id);
			return p;
		}
		catch(Exception e)
		{
e.printStackTrace();
		}
		return null;
	}
	
	
	public List<ProjectConfiguration> validateProject(int projectId, int roleId, String location) {
		try {

			Session session=sessionFactory.getCurrentSession();
	Query q=session.createQuery("from com.get.ProjectConfiguration where ProjectId=:projectId and RoleId=:roleId and loc=:location");
        q.setParameter("projectId",projectId);
	   q.setParameter("roleId",roleId);
           q.setParameter("location",location);
             	return q.list();
		}
         catch(Exception e)
            	{
              	e.printStackTrace();

		}

		return null;

	}
	public List<ProjectAllocation> setProjectAllocation() {
		// TODO Auto-generated method stub
		return null;
	}


}
