package party.infoo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import party.infoo.dao.BaseDao;
import party.infoo.model.User;
import party.infoo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private BaseDao<User> baseDao;

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		baseDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		baseDao.update(user);
	}

	@Override
	public User findUserById(int id) {
		return baseDao.get(User.class, id);
	}

	@Override
	public void deleteUser(User user) {
		baseDao.delete(user);
	}

	@Override
	public void deleteUserById(User user, int userId) {
          baseDao.delete(user,userId);
	}

	@Override
	public List<User> findAllUsers() {
		return baseDao.find("from User");
	}

	@Override
	public User login(User user) {
		return baseDao.get("from User u where u.userName=? and u.userPassword=?", new Object[]{user.getUserName(),user.getUserPassword()});
	}


}
