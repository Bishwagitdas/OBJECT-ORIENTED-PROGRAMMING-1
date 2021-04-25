class Contact 
{
	private String name;
	private String phoneNumber;
	static int countryCode;
	public String email;
	public String bloodGroup;
	public String address;
	
	
	public Contact()
	{
		// default country code 
		this.countryCode = 88;
		System.out.println("Input the following information");	
	}
	
	public Contact(String name, String phoneNumber, String bloodGroup, String email, String address){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.bloodGroup = bloodGroup;
		this.email = email;
		this.address = address;
	}
	
	public void setInfo(String name, String phoneNumber, String bloodGroup, String email, String address){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.bloodGroup = bloodGroup;
		this.email = email;
		this.address = address;
	}
	
	public void showInformation(){
		System.out.println("=============Contact_Information================");
		System.out.println("Name: " + name);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("Blood Group: " + bloodGroup);
		System.out.println("Email: " + email);
		System.out.println("Address: " + address);
	}
	
	public void checkingOperator()
	{
		if(phoneNumber.contains("017"))
		{
			System.out.println("Using GrameenPhone sim ");
		}
		else if(phoneNumber.contains("018"))
		{
			System.out.println("Using Robi sim");
		}
		else if(phoneNumber.contains("019"))
		{
			System.out.println("Using BanglaLink sim");
		}
		else
		{
			System.out.println("Sim Operator not found");
		}
	}
	
	static void changeCountryCode(int countryCode)
	{
		countryCode = countryCode;
		System.out.println("Countrycode changed  " + countryCode);
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	
}