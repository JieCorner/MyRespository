package com.news.management.DAO;

import com.news.management.bean.User;

public interface UserDAO {
	public void add(User user);
	public boolean getUserByName(String username);
	public User LoginOfUserExist(String username,String password);
	public User getUserByID(int uid);
	public void UpdateUser(User user);
}
