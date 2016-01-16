package practices;

public abstract class ACustomer implements ICustomer{
	String name;
	String address;
	public String getName()
	{
		return name;
	}
	public String getAddress(){
		return address;
	}
	
	//public abstract double computeCreditLimit();
}
