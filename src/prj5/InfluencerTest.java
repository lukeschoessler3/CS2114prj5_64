package prj5;

import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Luke Schoessler (lukeschoessler3)

// -------------------------------------------------------------------------
/**
 * This class tests the methods from the Influencer class
 * 
 * @author Luke Schoessler
 * @version Apr 11, 2024
 */
public class InfluencerTest
    extends TestCase
{
    // ~ Fields ................................................................
    private Month jan;
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
    private Influencer inf;
    private Month[] months;

    // ~Public Methods ........................................................
    /**
     * Creates a brand new influencer for testing
     */
    public void setUp()
    {
        jan = new Month("January", 1000, 40, 2600, 16, 4000);
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

        months = new Month[] { feb, jun, aug, dec, jan, mar, apr, may, nov, sep,
            oct, jul };

        inf = new Influencer("Sidemen", "sidemen", "England", "IRL", months);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getUsername method
     */
    public void testGetUsername()
    {
        assertEquals(inf.getUsername(), "Sidemen");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getChannelName method
     */
    public void testGetChannelName()
    {
        assertEquals(inf.getChannelName(), "sidemen");

    }


    // ----------------------------------------------------------
    /**
     * Tests the getCountry method
     */
    public void testGetCountry()
    {
        assertEquals(inf.getCountry(), "England");

    }


    // ----------------------------------------------------------
    /**
     * Tests the getMainTopic method
     */
    public void testGetMainTopic()
    {
        assertEquals(inf.getMainTopic(), "IRL");

    }


    // ----------------------------------------------------------
    /**
     * Tests the getMonthArray method
     */
    public void testGetMonthArray()
    {
        assertEquals(inf.getMonthArray()[0].getMonthName(), "February");

        feb.getMonthName();
    }


    // ----------------------------------------------------------
    /**
     * Tests the getMonth(int) method
     */
    public void testGetMonthByIndex()
    {
        assertEquals(inf.getMonth(0).getMonthName(), "February");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getMonth(String) method
     */
    public void testGetMonthByName()
    {
        assertNull(inf.getMonth("no month"));
        assertEquals(inf.getMonth("June").getMonthName(), "June");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getFirstQuarter method
     */
    public void testGetFirstQuarter()
    {
        assertEquals(inf.getFirstQuarter()[0].getMonthName(), "January");
        assertEquals(inf.getFirstQuarter()[1].getMonthName(), "February");
        assertEquals(inf.getFirstQuarter()[2].getMonthName(), "March");

        // Ensure that influencer's have applicable and non-applicable
        // first quarters
        Month[] months2 = new Month[] { none, jun, aug, dec, jan, mar, apr, may,
            nov, sep, oct, jul };

        Influencer inf2 =
            new Influencer("Sidemen", "sidemen", "England", "IRL", months2);

        assertNull(inf2.getFirstQuarter());

        Month[] months3 = new Month[12];
        months[0] = jan;
        Influencer inf3 =
            new Influencer("Alpha", "alpha", "CZ", "Sports", months3);

        assertNull(inf3.getFirstQuarter());

    }


    // ----------------------------------------------------------
    /**
     * Tests the traditionalEngagementRate method
     */
    public void testTraditionalEngagementRate()
    {
        assertEquals(inf.traditionalEngagementRate(), 78.0, .01);

        Month[] months2 = new Month[] { none, jun, aug, dec, jan, mar, apr, may,
            nov, sep, oct, jul };

        Influencer inf2 =
            new Influencer("Sidemen", "sidemen", "England", "IRL", months2);

        assertEquals(inf2.traditionalEngagementRate(), 0.0, 0.1);
    }


    // ----------------------------------------------------------
    /**
     * Tests the reachEngagementRate method
     */
    public void testReachEngagementRate()
    {
        assertEquals(inf.reachEngagementRate(), 40.0, .01);

        Month[] months2 = new Month[] { none, jun, aug, dec, jan, mar, apr, may,
            nov, sep, oct, jul };

        Influencer inf2 =
            new Influencer("Sidemen", "sidemen", "England", "IRL", months2);

        assertEquals(inf2.reachEngagementRate(), 0.0, 0.1);

    }


    // ----------------------------------------------------------
    /**
     * Tests the monthTraditionalEngagementRate method
     */
    public void testMonthTraditionalEngagementRate()
    {
        assertEquals(inf.monthTraditionalEngagementRate("January"), 26.0, .01);

        Month[] months2 = new Month[] { none, jun, aug, dec, jan, mar, apr, may,
            nov, sep, oct, jul };

        Influencer inf2 =
            new Influencer("Sidemen", "sidemen", "England", "IRL", months2);

        assertEquals(inf2.monthTraditionalEngagementRate("N/A"), 0.0, 0.1);
    }


    // ----------------------------------------------------------
    /**
     * Tests the monthReachEngagementRate method
     */
    public void testMonthReachEngagementRate()
    {
        assertEquals(inf.monthReachEngagementRate("January"), 40.0, .01);

        Month[] months2 = new Month[] { none, jun, aug, dec, jan, mar, apr, may,
            nov, sep, oct, jul };

        Influencer inf2 =
            new Influencer("Sidemen", "sidemen", "England", "IRL", months2);

        assertEquals(inf2.monthReachEngagementRate("N/A"), 0.0, 0.1);

    }


    // ----------------------------------------------------------
    /**
     * Tests the sortMonths method
     */
    public void testSortMonths()
    {
        inf.sortMonths();

        assertEquals(inf.getMonth(0).getMonthName(), "January");
    }
}
