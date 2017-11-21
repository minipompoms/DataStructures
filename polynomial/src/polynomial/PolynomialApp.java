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
        
       p2.addTerm(new Monomial(3,3));
       p2.addTerm(new Monomial (4,4));
       p2.addTerm(new Monomial (4,4));
       p2.addTerm(new Monomial(3,3));
       p2.addTerm(new Monomial(4,8));
       //System.out.println(p2);

//       p2.addTerm(new Monomial(1,1));
//       p2.addTerm(new Monomial(6,3));
//       p2.addTerm(new Monomial (2,3));
       
       p1.addTerm(new Monomial(4,2));
       p3.addTerm(new Monomial (2,2));
       p3.addTerm(new Monomial(4,3));
       p3.addTerm(new Monomial (2,2));
       p3.addTerm(new Monomial(4,7));
       p3.addTerm(new Monomial(4,1));
       
       System.out.println("SUM:"+p3);
       System.out.println("+\n"+p1);
       
       Polynomial sum = new Polynomial();
       Polynomial z = sum.likeTerms(p3);
       
        System.out.println("likeTerms:"+z);
       Polynomial s = p1.sum(z);
      
       
      System.out.println("sum"+s);
      //p1.likeTerms(p2);
      Polynomial p = new Polynomial();
      Polynomial x =  p.likeTerms(p2);
       
      System.out.println("likeTerms:"+x);
       //Polynomial constant = p1.constantProduct(4);
       //System.out.println(constant);
        //p3.timesConstant(2);
        //System.out.println(p3);
       // Polynomial product = p1.product(p2);
        //System.out.println(product);
        //System.out.println(p2.toString());

        
    }
    
    
}
