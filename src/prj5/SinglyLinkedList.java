// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times. I
// will not lie, cheat, or steal, nor will I accept the actions of those who do.
// -- Kean Jaldin Guzman (keanjg28)
// -- Lucas Lombardi
package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * The SinglyLinkedList class is a basic implementation of the LinkedList
 * interface
 * 
 * @author Kean Jaldin Guzman (keanjg28)
 * @author Lucas Lombardi
 * @param <E>
 *            object type
 * @version Apr 17, 2024
 */
public class SinglyLinkedList<E>
    implements LinkedList<E>
{
    // ~ Fields ................................................................
    private Node<E> head;
    private int size;

    // ~ Constructors ..........................................................
    /**
     * creates a new SinglyLinkedList object
     */
    public SinglyLinkedList()
    {
        head = null;
        size = 0;
    }


    // ~Public Methods ........................................................
    /**
     * Gets the number of elements in the SinglyLinkedList
     *
     * @return the number of elements
     */
    @Override
    public int size()
    {
        return size;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(int index, E obj)
    {
        // check if the object is null
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size()))
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current = head;

        // empty stack case
        if (isEmpty())
        {
            head = new Node<E>(obj);
        }

        if (current == null)
        {
            head = new Node<E>(obj);
        }

        // all other cases
        else
        {
            if (index == 0)
            {
                Node<E> newNode = new Node<E>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else
            {
                int currentIndex = 0;
                while (current != null)
                {
                    if ((currentIndex + 1) == index)
                    {
                        Node<E> nextNext = current.next;
                        Node<E> newNode = new Node<E>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);

                    }
                    currentIndex++;
                    current = current.next();
                }
            }
        }
        size++;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(E obj)
    {
        // check if the object is null
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = head;

        // empty stack case
        if (isEmpty())
        {
            head = new Node<E>(obj);
        }

        // edge case if current node is null
        if (current == null)
        {
            head = new Node<E>(obj);
        }

        // other cases
        else
        {
            while (current.next != null)
            {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    @Override
    public boolean remove(E obj)
    {
        Node<E> current = head;

        // account for matching head
        if ((null != head) && (obj.equals(current.data)))
        {
            head = head.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null))
        {
            if ((obj.equals(current.next.data)))
            {
                current.setNext(current.next.next);
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    @Override
    public boolean remove(int index)
    {
        // if the index is invalid
        if (index < 0 || head == null)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<E> current = head;
        int currentIndex = 0;

        // if the obj is in the first index
        if (currentIndex == index)
        {
            head = head.next;
            size--;
            return true;
        }

        while (current.next != null)
        {
            if ((currentIndex + 1) == index)
            {
                Node<E> newNext = current.next.next;
                current.setNext(newNext);
                size--;
                return true;
            }
            current = current.next;
            currentIndex++;
        } // while

        throw new IndexOutOfBoundsException("Index is out of bounds");

    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    @Override
    public E get(int index)
    {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null)
        {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException();
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    @Override
    public boolean contains(E obj)
    {
        Node<E> current = head;
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    @Override
    public void clear()
    {

        if (head != null)
        {
            head.setNext(null);
            head = null;
            size = 0;
        }
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    @Override
    public int lastIndexOf(E obj)
    {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString()
    {
        String result = "{";

        Node<E> current = head;
        while (current != null)
        {
            result += "" + current.data;
            current = current.next;
            if (current != null)
            {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list contains A, B,
     * C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray()
    {

        Object[] array = new Object[this.size()];

        Node<E> current = head;
        int count = 0;
        while (current != null)
        {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents in the exact same
     * order
     *
     * @return a boolean of whether two lists have the same contents, item per
     *             item and in the same order
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() == obj.getClass())
        {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<E> other = ((SinglyLinkedList<E>)obj);
            if (other.size() == this.size())
            {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
                while (current != null)
                {
                    if (!current.getData().equals(otherCurrent.getData()))
                    {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param c
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void sort(Comparator<? super E> c)
    {
        // Make sure the list is NOT empty or/and does NOT have 1 element
        if (head == null || head.next() == null)
        {
            return;
        }

        // Break into sorted and unsorted chain
        Node unsorted = head.next();
        Node sorted = head;
        sorted.setNext(null);

        while (unsorted != null)
        {
            Node insertNode = unsorted;
            unsorted = unsorted.next();
            insertInOrder(insertNode, c);
        }
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param insertNode
     * @param c
     */
    public void insertInOrder(Node<E> insertNode, Comparator<? super E> c)
    {
        E item = insertNode.getData();

        // what head is this
        Node<E> currentNode = head;
        Node<E> previousNode = null;

        // Locate where to insert
        while ((currentNode != null)
            && (c.compare(currentNode.getData(), item) <= 0))
        {
            previousNode = currentNode;
            currentNode = currentNode.next();
        }

        // Now try to make the insertion

        // If more than 1 element
        if (previousNode != null)
        {
            previousNode.setNext(insertNode);
            insertNode.setNext(currentNode);
        }

        // If you have 1 element
        else
        {
            insertNode.setNext(head);
            head = insertNode;
        }
    }

    public static class Node<D>
    {
        // ~ Fields
        // .............................................................
        private D data;
        private Node<D> next;

        // ~ Constructors
        // .......................................................
        public Node(D d)
        {
            data = d;
        }


        // ~Public Methods .....................................................
        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n)
        {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next()
        {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData()
        {
            return data;
        }
    } // end of Node class
} // end of SinglyLinkedList
