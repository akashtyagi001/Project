package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;



import com.iris.daos.UserDao;

import com.iris.models.EmployeeLogin;

import services.UserService;


@Service("userService")

@Transactional

public class UserServiceImpl implements UserService {



	@Autowired
    UserDao userDaoObj;

	

	public EmployeeLogin validateUser(int Id, String password) {

		//some business logic...

		return userDaoObj.validateUser(Id, password);	

	}

	}



