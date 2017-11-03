/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlists;

/**
 *
 * @author Paige Kohn
 */
public class LLI_EmptyListExc extends Exception
{
    
    /**
     *
     */
    public LLI_EmptyListExc()
    {
        super("Encountered an empty list");
    }
    
    /**
     *
     * @param error
     */
    public LLI_EmptyListExc(String error)
    {
        super(error);
    }


    
}
