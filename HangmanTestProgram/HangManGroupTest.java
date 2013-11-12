/***************************************************************
*
*  Project  :  Group Assignment
*  File     :  Hangman
*  Name     :  Justin Behunin, Rachael Hull, Seth Jackson, Sara Jans, Dalton Nell
*  Date     :  12/03/2013
*
*  Description :  
*
*  
****************************************************************/

import java.util.Scanner;

public class HangManGroupTest
{
   public static void main (String[] args)
   {
      char  playAgain = ' ';
      //main loop ends with option to play again.
      do {
         //intializes variables, word is the random word, gword for player guesses.
         int incorrect = 0;
         char word[] = RandomWord.word().toCharArray();//gets random word and converts it to a char array
         char gword[] = new char[word.length];
         intializeGWord(gword);//sets gword to underscores
         char letter = ' ';
         boolean win = false;
         Scanner input = new Scanner(System.in);
         System.out.println("Welcome to hangman.");
      
         //loop for the gameplay
         do {
            //displays the hangman and player's view of the word, asks player to enter letter  
            printHangman(incorrect);
            printGuessWord(gword);
            System.out.println();
            System.out.print("Please input a letter or word: ");
            char myWord[] = input.next().toCharArray();//searches word for the letter guessed
            letter = myWord[0];
           
            if (myWord.length == word.length)
            {
               win = checkWin(word, myWord);
               if (win == false)
               incorrect ++;
            }
               else
               {
                  //false if letter not in word, else adds the letter to gword
                  boolean cLetter = linearSearch(word, letter);
                  if (cLetter == false)
                  {
                     System.out.println();
                     System.out.printf("Sorry, %c is not in the word\n", letter);
                     incorrect ++;
                  }
                     else 
                     {
                        addLetter(word, gword, letter);
                        win = checkWin(word, gword);
                     }                        
               }      
            if (win == true)
               break;         
         }while (incorrect < 6);//loops ends when player guesses incorrectly 6 times 

         //if player reached 6 incorrect guesses prints lose statement, else prints win statement
         if (incorrect == 6)
         {
            printHangman(incorrect);
            printGuessWord(gword);
            System.out.println();
            System.out.println("Sorry too many incorrect guesses, you lose.");
            System.out.print("The word was ");
            printGuessWord(word);//prints the correct word
         }//end if
            else
            {
               printHangman(incorrect);
               printGuessWord(word);
               System.out.println();
               System.out.println("Congratulations you WIN!!!!!!");
            }//end  else
         //gives option to play another game   
         System.out.print("Would you like to play again? ");
         playAgain = input.next().charAt(0);         
      } while(playAgain != 'n');   
   }//end main
   
   //method to print out hangman
   public static void printHangman(int i)
   {
   /* Uses boolean statments to either print a body part ot just the gallows.\
   *  if a condition is false only prints gallow piece
   *  if a condition is true adds the body part to the display 
   */
      //prints the top of gallows
      System.out.println ("_____");
      System.out.println ("|   |");
      //adds the head if true, false adds gallow piece
      System.out.print(i >= 1 ? ("|   0\n"):("|\n"));
      //adds the first arm and gallow piece, new line if incorrect = 2, false adds gallow piece
      System.out.print(i >= 2 ? ("|  /"):("|\n"));
      System.out.print(i == 2 ? ("\n"):(""));
      //adds the body, new line and gallow if  incorrect = 3, false adds gallow piece
      System.out.print(i >= 3 ? ("|"):("|\n"));
      System.out.print(i == 3 ? ("\n|\n"):(""));
      //adds the second arm , new line and gallow if incorrect = 4, false adds nothing
      System.out.print(i >= 4 ? ("\\\n"):(""));
      System.out.print(i == 4 ? ("|\n"):(""));
      //adds the first leg , new line if incorrect = 5, false does nothing
      System.out.print(i >= 5 ? ("|  /"):(""));
      System.out.print(i == 5 ? ("\n"):(""));
      //adds the second leg , new line if incorrect = 6, false does nothing
      System.out.print(i >= 6 ? (" \\"):(""));
      System.out.print(i == 6 ? ("\n"):(""));
      System.out.println();
   }//end printHangman
   
   //searches word for letter guessed, returns false if letter not in word array
   public static boolean linearSearch(char[] list, char key)
   {
      for (int i = 0 ; i < list.length; i++)
      {
         if (key == list[i])
            return true;
      }//end for loop
      return false;
   }//end linearSearch
   
   //adds the correctly guessed letter in the word array to the gword array
   public static void addLetter(char[] list, char glist[], char key)
   {
      for (int i = 0; i < list.length; i++)
         if (list[i] == key)
            glist[i] = list[i];
   }//end addLetter
   
   //checks for win by checking if word = gword
   public static boolean checkWin(char[] list, char glist[])
   {
      for (int i = 0; i < list.length; i++)
         if (list[i] != glist[i])
            return false;
      return true;            
   }//end check win
   
   //prints the array passed to the method, either gword or word
   public static void printGuessWord(char [] list)
   {
      for (int i = 0; i < list.length; i++)
         System.out.printf("%c ",list[i]);
      System.out.println();
   }//end printGuessWord
   
   //method that intializes gword to underscores.
   public static void intializeGWord(char [] list)
   {
      for(int i = 0; i < list.length; i++)
         list[i] = '_';
   }//end intializeGWord
    
}//end HangMan
