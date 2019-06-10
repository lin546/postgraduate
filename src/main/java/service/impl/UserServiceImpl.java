package service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserMapper;
import model.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserMapper userDao;

	@Override
	public int addUser(User user) {
		Boolean isexist= existAccount(user.getAccount());
		if(isexist){
			return 1;
		}else{
			userDao.addUser(user);
			return 2;
		}
	}


	@Override
	public int login(String account, String password) {
		// 判断username是否存在
		boolean existAccount = existAccount(account);
		// 若username存在，验证密码
		if (existAccount) {
			User resUser = userDao.selectByAccount(account);
			if(resUser.getStatus()!=0){
				return 3;
			}
			if (resUser.getPassword().equals(password)) {
				return 2;
			}
			return 1;
		}
		return 0;
	}

	@Override
	public boolean existAccount(String account) {
		return userDao.existAccount(account) > 0;
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.selectByID(id);
	}

	@Override
	public int getUserCount() {
		return userDao.getUserCount();
	}

	@Override
	public boolean updateUserByID(User user) {
		return userDao.updateByID(user);
	}

	@Override
	public int deleteByID(int ID) {
		return userDao.deleteByID(ID);
	}

	@Override
	public User getUserByAccount(String account) {
		return userDao.selectByAccount(account);
	}

	@Override
	public ArrayList<User> allUser() {
		
		return userDao.allUser();
	}

	@Override
	public ArrayList<User> search(String keyword) {
		return userDao.search(keyword);
	}

}
