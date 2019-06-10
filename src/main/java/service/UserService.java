package service;

import java.util.ArrayList;

import model.User;

public interface UserService {

	/**
	 * 用户注册
	 */
	public int addUser(User user);

	/**
	 * 登录验证
	 */
	public int login(String account, String password);

	/**
	 * 检查account是否存在
	 * 
	 * @param account
	 * @return
	 */
	public boolean existAccount(String account);

	/**
	 * 获取用户信息
	 * 
	 * @param account
	 * @return
	 */
	public User getUserByAccount(String account);

	/**
	 * 获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);

	/**
	 * 获取用户数
	 */
	public int getUserCount();

	ArrayList<User> allUser();

	ArrayList<User> search(String keyword);


	public int deleteByID(int ID);

	boolean updateUserByID(User user);
}
