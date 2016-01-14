package Lab_3_package_delivery;

public class Fedex_Delivery implements IDeliveryMeans{

	String Name; 
	
	public Fedex_Delivery(String name) {
		super();
		Name = name;
	}
	@Override
	public double calculate_delivery_cost(double weight , String zone) {
		if( zone.equals("IA") || zone.equals("MT") || zone.equals("CA"))
			return 0.35 * weight;
		else if( zone.equals("TX") || zone.equals("UT"))
			return 0.30 * weight;
		else if( zone.equals("FL") || zone.equals("OH"))
			return 0.55 * weight;
		else
			return 0.43 * weight;				
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

}
