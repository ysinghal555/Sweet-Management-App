package org.gloabalogic.sweetShopManagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.gloabalogic.sweetShopManagement.entities.SweetProduct;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperImplementationForSweetProduct implements RowMapper<SweetProduct> {

	// To get the mapping rows of a ResultSet on a per-row basis
	public SweetProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		SweetProduct sweetProduct = new SweetProduct();

		// it will be mapping rows in the order we defined in the POJO class.
		sweetProduct.setSweetProductId(rs.getInt(1));
		sweetProduct.setSweetProductName(rs.getString(2));
		sweetProduct.setSweetProductPrice(rs.getDouble(3));
		sweetProduct.setSweetProductDiscount(rs.getDouble(4));
		sweetProduct.setSweetProductFinalPrice(rs.getDouble(5));

		return sweetProduct;
	}

}
