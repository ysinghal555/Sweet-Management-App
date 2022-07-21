package org.gloabalogic.sweetShopManagement.dao;

import java.util.List;

import org.gloabalogic.sweetShopManagement.entities.SweetCategory;

public interface SweetCategoryDao {

	// methods we can use for the Sweet Category
	public int insertSweetCategory(SweetCategory sweetCategory);

	public int updateSweetCategoryName(SweetCategory sweetCategory);

	public int deleteSweetCategory(int sweetCategoryId);

	public SweetCategory getSweetCategoryById(int sweetCategoryId);

	public List<SweetCategory> getAllSweetCategory();
}
