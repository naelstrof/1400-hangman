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

public class HangMan
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
         Scanner input = new Scanner(System.in);
         System.out.println("Welcome to hangman.");
      
         //loop for the gameplay
         do {
            //displays the hangman and player's view of the word, asks player to enter letter  
            printHangman(incorrect);
            printGuessWord(gword);
            System.out.println();
            System.out.print("Please input a letter: ");
            letter = input.next().charAt(0);
            int cLetter = linearSearch(word, letter);//searches word for the letter guessed
            
            // -1 means the letter wasn't in the word, else adds letter to gword array
            if (cLetter == -1)
            {
               System.out.println();
               System.out.printf("Sorry, %c is not in the word\n", letter);
               incorrect += 1;
            }
               else addLetter(word, gword, letter);
               
               //hi seth started this to allow the user to guess the whole word.
            System.out.println("would you like to try to guess the whole word.");
            char wholeWord = input.next().charAt(0);
            if('y' == wholeWord)
            {
                System.out.println("please enter your guess");
                char Guess = input.next().charAt(0);
                char wWord[] = new char[Guess];
                wholeWord(word, wWord);
            }
               
            //checks for win and breaks out of loop if player won   
            char win = checkWin(word, gword);
            if (win == 'y')
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
               printGuessWord(gword);
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
   
   //searches word for letter guessed, returns -1 if letter not in word array
   public static int linearSearch(char[] list, char key)
   {
      for (int i = 0 ; i < list.length; i++)
      {
         if (key == list[i])
            return i;
      }//end for loop
      return -1;
   }//end linearSearch
   
   //adds the correctly guessed letter in the word array to the gword array
   public static void addLetter(char[] list, char glist[], char key)
   {
      for (int i = 0; i < list.length; i++)
         if (list[i] == key)
            glist[i] = list[i];
   }//end addLetter
   
   //checks for win by checking if word = gword
   public static char checkWin(char[] list, char glist[])
   {
      for (int i = 0; i < list.length; i++)
         if (list[i] != glist[i])
            return 'n';
      return 'y';            
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
    
    //Hi Seth started this method to allow users to guess the whole word.
    public static char wholeWord(char[] list, char wWord[])
   {
      for (int i = 0; i < list.length; i++)
         if (list[i] != wWord[i])
         {
             System.out.println("Sorry thats not correct");
         }
         else
         {
             System.out.println("You WIN!");
             break;
         }      
       return 0;
   }//end WholeWord
}//end HangMan
