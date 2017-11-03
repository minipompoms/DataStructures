/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlists;



/**
 *
 * @author Paige Kohn
 */
public class LLI_App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LLI testList = new LLI();
    
      
        testList.insertFirst(1);
        System.out.println(testList.toString());
        testList.insertFirst(3);
        System.out.println(testList.toString());
        testList.insertFirst(4);
        System.out.println(testList.toString());
        testList.insertAfter(4, 16);
        System.out.println(testList.toString());
        testList.insertAfter(16, 32);
        System.out.println(testList.toString());
        testList.insertAfter(4, 8);
        System.out.println("Full " + testList.toString());
        testList.makeEmpty();
        System.out.println(testList.toString() +" emptied ");
        
        testList.insertFirst(1);
        System.out.println(testList.toString());
        testList.insertLast(2);
        System.out.println(testList.toString());
        testList.insertLast(4);
        System.out.println(testList);
        testList.insertBefore(4, 3);
        
        System.out.println(testList);
        testList.insertAfter(4, 99);
        System.out.println(testList);
        testList.insertAfter(99, 100);
        System.out.println(testList);
         try {
            int value = testList.getFirst();
            System.out.println("first value: "+value);
            value = testList.getLast();
            System.out.println("last value: "+value);
        } catch (LLI_EmptyListExc e) {
            System.out.println(e.toString());
        }
        
        System.out.println("List Size: "+testList.size());
        testList.remove(1);
        System.out.println(testList.toString());
        testList.removeFirst();
        System.out.println(testList);
        testList.remove(4);
        System.out.println(testList);
        testList.removeLast();
        System.out.println(testList.toString());
        
        
       
    }
   
    
}
