package Lab_3_package_delivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PackageDeliveryApplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ArrayList<IDeliveryMeans> availableShippers = new ArrayList();
		IDeliveryMeans UPS = new UPS_Delivery("UPS");
		IDeliveryMeans FEDEX = new Fedex_Delivery("FEDEX");
		IDeliveryMeans USMAIL = new USMail_Delivery("USMAIL");
		IDeliveryMeans DHL = new DHL_Delivery("DHL"); //adding DHL object to the list of carriers
		
		SendersCategory cat_student = new SendersCategory("STUDENT",0.10);
		SendersCategory cat_senior = new SendersCategory("SENIOR",0.15);//add new senders category below [e.g. minors]
		
		
		
		
		availableShippers.add(UPS);
		availableShippers.add(FEDEX);
		availableShippers.add(USMAIL);
		availableShippers.add(DHL); // extension by just adding DHL to list of carriers
		
		
		
		Package_toSend.setSendingMechanisms(availableShippers);
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many packages do you want send ? ");
		int number_of_packages = Integer.parseInt(br.readLine());
		
		
		ArrayList<Package_toSend> packages = new ArrayList<Package_toSend>();
		
		for(int i = 1 ; i <= number_of_packages;i++){
			System.out.println("Description for package " + i );
			String desc = br.readLine();
			System.out.println("Weght of package " + i );
			double wt = Double.parseDouble(br.readLine());
			System.out.println("Zone to send package " + i );
			String zn = br.readLine();
			Package_toSend p = new Package_toSend(desc, wt, zn);
			
			System.out.println("Senders cateogry (s for student, r for senior, v for veteran...)" );
			String cat = br.readLine();
			switch(cat.charAt(0)){
			case 's':
				p.category = cat_student;
				break;
			case 'r':
				p.category = cat_senior;
				break;
				
			}
			
			
			packages.add(p);
		}
		
		System.out.println("\n");
		System.out.println("List of items with cheapest shipping options");
		for(int i = 0 ; i < packages.size();i++){
			packages.get(i).getLowestPrice();
		}
		

	}

}
