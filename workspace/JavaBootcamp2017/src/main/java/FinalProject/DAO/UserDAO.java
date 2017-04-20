package FinalProject.DAO;

import java.util.List;

import FinalProject.Entities.User;

public interface UserDAO {

	public int createUser(User user1);

	public List<User> getUsers();

	public User getUser(int idUser);
	
	public boolean logInUser(String email,String password);
	
	public boolean logOutUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);
}
