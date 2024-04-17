package prj5;

import prj5.Month.MonthNameComparator;
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
    private Month feb;
    private Month mar;
    private Month apr;
    private Month may;
    private Month jun;
    private Month jul;
    private Month aug;
    private Month sep;
    private Month oct;
    private Month nov;
    private Month dec;
    private Month none;
    private MonthNameComparator comp;

    // ~Public Methods ........................................................
    /**
     * Creates a brand new month for testing
     */
    public void setUp()
    {
        month = new Month("January", 1000, 40, 2600, 16, 4000);
        feb = new Month("February", 1000, 40, 2600, 16, 4000);
        mar = new Month("March", 1000, 40, 2600, 16, 4000);
        apr = new Month("April", 1000, 40, 2600, 16, 4000);
        may = new Month("May", 1000, 40, 2600, 16, 4000);
        jun = new Month("June", 1000, 40, 2600, 16, 4000);
        jul = new Month("July", 1000, 40, 2600, 16, 4000);
        aug = new Month("August", 1000, 40, 2600, 16, 4000);
        sep = new Month("September", 1000, 40, 2600, 16, 4000);
        oct = new Month("October", 1000, 40, 2600, 16, 4000);
        nov = new Month("November", 1000, 40, 2600, 16, 4000);
        dec = new Month("December", 1000, 40, 2600, 16, 4000);
        none = new Month("None", 1000, 40, 2600, 16, 4000);
        comp = new MonthNameComparator();
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
     * Tests the getMonthIndex method
     */
    public void testGetMonthIndex()
    {
        assertEquals(month.getMonthIndex(), 0);
        assertEquals(feb.getMonthIndex(), 1);
        assertEquals(mar.getMonthIndex(), 2);
        assertEquals(apr.getMonthIndex(), 3);
        assertEquals(may.getMonthIndex(), 4);
        assertEquals(jun.getMonthIndex(), 5);
        assertEquals(jul.getMonthIndex(), 6);
        assertEquals(aug.getMonthIndex(), 7);
        assertEquals(sep.getMonthIndex(), 8);
        assertEquals(oct.getMonthIndex(), 9);
        assertEquals(nov.getMonthIndex(), 10);
        assertEquals(dec.getMonthIndex(), 11);
        assertEquals(none.getMonthIndex(), -1);
    }


    // ----------------------------------------------------------
    /**
     * Tests the compare method from the comparator class
     */
    public void testCompare()
    {
        Month sameMonth = new Month("January", 1000, 40, 2600, 16, 4000);
        
        assertEquals(comp.compare(month, sameMonth), 0);
        assertEquals(comp.compare(month, jun), -1);
        assertEquals(comp.compare(jun, month), 1);
        assertEquals(comp.compare(jun, none), 100);
        assertEquals(comp.compare(none, jun), 100);
    }

}
