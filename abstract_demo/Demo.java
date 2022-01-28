package abstract_demo;
abstract class Car
{
	abstract void cost();
	abstract void milage();
	void vipers()
	{
		System.out.println("Car has Vipers...");
	}
}
abstract class Bike
{
	abstract void cost();
	abstract void milage();
	void stand()
	{
		System.out.println("Bike has Stand...");
	}
}

class Audi extends Car
{
	public void cost()
	{
		System.out.println("Audi cost is 40 Lakhs");
	}

	public void milage()
	{
		System.out.println("Audi milage is 15 KM");		
	}
	
}
class BMW extends Car
{
	public void cost()
	{
		System.out.println("BMW cost is 50 Lakhs");
	}
	
	public void milage()
	{
		System.out.println("BMW milage is 10 KM");		
	}
	
}

class Fz extends Bike
{
	public void cost()
	{
		System.out.println("FZ cost is 2 Lakhs");
	}
	
	public void milage()
	{
		System.out.println("FZ milage is 50 KM");		
	}
	
}
class Apache extends Bike
{
	public void cost()
	{
		System.out.println("Apache cost is 1.5 Lakhs");
	}
	
	public void milage()
	{
		System.out.println("Apache milage is 40 KM");		
	}
	
}

public class Demo {

	public static void main(String[] args) {
		
		Car a;
		System.out.println("\t Car Details ");
		a=new Audi();
		a.cost();
		a.milage();
		System.out.println("\n\tBike Details ");
		Bike b;
		b=new Fz();
		b.cost();
		b.milage();
		

	}

}
