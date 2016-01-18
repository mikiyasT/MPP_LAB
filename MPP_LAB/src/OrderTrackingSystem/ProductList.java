package OrderTrackingSystem;

import java.util.ArrayList;

public class ProductList {
	
	
	static ArrayList<IProduct> listOfProducts = new ArrayList<IProduct>();
	
	public static void addProduct(ArrayList<Product> p){
		
		for(int i = 0; i < p.size(); i++)
		listOfProducts.add(p.get(i));
	}
	
	public static void searchProduct(String pId){
		System.out.println("Search results : ");
		for(int i = 0; i < listOfProducts.size(); i++)
		{
			if(listOfProducts.get(i).getProductId().equals(pId))
			{
				System.out.println(listOfProducts.get(i));
				break;
			}
		}
			
	}
	
	
	public static void listProducts(){
		System.out.println("List of all products available");
		for(int i = 0; i < listOfProducts.size(); i++){
			System.out.println("[" + i + "] " + listOfProducts.get(i));
		}
		
	}
	
	public static void removeProduct(Product p){
		
	}

	public static Product findProduct(String id) {
		for(int i = 0; i < listOfProducts.size(); i++){
			if(id.equals(listOfProducts.get(i).getProductId()))
				return (Product)listOfProducts.get(i);
		}
		return null;
	}
}
