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

public class Word 
{
    String renderable;
    String Word;
    
    public Word(String renderable, String Word)
    {
        this.renderable = renderable;
        this.Word = Word;
    }// end Word
    
    public void setRenderable(String renderable)
    {
        this.renderable = renderable;
    }//end setRenderable
    
    public void setWord(String Word)
    {
        this.Word = Word;
    }//end setWord
     
    public String getRenderable()
    {
        return renderable;
    }//end getRenderable
    
    public String getWord()
    {
        return Word;
    }//end getWord
    
    public String returnWord()
    {
        Word = word();
        return Word;
    }//end returnWord
    public String returnRenderable()
    {
      renderable = Word;
      return renderable;
    }
    public static String word()
   {
      int rWord = (int)(1 + Math.random() * 20);
      String randomWord = "";
      switch(rWord)
      {
         case 1: randomWord = "river"; break;
         case 2: randomWord = "water"; break;
         case 3: randomWord = "cloud"; break;
         case 4: randomWord = "ocean"; break;
         case 5: randomWord = "wheelbarrow"; break;
         case 6: randomWord = "wolf"; break;
         case 7: randomWord = "radio"; break;
         case 8: randomWord = "ghost"; break;
         case 9: randomWord = "pumpkin"; break;
         case 10: randomWord = "spooky"; break;
         case 11: randomWord = "library"; break;
         case 12: randomWord = "book"; break;
         case 13: randomWord = "paper"; break;
         case 14: randomWord = "rock"; break;
         case 15: randomWord = "scissors"; break;
         case 16: randomWord = "meter"; break;
         case 17: randomWord = "television"; break;
         case 18: randomWord = "computer"; break;
         case 19: randomWord = "monkey"; break;
         case 20: randomWord = "valley"; break;   
      }//end switch
      return randomWord;
   }

}//end Word class

