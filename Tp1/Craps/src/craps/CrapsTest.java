package craps;


// Fig. 6.10: CrapsTest.java
// Application to test class Craps.

public class CrapsTest 
{
	private static final int MAX = 13;
		int frecuency[] = new int[MAX];
		
	public static void main( String args[] )
   {
	   
	  Craps game = new Craps();
      int partidas_ganadas = 0;
      int partidas_perdidas = 0;
      int contador = 0;
      
      
      game.play(); // play one game of craps
      while(contador < 1000) {
    	  if(game.play()==1) {
    		  partidas_ganadas++;
    	  }
    	  else if(game.play()==0) {
    		  partidas_perdidas++;
    	  }
   		contador++;
      }
      
      System.out.println("Partidas: "+partidas_ganadas);
      System.out.print("Ganada: "+ partidas_ganadas);
      
   } // end main
} // end class CrapsTest

/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
