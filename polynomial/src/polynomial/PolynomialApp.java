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
public class PolynomialApp  {
    
    public static void main (String[] args) throws NotFoundException
    {
        
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
       
       
       p1.addTerm(new Monomial(4,4));
       p1.addTerm(new Monomial(1,8));
       p1.addTerm(new Monomial(2,3));
       
       p2.addTerm(new Monomial(1,11));
       p2.addTerm(new Monomial(2,9));
       p2.addTerm(new Monomial(1,1));
       p2.addTerm(new Monomial(3,6)); 
       p2.addTerm(new Monomial(2,2));
       p2.addTerm(new Monomial(4,3));
       
       System.out.println(p1);
       p1.product(p2);
       System.out.println(p1);
   
      
    




        
    }
    
    
}
