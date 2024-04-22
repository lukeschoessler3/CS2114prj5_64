package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author lasch
 * @version Apr 22, 2024
 */
public class CompareTraditionalEngagementRate
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
