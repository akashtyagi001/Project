package com.iris.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.UserDao;
import com.iris.models.EmployeeLogin;
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
 
	@Autowired
	private SessionFactory sessionFactory;

	public EmployeeLogin validateUser(int userId, String password) {
		try {
		Session session=sessionFactory.getCurrentSession();
		EmployeeLogin EmplObj=session.get(EmployeeLogin.class,userId);
		
		
		if(EmplObj!=null){
			if(EmplObj.getPassword().equals(password)){
				return EmplObj;
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	


}
