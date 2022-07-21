package org.gloabalogic.sweetShopManagement.dao;

import java.util.List;

import org.gloabalogic.sweetShopManagement.entities.SweetProduct;

public interface SweetProductDao {

	// methods we can use for the Sweet Products
	public int insertSweetProduct(SweetProduct sweetProduct);

	public int updateSweetProductName(SweetProduct sweetProduct);

	public int deleteSweetProduct(int sweetProductId);

	public SweetProduct getSweetProductById(int sweetProductId);

	public List<SweetProduct> getAllSweetProduct();
}
