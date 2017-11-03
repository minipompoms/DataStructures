/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlltest;

/**
 *
 * @author Paige
 */
public class CircularLLTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CLLNode a = new CLLNode(1);
        CLLNode b = new CLLNode(2); //values
        CLLNode c = new CLLNode(3);
        CLLNode d = new CLLNode(0);
        CLLNode e = new CLLNode(6);
        CLLNode f = new CLLNode(8);
        CLLNode g = new CLLNode(5);
       //(int position, int value)
        //insertBefore(1,5),
        //insertAfter(1,6), 
        //insertBefore(7,8)
        //removeFirst()
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtHead(a);
        list.insetAtEnd(c);
        list.insertAtHead(b);
        list.insetAtEnd(d);
        list.insertInList(g, 1);
        list.insertInList(e, 2);
        list.insertInList(f, 6);
        list.deleteFirst();
        //list.insertInList(a, 5);
        //list.insertInList(a, 6);
        //list.insertInList(f, 8);
       // list.deleteFirst();
        list.printList();
        
    }
    
}
