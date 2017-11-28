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
     * @param term monomial to be inserted
     */
    public void addTerm(Monomial term)
    {
        terms.insert(term);
        
    }
    
    /**
     * 
     * @param other Polynomial to be added
     * to add another polynomial to the given instance
     * @throws polynomial.NotFoundException
     */ 
    public void addition(Polynomial other) throws NotFoundException 
    {       
        if (terms == null) //throws an exception if input is empty
        {
            throw new IllegalArgumentException("cannot add an empty list");
        }   
        Polynomial a = new Polynomial(); // retain original not to lose original
        a.terms = other.terms;          // copy values

        Polynomial b = new Polynomial();
        b.terms = terms;
       
             Polynomial s = sum(a);     // uses sum method to perform addition 

             other.terms = s.terms;     // reassigns given instance with summed values
    }
    
    /**
     * 
     * @param other - Polynomial to be added
     * @return - sum of polynomials, original remains unaltered
     * @throws polynomial.NotFoundException
     */
    public Polynomial sum(Polynomial other) throws NotFoundException 
    {
        if (terms == null) //throws an exception for a null entry
        {
            throw new IllegalArgumentException("Cannot add an empty list");
        }
        Polynomial a = new Polynomial(); //retain original polynomial 
        Polynomial b = new Polynomial();
        a.terms = other.terms;           //copy values
        b.terms = terms;
          
      
       Polynomial x = new Polynomial(); //new polynomial to be returned
      
        while(a.terms.hasNext()) //while traversing other polynomial
       {
           x.addTerm(a.terms.next());  //add values to the temp polynomial    
       }

        while(b.terms.hasNext()) //traverse values in current polynomial
       {       
           x.addTerm(b.terms.next());         
       }

        x = likeTerms(x);
        
        return x; 
    }
 
    /**
     * multiplies by constant & changes its value
     * @param constant double to be multiplied by
     */
    public void timesConstant(double constant)           
    {
        
         Polynomial p = constantProduct(constant); //new polynomial
         while(terms.hasNext())
         {
            
            Monomial m = terms.next();                      //retrieve values
            double coeff = m.getCoeff();                    //to hold the terms
            int exponent = m.getDegree();    
            coeff*=constant;                                //multiply constant by value 
            m.setCoeff(coeff);                              //set values
            m.setDegree(exponent);  
            Monomial temp = new Monomial(exponent, coeff);  //temporary monomial to hold values
            p.addTerm(temp);                                //apply & changes values
            
         }
      
    }
    
    /**
     * multiplication by constant with original value unchanged
     * @param constant double to be multiplied by
     * @return - product of polynomial * constant
     */
    public Polynomial constantProduct(double constant)
    {
        Polynomial p = new Polynomial(); //new instance of polynomial
        
         while(terms.hasNext())
         {
             
            Monomial m = terms.next();                   //retrieve term
            double coeff = m.getCoeff();                 //hold values
            int exponent = m.getDegree();    
            coeff *= constant;                            //multiply constant by value 
            Monomial temp = new Monomial(exponent,coeff); //create new monomial for insertion          
            p.addTerm(temp);                              //apply to the new instance
         
         }
      return p;     //product is returned    
    }    
    
    /**
     * multiplies given instance by another polynomial
     * @param other Polynomial that will be multiplied by
     * @return - product of polynomial * other
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
              
                term.setCoeff(coeff*=o.getCoeff()); //set the coeff 
                term.setDegree(exp+=o.getDegree()); //set the exponent
                poly.addTerm(term);                 //add the product to the new list
                coeff = m.getCoeff();               //retrieve values to compare to next
                exp = m.getDegree();            
             
            }             
        }
        poly = likeTerms(poly);         //combine like terms
        return poly;                    //new polynomial returned
    }
    
    /**
     * combines like terms
     * @param other Polynomial to be returned
     * @return - the simplified polynomial 
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
                monomial = m;       // increment references
                m = monomial;
                exp = monomial.getDegree(); //retrieve exp to compare next
             
            if (monomial.isEquivlent(m))
            {
                temp = m;  //if exponent is already in list, move to next 
                
            }               
            }

        }
        result.addTerm(temp); //add the term to the polynomial that will be returned
        
        return result; //returns polynomial 
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
