public class Employee
{
	public String name ; // instance variable 
	public String id ;
	public int age ;
	private double salary ;
	
	public Employee() // default constructor
	{
		
	}
	public Employee(String name, String id, int age, double salary) // parameterized constructor 
	{
		this.name = name ;
		this.id = id ;
		this.age = age ;
		this.salary = salary;
	}
	public Employee(double salary) // parameterized Constructor 
	{
		this.salary = salary ;
	}
	
	public void setSalary(double salary) // instance method
	{
		this.salary = salary ;
	}
	public float getSalary()
	{
		return this.salary ;
	}
	public void showEmployeeInformation()
	{
		System.out.println("Name: "+name) ;
		System.out.println("ID: "+id) ;
		System.out.println("Age: "+age) ;
		System.out.println("Salary: "+salary) ;
	}
	
	
}