package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	
	//Sabsa phla hum List method bana lenga- Kyoki sabsa phla huma backend project ko frontend sa connect karna hai.
	
	//List method create karenga jissa ke hum list of category return kara sake jo humare project ma hai.
	
	List<Category> list();
	
	//Ek naya DAO method add karenga CategoryDAO ma-
	//Fetch karna ka liya single category id ko base par
	//Phla humara return type Category hoga kyoki hum ek category return kara rahe hai get() ka through.
	
	Category get(int id); //Ya humara abstract method ban gya hai. Huma isa CategoryDAOImpl ma implement karna hai.

}
