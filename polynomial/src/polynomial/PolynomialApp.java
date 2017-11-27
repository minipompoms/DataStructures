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
       //Monomial r = new Monomial (3,6);
//       
//       polyA.addTerm(new Monomial(3,4));
//       polyA.addTerm(new Monomial(2,4));
//       polyA.addTerm(new Monomial(2,1));
//              polyB.addTerm(new Monomial(3,3));
//       polyB.addTerm(new Monomial(3,1));
//       polyB.addTerm(new Monomial(3,2));
//       System.out.println("beforeA"+polyA);
//       System.out.println("beforeB"+polyB);
//     polyA.addition(polyB);
//       
//        System.out.println("AfterA"+polyA);
//       System.out.println("AfterB"+polyB);
       //System.out.println("Sum"+S);

      
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
                       System.out.println("Insert another term or enter X to return to menu");
                       
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
                       System.out.println("Insert another term or enter X to return to menu");
                       
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
                       
                       Monomial term = addTerm();
                       Polynomial toAdd = new Polynomial();
                       toAdd.addTerm(term);
                       System.out.println("Which polynomial would you like to add?" + term);

                       System.out.println("Enter A or B"); 
                       
                       String select = input.next();
                       if (select.equalsIgnoreCase("a"))
                       {
                           System.out.println(" "+polyA + "\n+ " + term);
                           toAdd.addition(polyA);                          
                           System.out.println("="+polyA);
                       }
                       if (select.equalsIgnoreCase("b"))
                       {
                           System.out.println(" "+polyB + "\n+ " + term);
                           toAdd.addition(polyB);
                           System.out.println("="+polyB);
                       }
                           
                   exit = 'x';
                   }
                   exit = 0;
               break;
               
               case 4:
                  while (exit != 'x')
                  {

                       System.out.println("   " + polyA + "\n + " + polyB);
                       Polynomial tempA = polyA; 
                       Polynomial tempB = polyB;//to retain original values
                       Polynomial s = polyA.sum(polyB); //assign variable to sum
                       System.out.println(" = " + s);
                       polyA = tempA;
                       polyB = tempB; //reassign originals
                       
                       exit = 'x';                          
                  }
                  exit =0;
                  
               break; 
               
               case 5:
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
               
               case 6:
                   while (exit != 'x')
                   {
 
                        System.out.println("   " + polyA + "\n * " + polyB);
                        Polynomial p = polyA.product(polyB);
                        System.out.println(" = " + p);
                        exit = 'x';
                   }
                    exit = 0;
               break;
               
               case 7:
                   
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
       catch(NullPointerException e)
       {
           System.out.println("null");
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
                           "\n3. Add a term to a given polynomial" +
                           "\n4. Sum two polynomials" +
                           "\n5. Multiply a polynomial by a constant" +
                           "\n6. Muliply two polynomials" +
                           "\n7. Remove a term" +
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
