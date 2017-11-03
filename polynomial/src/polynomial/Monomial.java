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
     *
     * @param degree
     * @param coeff
     */
    public Monomial(int degree, double coeff) 
    {
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
    
    @Override
    public boolean equals(Object obj) 
    {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Monomial o) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
