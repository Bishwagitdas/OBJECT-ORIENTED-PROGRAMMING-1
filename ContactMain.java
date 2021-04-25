import java.util.Scanner;

class ContactMain{
	
	public static void main(String args[]){
		
		Contact contact[] = new Contact[2];
		Scanner scr = new Scanner(System.in); 
		
		Contact contactInfo1 = new Contact();
		
		for(int i = 0; i < 2; i++){
			System.out.println("Information for object " + i+1);
			contact[i] = contactInfo1;
			
			System.out.println("Enter your Name");
			String name = scr.nextLine();
			System.out.println("Enter your Phone Number");
			String phoneNumber = scr.nextLine();
			System.out.println("Enter your Blood Group");
			String bloodGroup = scr.nextLine();
			System.out.println("Enter your Email");
			String email = scr.nextLine();
			System.out.println("Enter your Address");
			String address = scr.nextLine();
			
			contact[i].setInfo(name, phoneNumber, bloodGroup, email, address);
			contact[i].showInformation();
		}	
	}

}
