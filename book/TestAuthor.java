public class TestAuthor {
   public static void main(String[] args) {
      Author shuvra = new Author("Shuvra Dey", "shuvra@gmail.com", 'female');
      System.out.println(shuvra);  // toString()
      //Tan Ah Teck (m) at teck@nowhere.com

      // Test Setters and Getters
      shuvra.setEmail("shuvra@gmail.com");
      System.out.println(shuvra);  // toString()
      //Tan Ah Teck (m) at teck@somewhere.com
      System.out.println("name is: " + shuvra.getName());
      //name is: Tan Ah Teck
      System.out.println("gender is: " + shuvra.getGender());
      //gender is: f
      System.out.println("email is: " + shuvra.getEmail());
      //email is: teck@somewhere.com
   }
}