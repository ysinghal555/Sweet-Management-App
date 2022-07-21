package org.gloabalogic.sweetShopManagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.gloabalogic.sweetShopManagement.entities.Users;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperImplementationForUsers implements RowMapper<Users> {

	// To get the mapping rows of a ResultSet on a per-row basis
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();

		// it will be mapping rows in the order we defined in the POJO class.
		users.setId(rs.getInt(1));
		users.setUsername(rs.getString(2));
		users.setPassword(rs.getString(3));
		users.setIsAdminOrCustomer(rs.getBoolean(4));

		return users;
	}

}
