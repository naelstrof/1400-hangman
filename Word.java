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
        Word = Dictionary.word();
        return Word;
    }//end returnWord
}//end Word class
