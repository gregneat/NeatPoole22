public class starter
{
   public static void main(String args[])
	{
		
		OnlinePurchaseManager op = new OnlinePurchaseManager();
		op.add( "ABC", true, 5 );
		op.add( "ABC", false, 66 );
		op.add( "XYZ", true, 8 );
		op.add( "lmnop", false, 2.4 );
		op.add( "ABC", true, 7.1 );
		op.add( "ABC", false, 9.987 );		
		System.out.println( op.countElectronicsByMaker( "ABC" ) ); 
		System.out.println( op.countElectronicsByMaker( "DOG" ) ); 
		System.out.println( op.countElectronicsByMaker( "lmnop" ) );  
		System.out.println( op.countElectronicsByMaker( "XYZ" ) );  		
		System.out.println( op.hasAdjacentEqualPair() );  
		System.out.println( op );	
		op.add( "APLUS", false, 22 );
		System.out.println( op.hasAdjacentEqualPair() );  
		op.add( "ABC", false, 1.6 );
		op.add( "ABC", true, 8.43 );
		op.add( "ABC", false, 78.123 );
		System.out.println( op.countElectronicsByMaker( "ABC" ) ); 	
		System.out.println( op.hasAdjacentEqualPair() );  	
		System.out.println( op );			
		System.out.println( op.getCheapestGizmoByMaker( "ABC" ) );  
		System.out.println( op.getCheapestGizmoByMaker( "APLUS" ) );  																																
	} 
}

// output:

// 2
// 0
// 0
// 1
// false
// [ABC true 5.0, ABC false 66.0, XYZ true 8.0, lmnop false 2.4, ABC true 7.1, ABC false 9.987]
// false
// 3
// false
// [ABC true 5.0, ABC false 66.0, XYZ true 8.0, lmnop false 2.4, ABC true 7.1, ABC false 9.987, APLUS false 22.0, ABC false 1.6, ABC true 8.43, ABC false 78.123]
// ABC false 1.6
// APLUS false 22.0

