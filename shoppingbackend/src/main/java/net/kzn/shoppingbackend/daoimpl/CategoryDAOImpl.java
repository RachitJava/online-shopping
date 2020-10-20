package net.kzn.shoppingbackend.daoimpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

//Ab hum kuch dummy data karna karenga static list ma 
//testing purpose ka liya jo baad ma hum replace kar denga access karna ka liya records ko database ma

//Spring IOC ko batana ka liya ke humara CategoryDAOImpl ko manage karna ka liya @Repository annotation ka use karenga- 
//Ya annotation data ka access provide karata hai- Spring Framework isko manage karta hai.

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	
	
	
	private static List<Category> categories= new ArrayList();
	
	static {
		
		Category category1 = new Category();
		Category category2 = new Category();
		Category category3 = new Category();
		//Adding First Category
		
		//Hum setter method use karenga
		
		category1.setId(1);
		category1.setName("Television");
		category1.setDescription("This is some description for Television");
		category1.setImageURL("CAT_1.png");
		
		categories.add(category1);
		
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("This is some description for Mobile");
		category2.setImageURL("CAT_2.png");
		
		categories.add(category2);
		
		
		category3.setId(3);
		category3.setName("Laptop");
		category3.setDescription("This is some description for Laptop");
		category3.setImageURL("CAT_3.png");
		
		categories.add(category3);
		

}
	
	public List<Category> list() {
		
		return categories;
	}
   
	//Huma category ko get karna hai aur return karna hai id ko base par
	public Category get(int id) {
		//Hum simply enhanced for loop use karenga
		
	for(Category category: categories) {
		//For each Category in categories- Ya humara collection
		
		if(category.getId()==id) return category;
	}
		return null;
		//Agar koi category nhi milage with particular id toh ya null value return karega. 
	}
	
	//Ya list of category ko return karega jo iss categories ma hai- jo ke humara ArrayList ke hai.
	
}
