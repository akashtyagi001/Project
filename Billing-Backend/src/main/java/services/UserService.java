package services;

import com.iris.models.EmployeeLogin;


public interface UserService {
	public EmployeeLogin validateUser(int userId, String password);
}
