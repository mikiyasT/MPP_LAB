package Lab_3_package_delivery;

import java.util.ArrayList;

public class Package_toSend {
	String description;
	double weight;
	String zone;
	static ArrayList<IDeliveryMeans> sendingMechanisms;
	
	SendersCategory category; // made this final,?? to show [composition] . Assuming a sender will always have a category for discounts(student,senior)
	
	
	Package_toSend(){
		category = null;
	}
	Package_toSend(String desc, double wt, String zn){
		description = desc;
		weight = wt;
		zone = zn;
		category = null;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getZone() {
		return zone;
	}

	public static ArrayList<IDeliveryMeans> getSendingMechanisms() {
		return sendingMechanisms;
	}
	public static void setSendingMechanisms(
			ArrayList<IDeliveryMeans> sendingMechanisms) {
		Package_toSend.sendingMechanisms = sendingMechanisms;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}

	public void addSendingMechanism(IDeliveryMeans d){
		sendingMechanisms.add(d);
	}
	
	public void getLowestPrice(){
		double min_sending_price = 1000000;
		int min_sender_index = -1;
		for(int i = 0; i < sendingMechanisms.size();i++){
			double sending_price = sendingMechanisms.get(i).calculate_delivery_cost(weight, zone);
			if(sending_price < min_sending_price){
				min_sending_price = sending_price;
				min_sender_index = i;
			}
		}
		System.out.format(" Before discount : %s \t $%,.2f \t%s \n", description,min_sending_price ,sendingMechanisms.get(min_sender_index).getName());		
		System.out.format(" After discount  : %s \t $%,.2f \t%s \n", description,min_sending_price - min_sending_price * category.getDiscount() ,sendingMechanisms.get(min_sender_index).getName());
	}
	
	
}
