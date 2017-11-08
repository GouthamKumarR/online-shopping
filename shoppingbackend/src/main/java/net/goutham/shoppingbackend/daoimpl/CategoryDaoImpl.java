package net.goutham.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.goutham.shoppingbackend.dao.CategoryDao;
import net.goutham.shoppingbackend.dto.Category;


@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	
	private static List<Category> categories = new ArrayList<>();
	
	static{
		Category category = new Category();
		
		category.setId(1);
		category.setName("Television");
		category.setDescription("in testing");
		category.setImageURL("CAT_1.png");
		category.setActive(true);
		categories.add(category);
		
		
category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("New Mobiles");
		category.setImageURL("CAT_2.png");
		category.setActive(false);
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("New Laptops");
		category.setImageURL("CAT_3.png");
		category.setActive(true);
		categories.add(category);
		
	}

	@Override
	public List<Category> list() {
		
		return categories;
	}

	@Override
	public Category get(int id) {

		for(Category category : categories) {
			if(category.getId() == id ) return category;
		}
		return null;
	}

}
