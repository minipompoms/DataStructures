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
        Polynomial p4 = new Polynomial();
        p2.addTerm(new Monomial(1,1));
        p2.addTerm(new Monomial(3,6)); 
        p2.addTerm(new Monomial(2,2));
        p2.addTerm(new Monomial(4,3));
    
       
       p2.addTerm(new Monomial(2,8));
       p2.addTerm(new Monomial(1,1));
       p2.addTerm(new Monomial(2,1));
       p2.addTerm(new Monomial(1,11));
       p2.addTerm(new Monomial(2,9));
       
         //System.out.println("list 4 :"+p4);
         System.out.println("list 2 :"+p2);
       Polynomial x;
       x = p2.likeTerms(p2);
       
       System.out.println("like Terms: "+x);
       
       p3.addTerm(new Monomial (2,8));
       p3.addTerm(new Monomial(4,3));
       p3.addTerm(new Monomial (2,2));
       p3.addTerm(new Monomial(0,4));
       p3.addTerm(new Monomial(1,1));
       
//       
//       System.out.println("list 1 :"+p1);
//       //System.out.println("list 2 :"+p2);
//       System.out.println("list 3 :"+p3);
//       Polynomial s;
//       s = p3.sum(p1);
//       System.out.println("sum of list 3 & 1 :"+s);
//       //Polynomial p;
       //p = p1.sum(p2);
       //System.out.println("sum of list 1 & 2: "+p);

        
    }
    
    
}
