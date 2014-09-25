

/**
   A list iterator allows access of a position in a linked list.    
   This interface contains a subset of the methods of the 
   standard java.util.ListIterator interface. The methods for
   backward traversal are not included.
*/
public interface ListIterator
{  
   /**
      Moves the iterator past the next element.
      @return the traversed element
   */
   Object next();
      
   /**
      Tests if there is an element after the iterator position.
      @return true if there is an element after the iterator position
   */
   boolean hasNext();

   /*
Returns:
*/
   /**
      Returns the index of the element that would be returned by a
      subsequent call to next(). (Returns list size if the list
      iterator is at the end of the list.)
      @return the index of the element that would be returned by a call to next
    */
   int nextIndex();

   
   /**
      Adds an element before the iterator position
      and moves the iterator past the inserted element.
      @param element the element to add
   */
   void add(Object element);
      
   /**
      Removes the last traversed element. This method may
      only be called after a call to the next() method.
   */
   void remove();

   /**
      Sets the last traversed element to a different value. 
      @param element the element to set
   */
   void set(Object element);
}
