import java.util.ArrayList;

public class Quizzer {

	
        public static void main(String args[])
        {
	
		ArrayList<String> joe = new ArrayList<String>();

		joe.add("Happy");
		joe.add("Valentine's");
		joe.add("Day");

		System.out.println(joe);
		System.out.println(joe.size());
		joe.add(1,"Sad");
		System.out.println(joe);
		System.out.println(joe.get(1));
		System.out.println(joe);
		System.out.println(joe.set(1,"neutral"));
		System.out.println(joe);
		System.out.println(joe.remove(2));
		System.out.println(joe);
		
	
	}
	

	  
	

}
