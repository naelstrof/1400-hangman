/***************************************************************
*
*  Project  :  Hangman
*  File     :  HangmanManMain
*  Name     :  Justin Behunin, Rachael Hull, Seth Jackson, Sara Jans, Dalton Nell
*  Date     :  12/03/2013
*
*  Description :  
*
*  
****************************************************************/


import java.util.Scanner;

public class HangManMain
{
   public static void main (String[] args)
   {
      char  playAgain = ' ';
      //main loop ends with option to play again.
      do {
         //intializes variables, word is the random word, gword for player guesses.
         int incorrect = 0;
         Word I = new Word("SomeName", "Blank");
         Player U = new Player();
         char word[] = I.returnWord().toCharArray();//gets random word and converts it to a char array
         char gWord[] = I.returnRenderable().toCharArray();
         intializeGWord(gWord);//sets gword to underscores
         char doneLetter[] = new char[26];
         int doneList = 0;
         char letter = ' ';
         boolean win = false;
         Scanner input = new Scanner(System.in);
         System.out.println("Welcome to hangman.");
      
         //loop for the gameplay
         do {
            //displays the hangman and player's view of the word, asks player to enter letter  
            U.setHp(incorrect);
            System.out.println(U.printGallows() );
            System.out.println(U.toString() );
            printGuessWord(gWord);
            System.out.println();
            System.out.print("Please input a letter or word: ");
            char myWord[] = input.next().toCharArray();//allows letter or word to be entered
            letter = myWord[0];//gets first letter entered from myWord
            
            if(searchDoneList(doneLetter, letter, word, myWord) == true)
            {
               System.out.println("This letter has already been used.");
            }
            else
            {
               if(myWord.length == word.length)//checks if word entered matches
               {
                     win = checkWin(word, myWord);
                     if (win == false)
                     incorrect ++;
               }
                  else//if only letter entered checks if the letter is in the word
                  {
                     boolean cLetter = linearSearch(word, letter);
                     
                     //false if letter not in word, else adds the letter to gword
                     
                     if (cLetter == false)
                     {
                        System.out.println();
                        System.out.printf("Sorry, %c is not in the word\n", letter);
                        incorrect ++;
                     }
                        else 
                        {
                           addLetter(word, gWord, letter);
                           win = checkWin(word, gWord);
                        }   
                     doneLetter[doneList] = letter;
                     doneList++;       
                  }
            }        
            if (win == true)
               break;         
         }while (incorrect < 6);//loops ends when player guesses incorrectly 6 times 

         //if player reached 6 incorrect guesses prints lose statement, else prints win statement
         if (incorrect == 6)
         {
            U.setHp(incorrect);
            U.toString();
            printGuessWord(gWord);
            System.out.println();
            System.out.println("Sorry too many incorrect guesses, you lose.");
            System.out.print("The word was ");
            printGuessWord(word);//prints the correct word
         }//end if
            else
            {
               U.setHp(incorrect);
               U.toString();
               printGuessWord(word);
               System.out.println();
               System.out.println("Congratulations you WIN!!!!!!");
            }//end  else
         //gives option to play another game   
         System.out.print("Would you like to play again? ");
         playAgain = input.next().charAt(0);         
      } while(playAgain != 'n');   
   }//end main
   
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
   
   public static boolean searchDoneList(char[] list, char key, char[] keyHole, char[] openDoor)
   {
      if(openDoor.length != keyHole.length)
      {
         for (int i = 0 ; i < list.length; i++)
         {
            if (key == list[i])
               return true;
         }//end for loop
      }
         return false;
   }
}
