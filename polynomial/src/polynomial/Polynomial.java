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
        
        if (terms == null)
        {
            throw new IllegalArgumentException("cannot add an empty list");
        }
       
        Polynomial x = sum(other);      
        other.terms = x.terms;

    }
    
    /**
     * 
     * @param other
     * @return sum of polynomials, original remains unaltered
     * @throws polynomial.NotFoundException
     */
    public Polynomial sum(Polynomial other) throws NotFoundException 
    {
        if (terms == null)
        {
            throw new IllegalArgumentException("Cannot add an empty list");
        }
       
       Polynomial result; //new polynomial to be returned
       
       Polynomial x = new Polynomial(); //holds values to keep traversing
    
       while (other.terms.hasNext())
       {
           x.addTerm(other.terms.next());      
       }

       while(terms.hasNext())
       {
           x.addTerm(terms.next());
       }
   
       result = likeTerms(x);
    return result;
    }
 
    /**
     * multiplies by constant & changes its value
     * @param constant
     */
    public void timesConstant(double constant)           
    {
        
        Polynomial p = constantProduct(constant);
         while(terms.hasNext())
         {
            
            Monomial m = terms.next(); //retrieve values
            double coeff = m.getCoeff();
            int exponent = m.getDegree();    
            coeff*=constant; //multiply constant by value 
            m.setCoeff(coeff); //set values
            m.setDegree(exponent);  
            p.addTerm(new Monomial(exponent, coeff)); //apply & changes values
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
             
            Monomial m = terms.next(); //retrieve values
            double coeff = m.getCoeff();
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
            ts.append("Empty List");
        }
        else           
            while (terms.hasNext())
            {    
                ts.append(terms.next()).append("  ");           
            }
        return ts.toString();
    }
    
    
}
