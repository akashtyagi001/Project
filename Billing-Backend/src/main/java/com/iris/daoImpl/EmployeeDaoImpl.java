
package com.iris.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.EmployeeDao;
import com.iris.models.Employee;

@Component
@Repository(value="employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{
		@Autowired
	    private SessionFactory sessionFactory;//To get session factory from dbconfig.java file
	     public List<Employee> getAllEmployee() {
		try {
	          Session session=sessionFactory.getCurrentSession();
	           Query q=session.createQuery("from com.iris.models.Employee");
	           if (q.list()!=null) {
	           System.out.println("Not null");
	            return q.list();
	             	} 
	           else    	
	             	{
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