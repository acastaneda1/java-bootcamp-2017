package FinalProject.DAO;

import java.util.List;

import FinalProject.Entities.User;

public interface UserDAO {

	public int createUser(String name, String email, String password, int creditCardNumberUser);

	public List<User> getUsers();

	public User getUser(int idUser);

	public void updateUser(User user);

	public void deleteUser(User user);
}
