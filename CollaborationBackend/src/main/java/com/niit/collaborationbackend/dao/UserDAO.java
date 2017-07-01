package com.niit.collaborationbackend.dao;

import java.util.List;

import com.niit.collaborationbackend.model.User;

public interface UserDAO {
	public List<User> list();

	public User get(int userId);

	public User getbyUsername(String email_id);

	public User create(User user);

	public void delete(int userId);

	public User update(User user);
}
