/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

import java.util.Scanner;

/**
 *
 * @author Paige
 */
public class PolynomialApp  {
    
    /**
     *
     * @param args
     * @throws NotFoundException
     */
    public static void main (String[] args) throws NotFoundException
    {
       Polynomial polyA = new Polynomial(); //create instance 
       Polynomial polyB = new Polynomial(); //for other polynomial
       Monomial r = new Monomial (2,3);
       
       polyA.addTerm(new Monomial(6,4));
       polyA.addTerm(r);
       polyA.addTerm(new Monomial(4,1));
       
       System.out.println("before"+polyA);
        polyA.terms.remove(r);
        System.out.println("r"+polyA);
        
//       polyB.addTerm(new Monomial(3,3));
//       polyB.addTerm(new Monomial(3,4));
      
       System.out.println("\tSTART");
       Scanner input = new Scanner(System.in);
       int choice;     // menu input
       char exit = 0;     //check to continue inputs
       
       
       do{      
          
           choice = menu(); //get input from menu
           try{

           switch(choice)
           {
               case 1:
                   while(exit != 'x')
                   {
                       Monomial m = addTerm();
                       polyA.addTerm(m);
                       System.out.println("Insert another term or enter X to exit");
                       
                       exit = input.next().charAt(0);
                       if (exit == 'x')
                       {
                           System.out.println(polyA);
                           exit = 'x';
                       }
  
                   }
                   
                   exit = 0;
                  
               break;
               
               case 2:
                   
                   while (exit != 'x')
                   {
                       Monomial m = addTerm();                    
                       polyB.addTerm(m); 
                       System.out.println("Insert another term or enter X to exit");
                       
                       exit = input.next().charAt(0);
                       if (exit =='x')
                       {
                           System.out.println(polyB);
                       }                      
                   }
                   exit = 0;
               break;
               
               case 3:
                  while (exit != 'x')
                  {

                       System.out.println("   " + polyA + "\n + " + polyB);
                       Polynomial s = polyA.sum(polyB);
                       System.out.println(" = " + s);
                       exit = 'x';                          
                  }
                  exit =0;
                  
               break; 
               
               case 4:
                  while(exit != 'x')
                  {
                        System.out.println("Enter the constant you would like to multiply by:");
                        double constant = input.nextDouble();
                        System.out.println(" " + polyA + "\n*    " + constant);
                        polyA.timesConstant(constant);
                        System.out.print("=" + polyA +"\n");
                        exit = 'x';                    
                  }
                  exit = 0;     
               break;
               
               case 5:
                   while (exit != 'x')
                   {
 
                        System.out.println("   " + polyA + "\n * " + polyB);
                        Polynomial p = polyA.product(polyB);
                        System.out.println(" = " + p);
                        exit = 'x';
                   }
                    exit = 0;
               break;
               
               case 6:
                   
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
                     polyA.terms.remove(toRemove);
                       System.out.println(toRemove + "removed\n"+polyA);
                   }
                   if (select.equalsIgnoreCase("b"))
                   {
                       polyA.terms.remove(toRemove);
                       System.out.println(toRemove+"removed\n"+polyB);
                   }
                       
               break;        
               case 0:
                   System.out.println("\n\tGOODBYE");
                   System.exit(0);    
           
           }
       }catch(IllegalArgumentException e)
       {
           System.out.println("Invalid Entry: exponent must be a positive number");
       }
        catch(NotFoundException e)
        {
            System.out.println("No such value");
        }
          
       }while(choice != 0);
        
    }
    
    /**
     *
     * @return
     */
    public static int menu()
    {
        Scanner input = new Scanner(System.in);
        
        int answer; //menu choice
        
        System.out.println("\n1. Insert a term" + 
                           "\n2. Add a second polynomial" + 
                           "\n3. Sum two polynomials" +
                           "\n4. Multiply a polynomial by a constant" +
                           "\n5. Muliply two polynomials" +
                           "\n6. Remove a term" +
                           "\n0. Exit");
        answer = input.nextInt();
                
        while(answer < 0 || answer > 6)
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
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER A TERM\n");
        System.out.println("\tCoefficient:");
        double coeff = input.nextDouble();
        System.out.println("\tExponent:");
        int exp = input.nextInt();
        Monomial monomial = new Monomial(exp, coeff); //creates a new monomial
                        
        return monomial;
    }
    
    
}
