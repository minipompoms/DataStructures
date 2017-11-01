package linkedlists;
/**
 *
 * @author akatz17
 */
public class LLI

{

    private LLI_Node head;

    public LLI()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void makeEmpty()
    {
        head = null;
    }

    public void insertFirst(int val)
    {
        LLI_Node first = new LLI_Node(val);
        first.setNext(head);
        head = first;
    }
    
    public void insertLast(int val)
    {
        if (isEmpty())
        {
            insertFirst(val);
        }
        else
        {
            LLI_Node current = head;
            while (current.getNext() != null)
            {
                current = current.getNext();
            }
            LLI_Node newNode = new LLI_Node(val);
            current.setNext(newNode);
        }
    }

    public boolean insertBefore(int bef, int val)
    {
        int index = indexOf(bef);
        if (index == -1)
        {
            return false;
        }
        else
        {
            LLI_Node current = head;
            for (int ix = 0; ix < index; ++ix)
            {
                current = current.getNext();
            }
            LLI_Node newNode = new LLI_Node(current.getValue());
            newNode.setNext(current.getNext());
            current.setValue(val);
            current.setNext(newNode);

            return true;
        }

    }

    /**
     * insert value after given element
     * @param aft
     * @param val
     * @return
     */
    public boolean insertAfter(int aft, int val)
    {

       int index = indexOf(aft);
       if  (index == -1)
       {
           return false;
       }
       LLI_Node current = head;

       for (int ix = 0; ix < index; ++ix)
       {
            current = current.next; // Find the corresponding node
       }
      
       LLI_Node newNode = new LLI_Node(val); //new Node to insert
       newNode.setNext(current.getNext()); //link newNode to next node
       current.setNext(newNode); //point current to next to link list to newNode

       return true;
    }

    /**
     * removes given value
     * @param val
     * @return
     */
    public boolean remove(int val)
    {

        if(isEmpty()) //empty LL check
        {
            return false;
        }
            if (val == head.getValue()) //if head = value no need to traverse list
            {
                removeFirst();
            }
            LLI_Node previous = head;
            LLI_Node current = head.getNext();     
            while (current != null)
            {
                if (val == current.getValue())
            {
                previous.next = current.next;
            }
            else 
            {
                previous.setNext(previous.next);
                return true;
            }
                 previous = current;
        current = current.getNext();
        }
       /* else
        {
            
            for (int ix = 0; ix < size(); ix++) //traverse list
                {
                    if (val == current.getValue()) //find corresponding node
                {
                    previous.next = current.next; //remove node it's a match
                    return true;
        }
            else
            {
                previous = current;
                current = current.next;
            }
    }
    }
    */
      
       return false;
}

    /**
     * removes first value in the linked list
     * @return
     */
    public boolean removeFirst()
    {
        if (isEmpty())
        {
            return false;
        }
        else
        {
            head = head.next; //unlink head and assign next node as head
            return true;
        }
    }

    /**
     * removes last value in linked list
     * @return
     */
    public boolean removeLast()
    {
        if (isEmpty())
        {
            return false;
        }
        else
        {
            LLI_Node current = head;
            LLI_Node last = head.getNext();
            if (last == null)
            {
                head = null;
            }
            else
            {
                while (last.getNext() != null) //traverse until you get to last node !null
                {
                    current = last; //assign one before last value to head
                    last = last.getNext(); //then last value
                }
                current.setNext(null); //then unlink head from last
            }
            return true;
        }
    }

    /**
     *
     * @return
     * @throws LLI_EmptyListException
     */
    public int getFirst() throws LLI_EmptyListException 
    {
        LLI_Node current = head;
        if (!isEmpty()) //checks that LL is not empty
        {
            return current.getValue();
        }
        else //throws an exception if list is empty
            throw new LLI_EmptyListException();
    }

    /**
     * 
     * @return
     * @throws LLI_EmptyListException
     */
    public int getLast() throws LLI_EmptyListException 
    {
        LLI_Node last = head.getNext();
        if (isEmpty())
        {
            throw new LLI_EmptyListException(); //throws an excp if empty list
        }
        else
            while (last.getNext() != null) //keeps going until reaches null node
            {
                last = last.getNext();
            }
        return last.getValue(); //returns last value
    }

    /**
     *
     * @returns size of linked list
     */
    public int size()
    {
        int count = 0; //sets counter to 0 for an empty list
        LLI_Node current = head;
        while (current != null) //loop to continue while atleast 1 value present
                {
                    current = current.getNext(); //continues the count so long as there are elements
                    count++;//increases count for every element
                }
        return count;
    }

        private int indexOf(int val)
    {
        int index = -1; // value to be returned
        LLI_Node current = head;
        int ix = -1; // nodes traversal
        while (current != null)
        {
            ++ix;
            if (current.getValue() == val)
            {
                index = ix;
                break; // while - we found the inex of val
            }
            current = current.getNext();
        }
        return index;
    }

    @Override
    public String toString()
    {
        StringBuilder toS = new StringBuilder ();
        toS.append("List: ");
        LLI_Node current = head;
        while (current != null)
        {
            toS.append(current.getValue()).append("  ");
            current = current.getNext();
        }
        return toS.toString();
    }


    // <editor-fold defaultstate="collapsed" desc="LLI_Node">        public LLI_Node(int value)
    /**
     * private class encapsulating a single node
     */
    private class LLI_Node
    {

        private int value;
        private LLI_Node next;

        // <editor-fold defaultstate="collapsed" desc="constructor, getters, and setters">
        public LLI_Node(int value)
        {
            this.value = value;
            next = null;
        }

        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
        }

        public LLI_Node getNext()
        {
            return next;
        }

        public void setNext(LLI_Node next)
        {
            this.next = next;
        }
        // </editor-fold>

    }
    // </editor-fold>
}
