package com.surya.dao;

import com.surya.model.User;

public interface UserDao {

	boolean addUser(User user);
	boolean isValidUser(String role, String email, String password);
}