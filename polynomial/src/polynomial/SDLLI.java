
package polynomial;

/**
 * interface for a generic Sorted Doubly Linked List
 * @author katz 
 * @param <Type> 
 */
public interface SDLLI<Type>
{
    /**
     * insert a node with info value val into the list
     * @param val - insert a node holding value T
     */
    public void insert(Type val);
    
    /**
     * remove the node holding value T
     * @param val - T value to be removed
     * @return boolean true if removed, false, if no such value in the list
     * @throws polynomial.NotFoundException
     */
    public boolean remove(Type val) throws NotFoundException;
    
    /**
     * initialize the list for a subsequent call to next
     */
    public void setFirst();
    
    /**
     * indicate whether a call to next will succeed
     * @return boolean true if the current node is not null, false otherwise
     */
    public boolean hasNext();
    
    /**
     * return the value of the current node of type T
     * and advance the current node to current.getNext()
     * @return - value held by the current node of type T
     */
    public Type next();
    
}
