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
     * 
     * @param other
     * to add another polynomial to the given instance
     */ 
    public void addition(Polynomial other)
    {
       sum(other); //adds values by using addition method
       
       terms.setFirst(); //calls list and modifies 
       
    }
    
    /**
     * 
     * @param other
     * @return sum of polynomials, original remains unaltered
     */
    public Polynomial sum(Polynomial other)
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
        return other;
    }
 
    /**
     * multiplies by constant & changes its value
     * @param constant
     */
    public void timesConstant(double constant)           
    {
        Polynomial product = constantProduct(constant);
        terms.setFirst();
                
        
    }
    
    /**
     * multiplication by constant with original value unchanged
     * @param constant
     * @return product of polynomial
     */
    public Polynomial constantProduct(double constant)
    {
      Polynomial p = new Polynomial(); //new instance of polynomial
      
      while(terms != null) //loop until all values are read
      {        
          p.terms.next().setCoeff(terms.next().getCoeff()*constant); //multiply constant by value
          p.terms.next().setDegree(terms.next().getDegree()); //with constant degree is unchanged
      }
      return p;//product is returned    
    }    
    
    /**
     * multiplies given instance by another polynomial
     * @param other
     * @return new polynomial value
     */
    public Polynomial product(Polynomial other)
    {
        Polynomial p = new Polynomial();
        double tempCoeff = 0;
        int tempExponent = 0;
        
        while (terms != null)
        {           
            tempCoeff *= other.terms.next().getCoeff();
            tempExponent += other.terms.next().getDegree();
            p.terms.next().setCoeff(tempCoeff);
            p.terms.next().setDegree(tempExponent);
                       
        }
        return other;
    }
    
    
    @Override
    public String toString()
    {
        StringBuilder ts =new StringBuilder();
        ts.append(("terms:"));
        if (terms.size()>0)
        {  
            for(int ix = 0; ix<terms.size(); ++ix)
            {
                ts.append(terms.next().toString());
            }
        
        }   
            
            
        
        
        /*while (terms.hasNext())
            {
               ts.append(terms.next()).append(" \n");            
            }
       */
        return ts.toString();
        
    }
    
   
}
