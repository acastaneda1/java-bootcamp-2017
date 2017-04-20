package FinalProject.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalProject.DAOImp.UserDAOImp;
import FinalProject.Entities.User;
import FinalProject.Services.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDAOImp userDao;
	
	public UserServiceImp() {
		userDao = new UserDAOImp();
	}
	
	public void setUserDAO(UserDAOImp userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public int createUser(User user) {
		return userDao.createUser(user);
		
	}

	@Override
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}
	
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public boolean logInUser(String email, String password) {
		return userDao.logInUser(email,password);
		
	}
	@Override
	public boolean logOutUser(User user) {
		return userDao.logOutUser(user);
		
	}
	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
		
	}

	@Override
	public boolean deleteUser(User user) {
		return userDao.deleteUser(user);
		
	}

}
