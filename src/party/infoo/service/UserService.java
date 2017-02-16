package party.infoo.service;

import java.util.List;

import party.infoo.model.User;

/**
 * 
 * @author infoo
 *
 */
public interface UserService {
	public void saveUser(User user);

	public void updateUser(User user);

	public User findUserById(int id);

	public void deleteUser(User user);
	public void deleteUserById(User user,int userId);

	public List<User> findAllUsers();

	public User login(User user);
}
