// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Luke Schoessler (lukeschoessler3)


package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Compares the January reach engagement rates
 * 
 * @author Luke Schoessler
 * @version Apr 22, 2024
 */
public class CompareJanReachEngagementRate
    implements Comparator<Influencer>
{

// ----------------------------------------------------------
    /**
     * Compare two influencer's january reach engagement rates (ints)
     * 
     * @param left
     *            the left-side to compare
     * @param right
     *            the right-side to compare
     * @return A negative number if the value of the left reach engagement rate
     *             is less than the right; A positive number if the value of the
     *             left reach engagement rate is more than the right; 0 if both
     *             engagement rates (of left and right) are equal
     */
    public int compare(Influencer left, Influencer right)
    {
        String monthName = "January";

        return Double.compare(
            left.monthReachEngagementRate(monthName),
            right.monthReachEngagementRate(monthName));
    }
}
