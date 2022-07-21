package org.gloabalogic.sweetShopManagement.dao;

import java.util.List;

import org.gloabalogic.sweetShopManagement.entities.SweetCategory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

// In this class we have implemented all the methods defined for Sweet Category
public class SweetCategoryDaoImplementation implements SweetCategoryDao {

	// To connect with the database and execute SQL queries
	private JdbcTemplate jdbcTemplate;

	// Insert Query
	public int insertSweetCategory(SweetCategory sweetCategory) {
		String query = "insert into sweetCategory(sweetCategoryName) values (?);";
		int result = this.jdbcTemplate.update(query, sweetCategory.getSweetCategoryName());
		return result;
	}

	// Update Query
	public int updateSweetCategoryName(SweetCategory sweetCategory) {
		String query = "update sweetCategory set sweetCategoryName=? where sweetCategoryId = ? ; ";
		int result = this.jdbcTemplate.update(query, sweetCategory.getSweetCategoryName(),
				sweetCategory.getSweetCategoryId());
		return result;
	}

	// Delete Query
	public int deleteSweetCategory(int sweetCategoryId) {
		String query = "delete from sweetCategory where sweetCategoryId = ? ; ";
		int result = this.jdbcTemplate.update(query, sweetCategoryId);
		return result;
	}

	// Select query for a particular id
	public SweetCategory getSweetCategoryById(int sweetCategoryId) {
		String query = "select * from sweetCategory where sweetCategoryId = ?;";
		RowMapper<SweetCategory> rowMapper = new RowMapperImplementationForSweetCategory();
		SweetCategory sweetCategory = this.jdbcTemplate.queryForObject(query, rowMapper, sweetCategoryId);

		return sweetCategory;
	}

	// Select query to get all the sweet category
	public List<SweetCategory> getAllSweetCategory() {
		String query = "select * from sweetCategory;";
		List<SweetCategory> sweetCategories = this.jdbcTemplate.query(query,
				new RowMapperImplementationForSweetCategory());
		return sweetCategories;
	}

	// getter and setter for JdbcTemplate
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
