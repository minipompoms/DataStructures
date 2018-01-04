
package trees;

import java.util.*;

/**
 *
 * @author pkohn
 */
public class TreesApp {

    /**
     * 
     *@param args the command line arguments
     */
    private static final Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
       
       
        BinarySearchTree<Character> tree = new BinarySearchTree();
       
        
        char ch = 1;
        System.out.println("Enter any character, or press '0' to EXIT at anytime");
        
        while(ch != 0)   
        {
            ch = input.next().charAt(0);
            if (ch == '0')               
            {
                break;
            }
            else
            {
                tree.insert(ch);
                System.out.println("Enter any character:");
            }
            
//            if (ch != '0')                //I tried doing it this way, 
                                            //but it doesn't break out of the loop
//            {
//                 tree.insert(ch);
//                System.out.println("Enter any character:");
//            }
        }
        
        
        System.out.println("    CURRENT TREE:   ");
        tree.printTree();
           
        System.out.println("Enter 'T' if you would like to display all values in the tree");
        System.out.println("Enter 'V' if you would like to see specific duplicates");
        System.out.println("Enter 'R' if you would like to remove a character");
        
        String select = input.next();
        do{
            if (select.equalsIgnoreCase("T"))
            {
                tree.printTree();
            }

            
            else if (select.equalsIgnoreCase("V"))
            {
                displayDuplicates(tree);
            }
            
            else if (select.equalsIgnoreCase("R"))
            {
                remove(tree);            
            }            
        
            else
            {
                System.out.println("Invalid Entry: Try again");
                select = input.next();
            }
            
        }while(!("T".equalsIgnoreCase(select)|| "V".equalsIgnoreCase(select) 
                || "R".equalsIgnoreCase(select)));
       
 
    }
    
   
    public static void displayDuplicates(BinarySearchTree<Character> tree)
    {
        System.out.println("Enter the character to see the duplicate count");
        char ch = input.next().charAt(0);
        System.out.println("There are " + tree.getDuplicates(ch)+
                    " duplicates of " +ch);             
    }
    
    
    public static void remove(BinarySearchTree<Character> tree)
    {       
        System.out.println("Enter the character to remove");
        char ch = input.next().charAt(0);
        if (tree.contains(ch) == false)
        {
            System.out.println("No such character exists.");
            
        }
        else 
        {
            tree.remove(ch);
            System.out.println(ch + " has been removed. and now has " 
                + tree.getDuplicates(ch) + "duplicates");
            tree.printTree();
        }
    }
    
}
