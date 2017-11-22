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
            throw new IllegalArgumentException("empty list");
        }
       sum(other); //adds values by calling sum method
       
        //calls list and modifies 
       
    }
    
    /**
     * 
     * @param other
     * @return sum of polynomials, original remains unaltered
     * 
     */
    public Polynomial sum(Polynomial other) throws NotFoundException 
    {
        if (terms == null)
        {
            throw new IllegalArgumentException("empty list");
        }
       
       Polynomial result; //new polynomial to be returned
       
       Polynomial x = new Polynomial();
       while (other.terms.hasNext())
       {
           x.addTerm(other.terms.next());
           
       
       }
       //x = likeTerms(x);
                while(terms.hasNext())
       {
           x.addTerm(terms.next());
       }
       
     
      
       result = likeTerms(x);
       
         System.out.println("after like terms: " +x);
       

//        while(terms.hasNext())
//        {
//            
//            Monomial temp = terms.next();
//            Monomial m = temp; 
//            //System.out.println("From tom - temp value:"+temp);
//            //System.out.println("poly value:"+ poly);
//            //System.out.println("m value :"+m+"\n");
//            while(other.terms.hasNext())
//            {
//            Monomial poly = other.terms.next(); //to hold terms of other polynomial
//           
//            if(temp.isEquivlent(poly))//if exponents share same term
//            {   
//                
//                
//                poly.setCoeff(m.getCoeff()+poly.getCoeff()); //assign coefficient 
//                poly.setDegree(poly.getDegree()); //assign degree
//               
////                System.out.println("temp value:"+temp);
////                System.out.println("poly value:"+ poly);
////                System.out.println("m value :"+m+"\n");
//               
//                m.setCoeff(0);
//                m.setDegree(0);
//                temp = poly;  //set value to next
//       
//                result.addTerm(poly); //add value to new polynomial list
//                
//
//            }
//            
//           if(!temp.isEquivlent(poly)) //to check if exponents are not a match
//            {    
//              result.addTerm(poly); //update the new polynomial to include the terms             
//              //result.addTerm(temp);
//              temp = poly;
//              
//            
//            }
//            
//            
//            }
//       
//            
//        }
    return result;
    }
 
    /**
     * multiplies by constant & changes its value
     * @param constant
     */
    public void timesConstant(double constant)           
    {
        //fix here
        Polynomial p = constantProduct(constant);
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
            m.setCoeff(coeff); //set values
            m.setDegree(exponent);  
            p.addTerm(new Monomial(exponent, coeff)); //apply to the new instance
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
       //fix algorithm
        while (terms.hasNext())
        {           
            Monomial m = terms.next(); //retrieve values
                    
            double coeff = m.getCoeff();
            int exponent = m.getDegree();
            
            m.setCoeff(coeff); //set values
            m.setDegree(exponent);  
           
            p.addTerm(new Monomial(exponent, coeff));           
        }
        return other;
    }
    
    public Polynomial likeTerms(Polynomial other) throws NotFoundException
    {
         
  
        Polynomial x = new Polynomial();
        Monomial monomial = other.terms.next();
        Monomial temp = null; //holds last value
        double coeff = monomial.getCoeff();
        int exp = monomial.getDegree();
       
        
        
        while (other.terms.hasNext()) //if there are terms in polynomial
        {   
           
           Monomial m = other.terms.next(); //checks next monomial
              
           if(m.getDegree() == exp) //check if they're a match
           {                   
                coeff +=m.getCoeff(); //add the coefficents to combine               
           }  
      
        monomial.setCoeff(coeff);
        monomial.setDegree(exp);
       
         
            if (m.getDegree()!= exp)
            {
               
                x.addTerm(monomial);        
                coeff = m.getCoeff();
                monomial = m;
                m = monomial;
                exp = monomial.getDegree();

            if (monomial.isEquivlent(m))
            {
                temp = m;             
            }               
            }
   
        }
        x.addTerm(temp);
        return x;
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
