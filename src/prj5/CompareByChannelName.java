// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Lucas Lombardi (lucaslombardi)

package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Compares two Channel Name's and sees if this is greater than other based on
 * lexile order
 * 
 * @author Lucas Lombardi
 * @version Apr 17, 2024
 */
public class CompareByChannelName
    implements Comparator<Influencer>
{

    // ----------------------------------------------------------
    /**
     * Compare two influencer's channel names by lexile order
     * 
     * @param left
     *            the left-side to compare
     * @param right
     *            the right-side to compare
     * @return A negative number if the lexile order of left is less than the
     *             right; A positive number if the lexile order of the left is
     *             more than the right; 0 if both lexile orders of left and
     *             right are equal
     */
    public int compare(Influencer left, Influencer right)
    {
        return left.getChannelName()
            .compareToIgnoreCase(right.getChannelName());
    }
}
