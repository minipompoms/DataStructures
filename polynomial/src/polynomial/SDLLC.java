/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;
import java.util.NoSuchElementException;
/**
 *
 * @author Paige Kohn
 * @param <Type>
 */
public class SDLLC <Type extends Comparable <Type>> implements SDLLI<Type> {
    
    private Node<Type> head; //node
    
    /**
     *constructor
     */
    public SDLLC()
    {
        head = new Node<Type>(null);
        head.setNext(head);
        head.setPrev(head);
    }
 
    @Override
    public void insert(Type info) 
    {
         Node<Type> newNode = new Node<Type>(info);
         Node<Type> current = head.getNext();
         Node<Type> previous = head;
         
         while (current != head)
         {
            if(info.compareTo(current.getInfo())<0)//checks the position for insertion
            {
                break; //break out of look to insert node here
            }
            else
            {   
                //keep checking next node
                previous = current;
                current = current.getNext();
            }
         }
         
         //insert node
         newNode.setNext(current);
         previous.setNext(newNode);
         newNode.setPrev(previous);
         current.setPrev(newNode);        
    }

    /**
     * remove the node holding value Type
     * @param info - Type value to be removed
     * @return boolean true if removed, false, if no such value in the list
     * @throws polynomial.NotFoundException
     */
    @Override
    public boolean remove(Type info) throws NotFoundException
    {
       Node<Type> current;
       current = head.getNext();
       Node<Type> previous = head;
       
       while (current != null)
       {
           if (current.getInfo().compareTo(info)==0)//if data is a match
           {
               previous.setNext(current.getNext()); //remove current node
               return true;
           }    
           else
           {
               if (current.getInfo().compareTo(info)>0)//past location of value so no match
               {
                   throw new NotFoundException(); //item not found
               }
           }
           //moves to next node
           previous = current;
           current = current.getNext();
       }
       throw new NotFoundException();         
    }
   
    /**
     * initialize the list for a subsequent call to next
     */
    @Override
    public void setFirst() 
    {
        Node<Type> first;
        
        
        
    }
    
    public int size()
    {
        int count = 0;
        Node<Type> current = head;
        while (current.next != null)
        {
            current = current.getNext();
            count++;
        }
        return count;
    }
      /**
     * indicate whether a call to next will succeed
     * @return boolean true if the current node is not null, false otherwise
     */
    @Override
    public boolean hasNext() 
    {
        if (head!= null)
        {
            return true;
        }
        else
        {
        return false;
        }
    }

    /**
     * return the value of the current node of type Type
     * and advance the current node to current.getNext()
     * @return - value held by the current node of type Type
     */
    @Override
    public Type next() 
    {
        if (hasNext())
        {
            Type next = head.getInfo();
            head = head.getNext();
            return next;
        }
        
        else
        {
            throw new NoSuchElementException();
        }
    }
    
  
    
    @Override
    public String toString()
    {
        StringBuilder ts = new StringBuilder();
        return ts.toString();
    }
    
   
 
       // <editor-fold defaultstate="collapsed" desc="LLI_Node">        public LLI_Node(int value)
 
    private class Node<Type>
    {
       private Type info;
       private Node<Type> prev;
       private Node<Type> next;
       
       
       
// <editor-fold defaultstate="collapsed" desc="constructor, getters, and setters">
       public Node(Type info)
       {
           this.info = info;
           this.prev = null;
           this.next = null;         
       }
       
       public void setPrev(Node <Type> node)
       {
           prev = node;
       }
       
       public void setNext(Node <Type> node)
       {
           next = node; 
       }  
       
       public Node<Type> getPrev()
       {
           return prev;
       }
       
       public Node<Type> getNext()
       {
           return next;
       }
       
       public Type getInfo()
       {
           return info;
       }    
         // </editor-fold>
       
       
     
    } 
       // </editor-fold>
}
