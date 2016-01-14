package Lab_3_package_delivery;

public class DHL_Delivery implements IDeliveryMeans{
	String Name;
	public DHL_Delivery(String name) {
		super();
		Name = name;
	}
	@Override
	public double calculate_delivery_cost(double weight , String zone) {
		//assume the rate for DHL is 0.4 * wieght
		return 0.4 * weight;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
