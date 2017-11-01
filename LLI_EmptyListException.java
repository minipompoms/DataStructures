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
public class LLI_EmptyListException extends Exception
{
    
    /**
     *
     */
    public LLI_EmptyListException()
    {
        super("Encountered an empty list");
    }
    
    /**
     *
     * @param error
     */
    public LLI_EmptyListException(String error)
    {
        super(error);
    }


    
}
