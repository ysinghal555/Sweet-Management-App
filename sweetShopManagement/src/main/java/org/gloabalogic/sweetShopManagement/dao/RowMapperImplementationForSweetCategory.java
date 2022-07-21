package org.gloabalogic.sweetShopManagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.gloabalogic.sweetShopManagement.entities.SweetCategory;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperImplementationForSweetCategory implements RowMapper<SweetCategory> {

	// To get the mapping rows of a ResultSet on a per-row basis
	public SweetCategory mapRow(ResultSet rs, int rowNum) throws SQLException {

		SweetCategory sweetCategory = new SweetCategory();

		// it will be mapping rows in the order we defined in the POJO class.
		sweetCategory.setSweetCategoryId(rs.getInt(1));
		sweetCategory.setSweetCategoryName(rs.getString(2));

		return sweetCategory;

	}

}
