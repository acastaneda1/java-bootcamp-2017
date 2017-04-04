package Clase4API.Service;

import Clase4API.ServiceImp.User;

public interface UserService {
	
	/* This method create an new User*/
	public void createUser(User user);
	
	/* This method return an object type User*/
	public User getUser(String id, String name, String email, String password, int creditCardNumberUser);
	
	/* This method receive an object type User and change its attributes */
	public void updateUser(User user);
	
	/* This method receive an object type User and is deleted */
	public void deleteUser(User user);

}
