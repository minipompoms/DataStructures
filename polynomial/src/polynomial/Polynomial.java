/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

/**
 *
 * @author Paige Kohn
 */
public class Polynomial {
    
    SDLLC<Monomial> terms;
    
    /**
     * constructor
     */
    public Polynomial()
    {
        terms = new SDLLC<>();
     
    }
    
    /**
     * to add a single monomial term the list
     * @param term 
     */
    public void addTerm(Monomial term)
    {
        terms.insert(term);
    }
    
    /**
     * to add another polynomial to the given instance
     * @param other
     */
    public void addition(Polynomial other)
    {
        Polynomial result = new Polynomial();
        Monomial temp = null;
        while(terms.hasNext())
        {
          if(terms.next().equals(other.terms.next()))//if exponents & coefficients are alike
                {
                    temp.setDegree(terms.next().getDegree()+other.terms.next().getDegree()); //keep track of exponents

                        result.terms.next().setDegree(temp.getDegree()); //add terms to result                        
            }
          else if(terms.next().getDegree()<other.terms.next().getDegree()) //check for lesser degree of the two
          {
              result.terms.next().setDegree(terms.next().getDegree()); //update the result 
          }
          else 
          {
              result.terms.next().setDegree(other.terms.next().getDegree());
          }
        }
  
    }
    
    /**
     *
     * @param other
     * @return sum of polynomials
     */
    public Polynomial sum(Polynomial other)
    {
       Polynomial temp = new Polynomial();
       while(terms.hasNext())
       {
           terms.next().getCoeff();
       }
        return other;
    }
 
    /**
     *
     * @param constant
     */
    public void timesConst(double constant)
    {
        
    }
    
    /**
     *
     * @param constant
     * @return
     */
    public Polynomial constProduct(double constant)
    {
      Polynomial product = null;
      return product;
      
    }    
    
    /**
     *
     * @param other
     * @return
     */
    public Polynomial product(Polynomial other)
    {
        return other;
    }
    
    @Override
    public String toString()
    {
        StringBuilder ts =new StringBuilder();
        return ts.toString();
    }

   
}
