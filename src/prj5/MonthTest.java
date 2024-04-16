package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This class tests the methods from the Month class
 * 
 * @author Luke Schoessler
 * @version Apr 11, 2024
 */
public class MonthTest
    extends TestCase
{
    // ~ Fields ................................................................
    private Month month;

    // ~Public Methods ........................................................
    /**
     * Creates a brand new month for testing
     */
    public void setUp()
    {
        month = new Month("January", 1000, 40, 2600, 16, 4000);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getMonthName method
     */
    public void testGetMonthName()
    {
        assertEquals(month.getMonthName(), "January");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getLikes method
     */
    public void testGetLikes()
    {
        assertEquals(month.getLikes(), 1000);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getComments method
     */
    public void testGetComments()
    {
        assertEquals(month.getComments(), 40);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getViews method
     */
    public void testGetViews()
    {
        assertEquals(month.getViews(), 2600);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getPosts method
     */
    public void testGetPosts()
    {
        assertEquals(month.getPosts(), 16);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getFollowers method
     */
    public void testGetFollowers()
    {
        assertEquals(month.getFollowers(), 4000);
    }


    // ----------------------------------------------------------
    /**
     * Tests the compareTo method
     */
    public void testCompareTo()
    {

    }

}
