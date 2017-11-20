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
        Polynomial p3 = new Polynomial();
        
      
       p2.addTerm(new Monomial (3,3));
       p2.addTerm(new Monomial(4,6));
       p2.addTerm(new Monomial(2,5));
       p2.addTerm(new Monomial(1,1));
       p2.addTerm(new Monomial (5,9));
       
       p1.addTerm(new Monomial(4,2));
       p3.addTerm(new Monomial (2,2));
       p3.addTerm(new Monomial(4,3));
       p3.addTerm(new Monomial (2,2));
       p3.addTerm(new Monomial(4,7));
       p3.addTerm(new Monomial(4,1));
       System.out.println(p1.toString()+ p3);
       Polynomial sum = p1.sum(p3);
       //System.out.println(sum);

       
      System.out.println("sum"+sum);

       //Polynomial constant = p1.constantProduct(4);
       //System.out.println(constant);
        //p3.timesConstant(2);
        //System.out.println(p3);
       // Polynomial product = p1.product(p2);
        //System.out.println(product);
        //System.out.println(p2.toString());

        
    }
    
    
}
