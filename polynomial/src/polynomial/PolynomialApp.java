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
    
    public static void main (String[] args)
    {
        
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
       
        Polynomial p3 = new Polynomial();
     
       //p2.addTerm(new Monomial(2,4));
       
       p1.addTerm(new Monomial(2,5));
       p1.addTerm(new Monomial(2,4));
       p1.addTerm(new Monomial(2,3));
       p1.addTerm(new Monomial(2,2));
       p1.addTerm(new Monomial(2,9));
       
       //System.out.println(p1.terms.toString());
       p3.addTerm(new Monomial(4,4));
       p2.addTerm(new Monomial(4,4));
      // System.out.println(p2.toString());
       Polynomial sum = p2.sum(p3);
       //Polynomial constant = p2.constantProduct(2);
       //p1.constantProduct(2);
       System.out.println(p2.toString());
 
        //System.out.println(constant.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());

       
        
        
    }
    
    
}
