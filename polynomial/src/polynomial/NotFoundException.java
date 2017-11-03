/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

/**
 *
 * @author Paige
 */
class NotFoundException extends Exception 
{
 
   public NotFoundException()
   {
       super("Item not found");
   }
   
   public NotFoundException(String error)
   {
       super(error);
   }
    
}
