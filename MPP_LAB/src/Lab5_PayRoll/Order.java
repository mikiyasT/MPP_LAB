package Lab5_PayRoll;

import java.util.GregorianCalendar;

public class Order {
	
	private String orderNo;
	private GregorianCalendar orderDate;
	private int orderAmount;
	
	
	
	public Order(String orderNo, GregorianCalendar orderDate, int orderAmount) {
		super();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public GregorianCalendar getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(GregorianCalendar orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	
}
