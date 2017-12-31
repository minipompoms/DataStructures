
package polynomial;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author pkohn
 */
public class PolynomialApp  
{ 
    /**
     *
     * @param args
     */
    private static final Scanner input = new Scanner(System.in);
    
    /**
     *
     * @param args
     */
    public static void main (String[] args) 
    {
       Polynomial polyA = new Polynomial(); //create instance 
       Polynomial polyB = new Polynomial(); //another for a second polynomial

      
       System.out.println("\tSTART");
       
       int choice;          // menu input
       char exit;           //check to continue inputs
       
       
       do{      
           exit = 0;
           choice = menu(); //get input from menu
           try{
           
           switch(choice)
           {
               case 1:
                   
                   while (exit != 'x')
                   {
                      Monomial m = addTerm();
                      polyA.addTerm(m);
                      System.out.println("Enter x to return to menu or another key to continue");
                      exit = handleInsertTerm(polyA);
                   }        
                   exit = 'x';               
               break;
               
               case 2:
                  
                   while (exit != 'x')
                   {
                      Monomial mm = addTerm();                    
                      polyB.addTerm(mm); 
                      System.out.println("Enter x to return to menu or another key to continue");
                      exit = handleInsertTerm(polyB);                     
                   }
                   exit = 'x';
               break;
               
               case 3:                     
                      addATerm(polyA, polyB);                          
                      exit = 'x';                                    
               break;
               
               case 4:                 
                    sumPolynomials(polyA,polyB);                       
                    exit = 'x';                                                    
               break; 
               
               case 5:
                    multiplyConstant(polyA, polyB);
                    exit = 'x';                                                         
               break;
               
               case 6:                   
                    multiplyPolys(polyA, polyB);
                    exit = 'x';                                     
               break;
               
               case 7:
                   removeTerm(polyA, polyB);   
                   exit = 'x';
               break;   
               
               case 0:
                   System.out.println("\n\tGOODBYE");
                   System.exit(0);    
               break;
              
           }
          
       }catch(IllegalArgumentException iae)
       {
           System.out.println("Invalid Entry: exponent must be a positive number" + iae);
       }
        catch(NotFoundException nfe)
        {
            System.out.println(" error: ");
        }
       catch(NullPointerException npe)
       {
           System.out.println("error:  " + npe);
       }
       catch(InputMismatchException ime)
       {
           System.out.println("Invalid Input");
       }
       
       }while(choice != 0 && exit !=0);
    
    }
    
    /**
     *
     * @return
     */
    public static int menu()
    {
        int answer; //menu choice
        
        System.out.println("\n1. Insert a term" + 
                           "\n2. Add a second polynomial" +
                           "\n3. Add a term to a given polynomial" +
                           "\n4. Sum two polynomials" +
                           "\n5. Multiply a polynomial by a constant" +
                           "\n6. Muliply two polynomials" +
                           "\n7. Remove a term" +
                           "\n0. Exit");
        answer = input.nextInt();
       
        while(answer < 0 || answer > 7 )
        {
            System.out.println("PLEASE ENTER A VALID OPTION");
            answer = input.nextInt();
        }
        
        return answer;
    }
    
    /**
     *
     * @return  a new monomial term
     */
    public static Monomial addTerm()
    {
        System.out.println("ENTER A TERM\n");
        System.out.println("\tCoefficient:");
        double coeff = input.nextDouble();
        System.out.println("\tExponent:");
        int exp = input.nextInt();
        Monomial monomial = new Monomial(exp, coeff); //creates a new monomial
                        
        return monomial;
    }
    
    /**
     *
     * @param x the Polynomial list referenced
     * @return char option to exit menu
     */
    public static char handleInsertTerm(Polynomial x)
    {
        char exit = input.next().charAt(0);
        
            if (exit == 'x')
            {
                System.out.println(x); 
            }          
        return exit;
    }
    
    /**
     *
     * @param a the Polynomial list a
     * @param b the Polynomial list b
     * @return String input
     */
    public static String addATerm(Polynomial a, Polynomial b)
    {
        
        Monomial term = addTerm();
        Polynomial toAdd = new Polynomial();
        toAdd.addTerm(term);
        System.out.println("Which polynomial would you like to add?" + term);
        System.out.println("Enter A or B");
        
        String select = input.next();
        
        if (select.equalsIgnoreCase("a"))
        {                      
            System.out.println(" "+ a + "\n+ " + term);
            try {                          
                toAdd.addition(a);
            } catch (NotFoundException ex) {
                System.out.println("error: " + ex);
            }
            System.out.println("="+ a);
        }
                       
        if (select.equalsIgnoreCase("b"))
        {
            try {
                System.out.println(" "+ b + "\n+ " + term);
                toAdd.addition(b);
                System.out.println("="+ b);
            } catch (NotFoundException ex) {
                System.out.println("error: " + ex);
            }
        }
        
        return select;
    }
    
    /**
     *
     * @param a the Polynomial list a
     * @param b the Polynomial list b
     * @throws NotFoundException
     */
    public static void sumPolynomials(Polynomial a, Polynomial b) throws NotFoundException
    {
        System.out.println("   " + a + "\n + " + b);
        Polynomial s = a.sum(b); //assign variable to sum
        System.out.println(" = " + s);     
    }
    
    /**
     *
     * @param a the Polynomial list a
     * @param b the Polynomial list b
     */
    public static void multiplyConstant(Polynomial a, Polynomial b)
    {
            System.out.println("Which polynomial would you like to multiply by?");
            System.out.println("Enter A or B");
            String select = input.next();
            
            System.out.println("Enter the constant:");
            double constant = input.nextDouble();
            if (select.equalsIgnoreCase("a"))
            {  
              System.out.println(" " + a + "\n*    " + constant);
              a.timesConstant(constant);
              System.out.print("=" + a +"\n");    
            }
            
            if (select.equalsIgnoreCase("b"))
            {  
              System.out.println(" " + b + "\n*    " + constant);
              b.timesConstant(constant);
              System.out.print("=" + b +"\n");    
            }
    }
    
    /**
     *
     * @param a the Polynomial list a
     * @param b the Polynomial list b
     * @throws NotFoundException if no elements are on either list
     */
    public static void multiplyPolys(Polynomial a, Polynomial b) throws NotFoundException
    {       
        System.out.println("   " + a + "\n * " + b); 
        Polynomial p = a.product(b); 
        System.out.println(" = " + p);
    }
    
    /**
     *
     * @param a the Polynomial list a
     * @param b the Polynomial list b
     * @throws NotFoundException if either list contains no elements
     */
    public static void removeTerm(Polynomial a, Polynomial b) throws NotFoundException
    {
        System.out.println("Enter the coefficient of the value you would like to remove");
        double coeff = input.nextDouble();
        System.out.println("Enter the exponent of the value you would like to remove");
        int exp = input.nextInt();
        Monomial toRemove = new Monomial(exp, coeff);
        System.out.println("From which polynomial would you like to remove a term?");
        System.out.println("Enter A or B");             
        String select = input.next();
                   
        if (select.equalsIgnoreCase("a"))
        {
            a.removeTerm(toRemove);
            System.out.println(toRemove + " was removed\n\n"+ a);
        }
                   
        if (select.equalsIgnoreCase("b"))
        {
            b.removeTerm(toRemove);
            System.out.println(toRemove+" was removed\n\n"+ b);
        }
    }
}
