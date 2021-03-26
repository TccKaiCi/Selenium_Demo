

public class test {
	public static void main(String[] args) {
	      int age = 20;
	      assert age <= 18 : "Cannot Vote";
	      System.out.println("The voter's age is " + age);
	      
	      age = 1;
	      assert age <= 18 : "Cannot Vote";
	      System.out.println("The voter's age is " + age);

	      int value = 15;
	        assert value >= 20 : " Underweight";
	        System.out.println("value is "+value);
	        
	        value = 22225;
	        assert value >= 20 : " Underweight";
	        System.out.println("value is "+value);
	}
}
