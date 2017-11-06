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
        if (degree < 0)
        {
            throw new IllegalArgumentException("Invalid: exponent must be positive");
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

    /**
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Monomial other) 
    {   
        
        
        return 0;
    }
    
    @Override
    public String toString()
    {
        StringBuilder ts = new StringBuilder();
        ts.append(this.coeff);
        if (this.degree == 1)
        {
            ts.append("x");
        }
        if (this.degree > 1)
        {
            ts.append("x^").append(this.degree).append(" ");
        }
        return ts.toString();
    }  
}
