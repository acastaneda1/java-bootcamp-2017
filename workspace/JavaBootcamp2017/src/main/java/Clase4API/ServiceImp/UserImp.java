package Clase4API.ServiceImp;

import java.util.LinkedList;

import Clase4API.Service.UserService;

public class UserImp implements UserService {

	private LinkedList<User> users = new LinkedList<User>();
	private String id;

	@Override
	public void createUser(User user) {
		users.add(user);
	}

	@Override
	public User getUser(String id, String name, String email, String password, int creditCardNumberUser) {
		return new User(id, name, email, password, creditCardNumberUser);
	}

	@Override
	public void updateUser(User user) {
		if (users.contains(user)) {
			users.remove(user);
			users.add(user);
		} else
			System.out.println("No existe el usuario aun, debe crearlo");
	}

	@Override
	public void deleteUser(User user) {
		if (users.contains(user)) {
			users.remove(user);
		} else
			System.out.println("No existe el usuario que desea eliminar");
	}
}
