package Lab_3_package_delivery;

public interface IDeliveryMeans {
	double calculate_delivery_cost(double weight , String zone);

	String getName();
	
}
