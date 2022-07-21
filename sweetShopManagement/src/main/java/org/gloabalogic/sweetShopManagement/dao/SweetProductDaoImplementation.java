package org.gloabalogic.sweetShopManagement.dao;

import java.util.List;

import org.gloabalogic.sweetShopManagement.entities.SweetProduct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//In this class we have implemented all the methods defined for Sweet Product
public class SweetProductDaoImplementation implements SweetProductDao {

	// To connect with the database and execute SQL queries
	private JdbcTemplate jdbcTemplate;

	// Insert Query
	public int insertSweetProduct(SweetProduct sweetProduct) {
		String query = "insert into sweetProduct(sweetProductName, sweetProductPrice, sweetProductDiscount, sweetProductFinalPrice) values (?,?,?,?);";

		int result = this.jdbcTemplate.update(query, sweetProduct.getSweetProductName(),
				sweetProduct.getSweetProductPrice(), sweetProduct.getSweetProductDiscount(),
				sweetProduct.getSweetProductFinalPrice());
		return result;
	}

	// Update Query
	public int updateSweetProductName(SweetProduct sweetProduct) {
		String query = "update sweetProduct set sweetProductName=? where sweetProductId = ? ; ";
		int result = this.jdbcTemplate.update(query, sweetProduct.getSweetProductName(),
				sweetProduct.getSweetProductId());
		return result;
	}

	// Delete Query
	public int deleteSweetProduct(int sweetProductId) {
		String query = "delete from sweetProduct where sweetProductId = ? ; ";
		int result = this.jdbcTemplate.update(query, sweetProductId);
		return result;
	}

	// Select query for a particular id
	public SweetProduct getSweetProductById(int sweetProductId) {
		String query = "select * from sweetProduct where sweetProductId = ?;";
		RowMapper<SweetProduct> rowMapper = new RowMapperImplementationForSweetProduct();
		SweetProduct sweetProduct = this.jdbcTemplate.queryForObject(query, rowMapper, sweetProductId);

		return sweetProduct;
	}

	// Select query to get all the sweet products
	public List<SweetProduct> getAllSweetProduct() {
		String query = "select * from sweetProduct;";
		List<SweetProduct> sweetProducts = this.jdbcTemplate.query(query, new RowMapperImplementationForSweetProduct());
		return sweetProducts;
	}

	// getter and setter for JdbcTemplate
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
