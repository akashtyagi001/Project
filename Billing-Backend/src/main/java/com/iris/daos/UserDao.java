package com.iris.daos;

import com.iris.models.EmployeeLogin;


public interface UserDao {
	public EmployeeLogin validateUser(int userId, String password);
}
