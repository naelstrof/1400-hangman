/******************************************
*
*  11/25 Current working version of Player object.
*  Changes to come: Unicode reworking of toString.
*
******************************************/

public class Player
{
   //make fields
   int hp;
   
   //constructors
   public Player()
   {
      this( 0, " " );
   }

   public Player( int hp, String display )
   {
      this.hp = hp;
   }
   
   //getItems
   public int getHp()
   {
      return this.hp;
   }
   
public String toString()
   {
      hp = getHp();
      
      switch( hp )
      {
         case 0:
         {
            System.out.println( "_____    " );
            System.out.println( "|   |    " );
            System.out.println( "|        " );
            System.out.println( "|        " );
            System.out.println( "|        " );
            System.out.println( "|_____   " );
            System.out.println( "|     |_ " );
            System.out.println( "|       |" );
         }
         break;
         case 1:
         {
            System.out.println( "_____    " );
            System.out.println( "|   |    " );
            System.out.println( "|   0    " );
            System.out.println( "|        " );
            System.out.println( "|        " );
            System.out.println( "|_____   " );
            System.out.println( "|     |_ " );
            System.out.println( "|       |" );
         }
         break;
         case 2:
         {
            System.out.println( "_____    " );
            System.out.println( "|   |    " );
            System.out.println( "|   0    " );
            System.out.println( "|   |    " );
            System.out.println( "|        " );
            System.out.println( "|_____   " );
            System.out.println( "|     |_ " );
            System.out.println( "|       |" );
         }
         break;
         case 3:
         {
            System.out.println( "_____    " );
            System.out.println( "|   |    " );
            System.out.println( "|   0    " );
            System.out.println( "|  /|    " );
            System.out.println( "|        " );
            System.out.println( "|_____   " );
            System.out.println( "|     |_ " );
            System.out.println( "|       |" );
         }
         break;
         case 4:
         {
            System.out.println( "_____    " );
            System.out.println( "|   |    " );
            System.out.println( "|   0    " );
            System.out.println( "|  /|\\   " );
            System.out.println( "|        " );
            System.out.println( "|_____   " );
            System.out.println( "|     |_ " );
            System.out.println( "|       |" );
         }
         break;
         case 5:
         {
            System.out.println( "_____    " );
            System.out.println( "|   |    " );
            System.out.println( "|   0    " );
            System.out.println( "|  /|\\   " );
            System.out.println( "|  /     " );
            System.out.println( "|_____   " );
            System.out.println( "|     |_ " );
            System.out.println( "|       |" );
         }
         break;
         case 6:
         {
            System.out.println( "_____    " );
            System.out.println( "|   |    " );
            System.out.println( "|   0   " );
            System.out.println( "|  /|\\   " );
            System.out.println( "|  / \\   " );
            System.out.println( "|_____   " );
            System.out.println( "|     |_ " );
            System.out.println( "|       |" );
         }
         break;
         default:
         {
            System.out.println( "_____    " );
            System.out.println( "|   |    " );
            System.out.println( "|  HOW   " );
            System.out.println( "|  DID   " );
            System.out.println( "|  YOU   " );
            System.out.println( "|__GET   " );
            System.out.println( "|  HERE_ " );
            System.out.println( "|       |" );
         }
         break;
      }//end switch
      
      return String.format( "You have made %d/6 guesses." , hp);
   }   //setItems
   
   public void setHp( int hp )
   {
      this.hp = hp;
   }
   //toString
}//end player