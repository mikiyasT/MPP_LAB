package Lab_3_package_delivery;

public class UPS_Delivery implements IDeliveryMeans{
	String Name;
	public UPS_Delivery(String name) {
		super();
		Name = name;
	}
	
	public double calculate_delivery_cost(double weight , String zone) {
		// TODO Auto-generated method stub
		return 0.45 * weight;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
