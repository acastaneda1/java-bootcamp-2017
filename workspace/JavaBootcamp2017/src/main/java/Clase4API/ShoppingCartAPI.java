package Clase4API;

public interface ShoppingCartAPI {
	
	public void addItem(Item item);
	
	public void removeItem(Item item);
	
	public void getItems();
	
	public void resumeTotal();
	
	public void clearShoppingCart();
	
	public void buy();
}
