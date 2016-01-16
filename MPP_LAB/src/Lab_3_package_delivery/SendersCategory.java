package Lab_3_package_delivery;

public class SendersCategory {
	
	String category;
	double discount;
	
	SendersCategory(String cat, double discnt){
		category = cat;
		discount = discnt;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
		
}
