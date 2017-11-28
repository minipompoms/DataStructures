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
public class SDLLC<Type extends Comparable<Type>> implements SDLLI<Type> {

    private Node<Type> head; // node
    private Node<Type> dummy; //dummy node to traverse list
    /**
     * constructor
     */
    public SDLLC() 
    {
	head = new Node<>(null);
	head.setNext(head);
	head.setPrev(head);
        dummy = head;
    }
    /**
     * insert a node with info of type Type into the list
     * @param info Type info to be inserted
     */
    @Override
    public void insert(Type info) 
    {
		
	Node<Type> newNode = new Node<>(info);	
	Node<Type> current = head.next;
	Node<Type> previous = head;
		

	if (head.getInfo() == null)// if list is null insert at head
	{
            head = new Node<>(info);
	}
	 
        else if (info.compareTo(head.info) < 0) // checks the list for position of insertion
        {		
           
            newNode.next = head;  // insertion before
            head.prev = newNode;
            head = newNode;
	}

	else 
        { 
            
            while (current != null) 
            {
	    
		if (info.compareTo(current.info) <= 0) //if current term is less than or equal to 
                                                       //to new node, insert here
		{				
                    break; // will now check for insertion after	
		}
		 
                    previous = current; // increment references
                    current = current.next;
		}
			
            newNode.next = previous.next; //insert item, will be null, if appending to end of list 
            newNode.prev = previous;    
            previous.next = newNode;   
	}
        dummy = head;
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
	Node<Type> current = head.getNext();
	Node<Type> previous = head;
      
        while (current != null) 
        {

            if (previous.getInfo().compareTo(info) == 0)// if data is a match
            {
               if(previous!=head)
               {
                    previous.prev.setNext(current); //set head to current 
                    return true;
               }
               if(current.info.compareTo(info) == 0) 
               {
                   head = head.next;
                   dummy = head; 
                   return true;
               }              
	    } 
            else 
                {
                    if (current.getInfo().compareTo(info) > 0)// past location of											// value so no match
                    {
			throw new NotFoundException(); // item not found
                    }
		}                    
                    previous = current;     // move to next node
                    current = current.getNext();                   
		}
        
        throw new NotFoundException("Item not found");	
    }
    
    /**
    * initialize the list for a subsequent call to next
    */    
    @Override
    public void setFirst() 
    {
       
    }

    /**
    * indicate whether a call to next will succeed
    * @return boolean true if the current node is not null, false otherwise
    */
    @Override
    public boolean hasNext() 
    {
        if(dummy == null)
        {
            dummy = head;
            return false; 
        }
        return dummy != null;
    }

    /**
    * return the value of the current node of type Type and advance the current
    * node to current.getNext()
    * @return - value held by the current node of type Type
    */
    @Override
    public Type next() 
    {        
        if (!hasNext())
            throw new NoSuchElementException("no such element");

        Type data = dummy.getInfo(); //use a dummy node in place of head
        dummy = dummy.next;         // otherwise head will be lost if once traversed
        return data;
    }

    @Override
    public String toString() 
    {
	StringBuilder ts = new StringBuilder();
	Node<Type> current = head;
	while (current != null) 
        {
            ts.append(current.getInfo()).append("  ");
            current = current.getNext();
	}
            return ts.toString();
	}

	// <editor-fold defaultstate="collapsed" desc="LLI_Node"> public
	// LLI_Node(int value)

	private class Node<Type> {
		private Type info;
		private Node<Type> prev;
		private Node<Type> next;

		// <editor-fold defaultstate="collapsed"
		// desc="constructor, getters, and setters">
		public Node(Type data) {
			this.info = data;
			this.next = null;
			this.prev = null;
		}

		public void setPrev(Node<Type> node) {
			prev = node;
		}

		public void setNext(Node<Type> node) {
			next = node;
		}

		public Node<Type> getPrev() {
			return prev;
		}

		public Node<Type> getNext() {
			return next;
		}

		public Type getInfo() {
			return info;
		}
		// </editor-fold>

	}
	// </editor-fold>
}
