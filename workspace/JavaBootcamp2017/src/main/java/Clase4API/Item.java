package Clase4API;

public class Item {

		private String id;
		private int price;
		private String description;
		
		public Item(String itemId, int itemPrice, String itemDescription){
			id = itemId;
			price = itemPrice;
			description = itemDescription;
		}
		
		public void setItemId(String newValue){
			id = newValue;
		}
		
		public String getItemId(){
			return id;
		}
		
		public void setItemPrice(int newValue){
			price = newValue;
		}
		
		public int getItemPrice(){
			return price;
		}
		
		public void setItemDescription(String newValue){
			description = newValue;
		}
		
		public String getItemDescription(){
			return description;
		}
}
