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
public class PolynomialApp {
    
    public static void main (String[] args)
    {
        
        Polynomial p1 = new Polynomial();
        Monomial t1 = new Monomial(2,2);
        p1.addTerm(t1);
       
        Monomial t2 = new Monomial(4,1);
        p1.addTerm(t2);
       
        System.out.println(t1.toString()+t2.toString());
        
        System.out.println(p1);
        
        
    }
    
    
}
