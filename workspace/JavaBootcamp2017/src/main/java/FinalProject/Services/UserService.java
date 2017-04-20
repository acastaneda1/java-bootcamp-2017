package FinalProject.Services;

import java.util.List;

import FinalProject.Entities.User;

public interface UserService {

	/* This method create an new User */
	public int createUser(User user);

	/* This method return an object type User */
	public User getUser(int userId);

	/* This method return a object list type User */
	public List<User> getUsers();

	/*
	 * This method return true if the user password and user email are the same
	 * that are saved public boolean
	 */
	public boolean logInUser(String email, String password);

	/*
	 * This method return true if the user has left or log out of the session
	 */
	public boolean logOutUser(User user);

	/*
	 * This method receive an object type User and change its attributes
	 */
	public boolean updateUser(User user);

	/* This method receive an object type User and is deleted */
	public boolean deleteUser(User user);

}
