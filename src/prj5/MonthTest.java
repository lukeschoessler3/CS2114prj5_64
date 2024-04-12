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

}
