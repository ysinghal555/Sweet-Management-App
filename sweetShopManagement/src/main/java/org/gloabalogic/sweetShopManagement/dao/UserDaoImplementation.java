package org.gloabalogic.sweetShopManagement.dao;

import java.util.List;

import org.gloabalogic.sweetShopManagement.entities.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//In this class we have implemented all the methods defined for Users
public class UserDaoImplementation implements UserDao {

	// To connect with the database and execute SQL queries
	private JdbcTemplate jdbcTemplate;

	// Insert Query
	public int insertUserToDB(Users users) {
		String query = "insert into users(userName, userPassword, isAdminOrCustomer) values (?,?,?);";
		int result = this.jdbcTemplate.update(query, users.getUsername(), users.getPassword(),
				users.getIsAdminOrCustomer());
		return result;
	}

	// Get the user from the database with username, password and isAdminOrCustomer
	public Users verifyuserFromDB(String username, String password, boolean isAdminOrCustomer) {
		String query = "select * from users where userName = ? AND userPassword = ? AND isAdminOrCustomer =?;";
		RowMapper<Users> rowMapper = new RowMapperImplementationForUsers();
		Users users = this.jdbcTemplate.queryForObject(query, rowMapper, username, password, isAdminOrCustomer);

		return users;
	}

	// delete the user from the database
	public int deleteUserFromDB(int userId) {
		String query = "delete from users where id = ? ; ";
		int result = this.jdbcTemplate.update(query, userId);
		return result;
	}

	// see all the users present in the database
	public List<Users> getAllUsers() {
		String query = "select * from users;";
		List<Users> users = this.jdbcTemplate.query(query, new RowMapperImplementationForUsers());
		return users;
	}

	// getter and setter for JdbcTemplate
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
