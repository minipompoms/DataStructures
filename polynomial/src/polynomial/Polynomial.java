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
         if (terms == null)
        {
            throw new IllegalArgumentException("empty list");
        }
       sum(other); //adds values by using addition method
       
        //calls list and modifies 
       
    }
    
    /**
     * 
     * @param other
     * @return sum of polynomials, original remains unaltered
     */
    public Polynomial sum(Polynomial other)
    {
        if (terms == null)
        {
            throw new IllegalArgumentException("empty list");
        }
        
        Polynomial result = new Polynomial(); //new polynomial to be returned
       
        while(terms.hasNext())
        {
            Monomial temp = terms.next();
            Monomial oPoly = other.terms.next(); //to hold terms of other polynomial
            
            if(temp.getDegree() == oPoly.getDegree())//if exponents share same term
            {                
                temp.setCoeff(temp.getCoeff()+ oPoly.getCoeff()); //assign coefficient 
                result.addTerm(temp); //add terms to result 
               
            }
            
            else if(temp.getDegree() < oPoly.getDegree() || temp.getDegree()> oPoly.getDegree()) //check for lesser degree of the two
            {
              result.addTerm(oPoly);
              result.addTerm(temp); //update the new polynomial to include the terms

            }
//            else 
//            {
//              result.addTerm(temp);
//              System.out.println("x: "+result.toString());
//
//            }
        }
    return result;

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
        
         while(terms.hasNext())
         {
            Monomial m = terms.next(); //retrieve values
            double coeff = m.getCoeff();
            int exponent = m.getDegree();    
            coeff*=constant; //multiply constant by value 
            m.setCoeff(coeff); //set values
            m.setDegree(exponent);  
            p.addTerm(new Monomial(exponent, coeff)); //apply to the new instance
         }

             
 
           
           
       
            
          //p.terms.next().setDegree(terms.next().getDegree()); //with constant degree is unchanged
      
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
        ts.append((" polys: "));
   
        while (terms.hasNext())
        {
            
            ts.append(terms.next()).append("  ");           
        }
        return ts.toString();
    }
    
   
}
