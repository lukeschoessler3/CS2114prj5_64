package prj5;

// -------------------------------------------------------------------------
/**
 *  Test class for SinglyLinkedList
 * 
 *  @author Kean Jaldin Guzman (keanjg28)
 *  @version Apr 17, 2024
 */
public class SinglyLinkedListTest extends student.TestCase
{
    //~ Fields ................................................................
    private SinglyLinkedList<String> list;
    private SinglyLinkedList<String> emptyList;
    

    //~ Constructors ..........................................................
    /**
     * sets up test cases
     */
    public void setUp() {
        list = new SinglyLinkedList<String>();
        list.add("apple");
        list.add("banana");
        list.add("mango");
        list.add("kiwi");
        
        emptyList = new SinglyLinkedList<String>();
        
        
    }
    //~Public  Methods ........................................................
    
    /**
     * tests size()
     */
    public void testSize() {
        assertEquals(4, list.size());
    }
    
    /**
     * tests both implementations of add()
     */
    public void testAdd() {
        Exception argumentException = null;
        try
        {
            list.add(2, null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            argumentException = e;
        }
        assertTrue(
            "add() is throwing the wrong type of exceptions",
            argumentException instanceof IllegalArgumentException);

        Exception outOfBoundsException = null;
        try
        {
            list.add(-1, "Hello");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            outOfBoundsException = e;
        }
        assertTrue(
            "add() is throwing the wrong type of exceptions",
            outOfBoundsException instanceof IndexOutOfBoundsException);

        Exception outOfBoundsException2 = null;
        try
        {
            list.add(100, "Hello");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            outOfBoundsException2 = e;
        }
        assertTrue(
            "add() is throwing the wrong type of exceptions",
            outOfBoundsException2 instanceof IndexOutOfBoundsException);
        
        Exception argumentException2 = null;
        try
        {
            list.add(null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            argumentException2 = e;
        }
        assertTrue(
            "add() is throwing the wrong type of exceptions",
            argumentException2 instanceof IllegalArgumentException);
        
        list.add(0, "blueBerries");
        list.add(2, "Watermelon");
        emptyList.add(0, "blueberries");
    }
    
    /**
     * tests isEmpty()
     */
    public void testIsEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(list.isEmpty());
    }
    
    /**
     * tests both implementations of remove()
     */
    public void testRemove() {
        Exception thrown = null;
        try
        {
            list.remove(-1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertTrue(
            "remove() is throwing the wrong type of exceptions",
            thrown instanceof IndexOutOfBoundsException);

        Exception thrown1 = null;
        try
        {
            emptyList.remove(0);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            thrown1 = e;
        }
        assertTrue(
            "remove() is throwing the wrong type of exceptions",
            thrown1 instanceof IndexOutOfBoundsException);

        Exception thrown2 = null;
        try
        {
            list.remove(100);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            thrown2 = e;
        }
        assertTrue(
            "remove() is throwing the wrong type of exceptions",
            thrown2 instanceof IndexOutOfBoundsException);
        
        assertFalse(emptyList.remove("string"));
        emptyList.add("ball");
        assertTrue(emptyList.remove("ball"));

        assertFalse(list.remove("hi"));
        assertTrue(list.remove("banana"));
        assertTrue(list.remove("mango"));
        assertTrue(list.remove("kiwi"));
        
        
        list.add("carrot");
        assertTrue(list.remove(0));
        list.add("banana");
        assertTrue(list.remove(1));
    }
    
    /**
     * tests get()
     */
    public void testGet() {
        Exception thrown = null;
        try
        {
            list.get(4);
            fail("get() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertTrue(
            "get() is throwing the wrong type of exceptions",
            thrown instanceof IndexOutOfBoundsException);
        
        assertEquals("kiwi", list.get(3));
    }
    
    /**
     * tests contains()
     */
    public void testContains() {
        assertTrue(list.contains("kiwi"));
        assertFalse(list.contains("stop"));
        list.remove("kiwi");
        list.remove("apple");
        assertFalse(list.contains("apple"));
    }
    
    /**
     * tests clear()
     */
    public void testClear() {
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals("{}", list.toString());
        emptyList.clear();
        assertEquals("{}", emptyList.toString());
    }
    
    /**
     * tests lastIndexOf()
     */
    public void testLastIndexOf() {
        assertEquals(3, list.lastIndexOf("kiwi"));
        list.add(1, "carrot");
        assertEquals(1, list.lastIndexOf("carrot"));
        assertEquals(4, list.lastIndexOf("kiwi"));
    }
    
    /**
     * tests toString()
     */
    public void testToString() {
        assertEquals("{apple, banana, mango, kiwi}", list.toString());
        list.add("pineapple");
        assertEquals(
            "{apple, banana, mango, kiwi, pineapple}",
            list.toString());
        list.remove(4);
        list.remove(0);
        assertEquals("{banana, mango, kiwi}", list.toString());
        assertEquals("{}", emptyList.toString());
        emptyList.add("apple");
        emptyList.add("banana");
        emptyList.remove(0);
        emptyList.remove(0);
        assertEquals("{}", emptyList.toString());
    }
    
    /**
     * tests toArray()
     */
    public void testToArray() {
        Object[] array = list.toArray();
        String[] comparison = { "apple", "banana", "mango", "kiwi" };

        for (int i = 0; i < list.size() - 1; i++)
        {
            assertEquals(comparison[i], array[i]);
        }
    }
    
    /**
     * tests equals()
     */
    public void testEquals() {
        SinglyLinkedList<String> nullList = null;
        assertFalse(list.equals(nullList));

        assertTrue(list.equals(list));

        assertFalse(list.equals("soccer"));

        SinglyLinkedList<String> diffSize = new SinglyLinkedList<String>();
        diffSize.add("apple");
        assertFalse(list.equals(diffSize));

        SinglyLinkedList<String> diffElts = new SinglyLinkedList<String>();
        diffElts.add("soccer");
        diffElts.add("baseball");
        diffElts.add("tennis");
        diffElts.add("basketball");
        assertFalse(list.equals(diffElts));

        SinglyLinkedList<String> diffOrder = new SinglyLinkedList<String>();
        diffOrder.add("kiwi");
        diffOrder.add("mango");
        diffOrder.add("banana");
        diffOrder.add("appple");
        assertFalse(list.equals(diffOrder));

        SinglyLinkedList<String> sameElts = new SinglyLinkedList<String>();
        sameElts.add("apple");
        sameElts.add("banana");
        sameElts.add("mango");
        sameElts.add("kiwi");
        assertTrue(list.equals(sameElts));
    }
}