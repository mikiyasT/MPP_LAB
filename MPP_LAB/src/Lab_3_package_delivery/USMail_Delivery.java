package Lab_3_package_delivery;

public class USMail_Delivery implements IDeliveryMeans{
	String Name;
	public USMail_Delivery(String name) {
		super();
		Name = name;
	}
	@Override
	public double calculate_delivery_cost(double weight , String zone) {
		if(weight <= 3)
			return 1;
		else
			return 0.55 * weight;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	

}
