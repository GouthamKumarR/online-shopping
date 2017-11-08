package net.goutham.shoppingbackend.dao;

import java.util.List;

import net.goutham.shoppingbackend.dto.Category;

public interface CategoryDao {

	List<Category> list();
	Category get(int id);
}
