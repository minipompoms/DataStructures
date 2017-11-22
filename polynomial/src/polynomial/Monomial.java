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
public class Monomial implements Comparable<Monomial>{
    
    private int degree; //degree of the term
    private double coeff; //coefficient of the term
  
    
    /**
     * constructor
     * @param degree exponent of the value
     * @param coeff coefficient of the term
     */
    public Monomial(int degree, double coeff) 
    {
        if (degree < 0 || coeff < 1)
        {
            throw new IllegalArgumentException("Invalid Entry: exponent must be positive");
        }
        this.degree = degree;
        this.coeff = coeff;       
    }

    /**
     *
     * @return
     */
    public int getDegree() 
    {
        return degree;
    }

    /**
     *
     * @param degree
     */
    public void setDegree(int degree) 
    {
        this.degree = degree;
    }

    /**
     *
     * @return
     */
    public double getCoeff() 
    {
        return coeff;
    }

    /**
     *
     * @param coeff
     */
    public void setCoeff(double coeff) 
    {
        this.coeff = coeff;
    }
    
 
    public boolean equals(Monomial other) 
    {
        return degree == other.degree && coeff == other.coeff;
    }
    
    public boolean isEquivlent(Monomial other)
    {
        return degree == other.degree;
       
    }

    /**
     *
     * @param other
     * @returns 
     */
    @Override
    public int compareTo(Monomial other) 
    {   
        Integer exp = other.degree;       
        return exp.compareTo(this.degree); 
    }
    
    @Override
    public String toString()
    {
        
        StringBuilder ts = new StringBuilder();
        ts.append(" : ");
      
        ts.append(this.coeff).append("x^").append(this.degree);
//        if (this.coeff ==1)
//        {    
//            if (this.degree == 1)
//            {
//                ts.append(this.coeff);
//            }
//            ts.append("x").append("^").append(this.degree);
//        }
//        else if (this.degree > 1)         
//        {
//            ts.append(this.coeff);
//            ts.append("x^").append(this.degree).append(" ");
//        }
        ts.append(" : ");
        return ts.toString();
    }  
}
