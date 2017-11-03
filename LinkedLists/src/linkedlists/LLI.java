package linkedlists;
/**
 *
 * @author Paige Kohn
 */
public class LLI

{

    private LLI_Node head;

    /**
     * constructor
     */
    public LLI()
    {
        head = null;
    }

    /**
     * checks if list is empty
     * @return boolean - success or failure
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * removes all elements from list
     */
    public void makeEmpty()
    {
        head = null;
    }

    /**
     * insert value at head of list
     * @param val value to be inserted
     */
    public void insertFirst(int val)
    {
        LLI_Node first = new LLI_Node(val);
        first.setNext(head);
        head = first;
    }
    
    /**
     * insert given value
     * @param val value to be inserted
     */
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

    /**
     * insert value before given element
     * @param bef integer value before which val is to be inserted
     * @param val integer to be inserted
     * @return boolean - success or failure
     */
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
     * @param aft integer value after which val is to be inserted
     * @param val integer to be inserted
     * @return boolean - success or failure
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
     * @param val value to be removed
     * @return boolean - success or failure
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
       return false;
}

    /**
     * removes first value in the linked list
     * @return boolean - success or failure
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
     * @return success or failure
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
     * return first element in list
     * @return integer - value
     * @throws LLI_EmptyListExc
     */
    public int getFirst() throws LLI_EmptyListExc 
    {
        LLI_Node current = head;
        if (!isEmpty()) //checks that LL is not empty
        {
            return current.getValue();
        }
        else //throws an exception if list is empty
            throw new LLI_EmptyListExc();
    }

    /**
     * return last element in the list
     * @return integer - value
     * @throws LLI_EmptyListExc
     */
    public int getLast() throws LLI_EmptyListExc 
    {
        LLI_Node last = head.getNext();
        if (isEmpty())
        {
            throw new LLI_EmptyListExc(); //throws an excp if empty list
        }
        else
            while (last.getNext() != null) //keeps going until reaches null node
            {
                last = last.getNext();
            }
        return last.getValue(); //returns last value
    }

    /**
     * returns the list size
     * @return integer - number of elements in list
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
