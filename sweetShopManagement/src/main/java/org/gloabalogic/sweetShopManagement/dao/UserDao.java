package org.gloabalogic.sweetShopManagement.dao;

import java.util.List;

import org.gloabalogic.sweetShopManagement.entities.Users;

public interface UserDao {

	// methods we can use for the Users
	public int insertUserToDB(Users users);

	public Users verifyuserFromDB(String username, String password, boolean isAdminOrCustomer);

	public int deleteUserFromDB(int userId);

	public List<Users> getAllUsers();
}
