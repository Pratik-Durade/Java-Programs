package interface_demo;
interface Vehicle
{
	void cost();
	void milage();
}
abstract class Car implements Vehicle
{
	void vipers()
	{
		System.out.println("Car has Vipers...");
	}
}
abstract class Bike implements Vehicle
{
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
class CarFactory
{
	Car getCar(String car)
	{
		if(car.equals("Audi"))
			return new Audi();
		else if(car.equals("BMW"))
			return new BMW();
		return null;
	}
}
class BikeFactory
{
	Bike getBike(String bike)
	{
		if(bike.equals("Fz"))
			return new Fz();
		else if(bike.equals("Apache"))
			return new Apache();
		return null;
	}
}
public class Interface_Demo {
	public static void main(String[] args)
	{		
		Car a=new Audi();
		Car b=new BMW();
		Bike b1=new Fz();
		Bike b2=new Apache();
		System.out.println("CAR DETAILS :\n________________________________");
		System.out.println("\t AUDI CAR DETAILS :");
		a.vipers();
		a.cost();
		a.milage();
		System.out.println("\t BMW CAR DETAILS :");
		b.vipers();
		b.cost();
		b.milage();
		System.out.println("\nBIKE DETAILS :\n________________________________");
		System.out.println("\t FZ BIKE DETAILS :");
		b1.stand();
		b1.cost();
		b1.milage();
		System.out.println("\t Apache Bike DETAILS :");
		b1.stand();
		b2.cost();
		b2.milage();
		
	}
}
