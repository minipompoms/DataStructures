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
     * @throws polynomial.NotFoundException
     */ 
    public void addition(Polynomial other) throws NotFoundException 
    {       
        if (terms == null) //throws an exception if input is empty
        {
            throw new IllegalArgumentException("cannot add an empty list");
        }    
             Polynomial s = sum(other);    
             s.terms = other.terms;

    }
    
    /**
     * 
     * @param other
     * @return sum of polynomials, original remains unaltered
     * @throws polynomial.NotFoundException
     */
    public Polynomial sum(Polynomial other) throws NotFoundException 
    {
        if (terms == null) //throws an exception for a null entry
        {
            throw new IllegalArgumentException("Cannot add an empty list");
        }
        
       Polynomial result; //new polynomial to be returned
       
       Polynomial x = new Polynomial(); //holds values to keep traversing
    
       while (other.terms.hasNext()) //while traversing other polynomial
       {
           x.addTerm(other.terms.next());  //add values to the temp polynomial    
       }

       while(terms.hasNext()) //traverse values in current polynomial
       {
           x.addTerm(terms.next()); //adds value to temp
       }
   
       result = likeTerms(x); //assigns values in polynomial to be returned
    return result; 
    }
 
    /**
     * multiplies by constant & changes its value
     * @param constant
     */
    public void timesConstant(double constant)           
    {
        
         Polynomial p = constantProduct(constant); //new polynomial
         while(terms.hasNext())
         {
            
            Monomial m = terms.next(); //retrieve values
            double coeff = m.getCoeff(); //to hold the terms
            int exponent = m.getDegree();    
            coeff*=constant; //multiply constant by value 
            m.setCoeff(coeff); //set values
            m.setDegree(exponent);  
            Monomial temp = new Monomial(exponent, coeff); //temporary monomial to hold values
            p.addTerm(temp); //apply & changes values
            
         }
      
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
             
            Monomial m = terms.next(); //retrieve term
            double coeff = m.getCoeff(); //hold values
            int exponent = m.getDegree();    
            coeff *= constant; //multiply constant by value 
            Monomial temp = new Monomial(exponent,coeff); //create new monomial for insertion          
            p.addTerm(temp); //apply to the new instance
         
         }
      return p;//product is returned    
    }    
    
    /**
     * multiplies given instance by another polynomial
     * @param other
     * @return new polynomial value
     * @throws polynomial.NotFoundException
     */
    public Polynomial product(Polynomial other) throws NotFoundException
    {
        Polynomial poly = new Polynomial();
     
        while (terms.hasNext())
        {           
            Monomial m = terms.next(); //retrieve & hold values of first LL
            int exp = m.getDegree();
            double coeff = m.getCoeff(); //holds the values in order to reset
                         
            while(other.terms.hasNext())
            {
                Monomial o = other.terms.next();   //retrieve & hold value of other LL
                Monomial term = new Monomial(1,1); //temp monomial to hold insert term
              
                term.setCoeff(coeff*=o.getCoeff());
                term.setDegree(exp+=o.getDegree());
                poly.addTerm(term);             //add the product to the new list
                coeff = m.getCoeff();
                exp = m.getDegree();
             
            }             
        }
        poly = likeTerms(poly);
        return poly;
    }
    
    /**
     * combines like terms
     * @param other
     * @return new polynomial with combined like terms 
     * @throws NotFoundException
     */
    public Polynomial likeTerms(Polynomial other) throws NotFoundException
    {
        
        Polynomial result = new Polynomial();   //polynomial to be returned
        Monomial monomial = other.terms.next(); //to hold monomial 
        Monomial temp = null;                   //to hold last value
        double coeff = monomial.getCoeff();
        int exp = monomial.getDegree();         //holds values for iteration
     
        while (other.terms.hasNext()) //if there are terms in polynomial
        {   
          
           Monomial m = other.terms.next(); //checks next monomial
              
           if(m.getDegree() == exp) //check if they're a match
           {                   
                coeff +=m.getCoeff(); //add the coefficents to combine               
           }  
      
        monomial.setCoeff(coeff); 
        monomial.setDegree(exp);  //assign values, prepare to check next element
       
         
            if (m.getDegree()!= exp) //if degree is no match to previous value
            {
               
                result.addTerm(monomial); //list is sorted, so add monomial to new list       
                coeff = m.getCoeff(); //assign coeff to current coeff
                monomial = m; //
                m = monomial;
                exp = monomial.getDegree();
             
            if (monomial.isEquivlent(m))
            {
                temp = m;  
                
            }               
            }

        }
        result.addTerm(temp);
        
        return result;
    }
    
    
    @Override
    public String toString()
    {
        StringBuilder ts =new StringBuilder();
        
        ts.append((" "));
        if (terms == null)
        {
            ts.append("no values");
        }
         
        else   { 
           
           ts.append(terms.next());
            while (terms.hasNext())
            {   
                Monomial m = terms.next(); 
                double coeff = m.getCoeff();
               
                if(coeff > 0)
                {
                 ts.append(" +").append(m);

                }
                if (coeff < 0)
                {
                    ts.append(" ").append(m).append("");
                }
            }       
            }

        return ts.toString();
    }
    
    
}
