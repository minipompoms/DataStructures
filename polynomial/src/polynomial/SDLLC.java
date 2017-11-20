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
    private Node<Type> dummy;
    /**
     * constructor
     */
    public SDLLC() 
    {
	head = new Node<>(null);
	head.setNext(head);
	head.setPrev(head);
    }
    /**
     * insert a node with info of type Type into the list
     * @param info
     */
    @Override
    public void insert(Type info) 
    {
	System.out.println("inserting: " + info);
		
	Node<Type> newNode = new Node<>(info);	
	Node<Type> current = head.next;
	Node<Type> previous = head;
		

	if (head.getInfo() == null)// if list is null insert at head
	{
            head = new Node<>(info);
	}

	 
        else if (info.compareTo(head.info) < 0) // checks the position 
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
                                            //to new node, stop so newNode can be inserted 
		{
		// will now check for// insertion after			
                    break;
		}
		// "Increment" references 
                    previous = current;
                    current = current.next;
		}
			
            newNode.next = previous.next; //insert item - will be null, if appending to end of list ... 
            newNode.prev = previous;    
            previous.next = newNode;   
		}
	}

/**
* remove the node holding value Type
* 
* @param info - Type value to be removed
* 
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
            if (current.getInfo().compareTo(info) == 0)// if data is a match
            {
		previous.setNext(current.getNext()); // remove current node
		return true;
	    } else 
                {
                    if (current.getInfo().compareTo(info) > 0)// past location of											// value so no match
                    {
			throw new NotFoundException(); // item not found
                    }
		}
		// moves to next node
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
        Node<Type> current = head;

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
    * 
    * @return boolean true if the current node is not null, false otherwise
    */
    @Override
    public boolean hasNext() 
    {
        return dummy != null;
    }

    /**
    * return the value of the current node of type Type and advance the current
    * node to current.getNext()
    * 
    * @return - value held by the current node of type Type
    */
    @Override
    public Type next() 
    {
        
        if (!hasNext())
            throw new NoSuchElementException("no such element");

        Type data = head.getInfo();
        dummy = head.next;
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
