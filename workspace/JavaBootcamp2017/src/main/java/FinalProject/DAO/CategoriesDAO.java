package FinalProject.DAO;

import Clase4API.Model.Item;
import FinalProject.Entities.Categories;

public interface CategoriesDAO {
	public void createCategory(Categories category);
	
	public void updateCategory(Categories category);
	
	//public Item getCategory(int idCategory);
	
	public void deleteCategory(Categories category);
}
