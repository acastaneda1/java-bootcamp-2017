package FinalProject.Services;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import FinalProject.DAOImp.UserDAOImp;
import FinalProject.Entities.User;
import FinalProject.ServiceImp.UserServiceImp;

@RunWith(EasyMockRunner.class)
public class UserServiceTest {

	@TestSubject
	UserServiceImp userService = new UserServiceImp();
	
	@Mock
	private UserDAOImp userDao;
	
	@Mock
	User user;
	
	@Mock
	LinkedList<User> users;
	
	@Before
	public void setUp() {
		userService = new UserServiceImp();
		userService.setUserDAO(userDao);
	}
	@Test
	public void whenWeCreateANewUserItReturnsIdUser() {

		expect(userDao.createUser(user)).andReturn(1).times(2);
		replay(userDao);

		int idUser = userService.createUser(user);
		assertEquals(idUser, 1);
	}

	@Test
	public void whenWeDeleteAnUserItReturnsTrue() {
		expect(userDao.deleteUser(user)).andReturn(true).times(2);
		replay(userDao);

		assertTrue(userService.deleteUser(user));
	}

	@Test
	public void whenWeGetAnUsersDaoGivesTheUserRelated() {
		expect(userDao.getUser(1)).andReturn(user).times(2);
		replay(userDao);

		User newUser = userService.getUser(1);
		assertEquals(newUser, user);
	}
	@Test
	public void whenWeGetAllUsersDaoGivesTheUserListRelated() {
		expect(userDao.getUsers()).andReturn(users).times(2);
		replay(userDao);

		List<User> newUser = userService.getUsers();
		assertEquals(newUser, users);
	}

	@Test
	public void whenWeUpdateAnUserItReturnsTrue() {

		expect(userDao.updateUser(user)).andReturn(true).times(2);
		replay(userDao);

		assertTrue(userService.updateUser(user));
	}
}
