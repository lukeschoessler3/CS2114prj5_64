package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Compares the traditional engagement rates of two influencer's
 * 
 * @author Luke Schoessler
 * @version Apr 22, 2024
 */
public class CompareQuarterTraditionalEngagementRate
    implements Comparator<Influencer>
{

// ----------------------------------------------------------
    /**
     * Compare two influencer's traditional engagement rates (ints)
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
        return Double.compare(
            left.traditionalEngagementRate(),
            right.traditionalEngagementRate());
    }
}
