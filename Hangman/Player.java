/******************************************
*
*  11/25 Current working version of Player object.
*  Changes to come: Unicode reworking of toString.
*
*  11/26 added setGallows, getGallows, changed toString.
*
******************************************/

public class Player
{
   //make fields
   int hp;
   String gallows = printGallows();
   
   //constructors
   public Player()
   {
      this( 0, " " );
   }

   public Player( int hp, String gallows )
   {
      this.hp = hp;
      this.gallows = " ";
   }
   
   //getItems
   public int getHp()
   {
      return this.hp;
   }
   
   public String getGallows()
   {
      return this.gallows;
   }

   //set items
   public void setHp( int hp )
   {
      this.hp = hp;
   }
   
   public String printGallows()
   {
   hp = getHp();
      
   switch( hp )
   {
      case 0:
      {
         gallows = String.format( "_____    \n" + 
            			   "|   |    \n" + 
            			   "|        \n" +
            			   "|        \n" +
            			   "|        \n" +
            			   "|_____   \n" +
            			   "|     |_ \n" +
            			   "|       |\n" );
      }
      break;
      case 1:
      {
         gallows = String.format( "_____    \n" + 
            			   "|   |    \n" + 
            			   "|   0    \n" +
            			   "|        \n" +
            			   "|        \n" +
            			   "|_____   \n" +
            			   "|     |_ \n" +
            			   "|       |\n" );
      }
      break;
      case 2:
      {
         gallows = String.format( "_____    \n" + 
            			   "|   |    \n" + 
            			   "|   0    \n" +
            			   "|   |    \n" +
            			   "|        \n" +
            			   "|_____   \n" +
            			   "|     |_ \n" +
            			   "|       |\n" );
      }
      break;
      case 3:
      {
         gallows = String.format( "_____    \n" + 
            			   "|   |    \n" + 
            			   "|   0    \n" +
            			   "|  /|    \n" +
            			   "|        \n" +
            			   "|_____   \n" +
            			   "|     |_ \n" +
            			   "|       |\n" );
      }
      break;
      case 4:
      {
         gallows = String.format( "_____    \n" + 
            			   "|   |    \n" + 
            			   "|   0    \n" +
            			   "|  /|\\    \n" +
            			   "|        \n" +
            			   "|_____   \n" +
            			   "|     |_ \n" +
            			   "|       |\n" );
      }
      break;
      case 5:
      {
         gallows = String.format( "_____    \n" + 
            			   "|   |    \n" + 
            			   "|   0    \n" +
            			   "|  /|\\    \n" +
            			   "|  /     \n" +
            			   "|_____   \n" +
            			   "|     |_ \n" +
            			   "|       |\n" );
      }
      break;
      case 6:
      {
         gallows = String.format( "_____    \n" + 
            			   "|   |    \n" + 
            			   "|   0    \n" +
            			   "|  /|\\    \n" +
            			   "|  / \\    \n" +
            			   "|_____   \n" +
            			   "|     |_ \n" +
            			   "|       |\n" );
      }
      break;
      default:
      {
         String.format( "Gallows function is an int from 0 - 6." );
      }
      break;
   }//end switch
      return gallows;
   }//end setGallows
   
   public String toString()
   {
      hp = getHp();
      return String.format( "You have made %d/6 guesses." , hp);
   }
   
}//end player