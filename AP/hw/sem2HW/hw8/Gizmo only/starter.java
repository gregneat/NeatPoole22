public class starter
{
   public static void main(String args[])
	{
		Gizmo gz = new Gizmo( "sony", true, 9.9 );
		System.out.println( gz.getMaker() );
		System.out.println( gz.isElectronic() );
		System.out.println( gz.getMaker() );
		System.out.println( gz.getCost() );
		System.out.println( gz );	
			
		Gizmo et = new Gizmo( "aplus", false, 9.1 );	
		System.out.println( et );
										
		System.out.println( et.equals( gz ) );	
			
		Gizmo at = new Gizmo( "sony", true, 22.3 );
		System.out.println( at );
			
		System.out.println( at.equals( gz ) );																															
	} 
}

// output:



// true
// sony
// 9.9
// sony true 9.9
// aplus false 9.1
// false
// sony true 22.3
// false

