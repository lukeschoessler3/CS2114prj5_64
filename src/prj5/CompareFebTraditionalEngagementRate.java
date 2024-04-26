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
 * Compares the February traditional engagement rates
 * 
 * @author Luke Schoessler
 * @version Apr 22, 2024
 */
public class CompareFebTraditionalEngagementRate
    implements Comparator<Influencer>
{

// ----------------------------------------------------------
    /**
     * Compare two influencer's february traditional engagement rates (ints)
     * 
     * @param left
     *            the left-side to compare
     * @param right
     *            the right-side to compare
     * @return A negative number if the value of the left traditional engagement
     *             rate is less than the right; A positive number if the value
     *             of the left traditional engagement rate is more than the
     *             right; 0 if both engagement rates (of left and right) are
     *             equal
     */
    public int compare(Influencer left, Influencer right)
    {
        String monthName = "February";

        return Double.compare(
            left.monthTraditionalEngagementRate(monthName),
            right.monthTraditionalEngagementRate(monthName));
    }
}
