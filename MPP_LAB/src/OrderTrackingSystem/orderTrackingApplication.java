package OrderTrackingSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class orderTrackingApplication {

	public static void main(String[] args) throws IOException {
		Customer P_Customer_miki = new PersonalCustomer("M123","Mikiyas");
		Customer C_Customer_dell = new CorporateCustomer("C123","DELL", Customer.CreditRating.GOOD, 1000);
		
		Product[] products = {
				 			  	new HealthCareProduct("H01",55,"Pain killer",50),
				 			  	new HealthCareProduct("H02",21,"Anti viral",40),
							  	new AudioVideoProduct("AV01", 100, "DVD", 20),
							  	new AudioVideoProduct("AV02", 100, "Movie CD", 10),
							  	new FoodProduct("F01", 10, "Packed tuna", 25)
				 			  };
		
		ArrayList<Product> P_list = new ArrayList<Product>();
		for(int i = 0; i < products.length;i++)
			P_list.add(products[i]);
		

		
		ProductList.addProduct(P_list);
		
		System.out.println("WELCOME TO AN AUTOMATED ORDERING AND TRACKING SYSTEM");
		while(true)
		{
			System.out.println("-------------- M E N U --------------------");
			System.out.println("[S]earch Product");			
			System.out.println("[L]ist all Products");			
			System.out.println("[A]dd to shopping cart");			
			System.out.println("[M]ake Payment");
			System.out.println("[C]my Cart");
			System.out.println("[P]Place order");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String selection = in.readLine().toString();
			System.out.println("--------------------------------------------");
			switch(selection.charAt(0))
			{
				
				case 'S' :
					System.out.println("Enter the product Id : ");
					String _id = in.readLine().toString();
					ProductList.searchProduct(_id);
					break;
				case 'L' :
					ProductList.listProducts();
					break;
				case 'A' :
					System.out.println("Adding to Shopping cart");
					System.out.println("Enter the product Id : ");
					String id = in.readLine().toString();
					Product p = ProductList.findProduct(id);
					System.out.println("How many of this product : ");
					String qty = in.readLine().toString();
					int qt = Integer.parseInt(qty);
					P_Customer_miki.addToShoppingCart(p,qt);
					break;
				case 'C' :
					P_Customer_miki.myCart();
					break;
				case 'P':
					P_Customer_miki.placeOrder();
					break;
				case 'M' :
					P_Customer_miki.makePayment();
					break;
			
			}	

		}
		
		

	}

}
