package practices;

public class test {

	public static void main(String[] args) {
		ICustomer p = new Person();
		ICustomer c = new Company();
		
		//AClerck ck = new AClerck();
		
		
		System.out.println(p.computeCreditLimit());
		System.out.println(c.computeCreditLimit());
		
		ACustomer p1 = new Person();
		ACustomer c1 = new Company();
		
		System.out.println(p1.computeCreditLimit());
		System.out.println(c1.computeCreditLimit());
		
		
	}

}
