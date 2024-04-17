package prj5;

import java.util.Comparator;

//-------------------------------------------------------------------------
/**
* Compares two engagement rate values (from each respected Influencer).
* Each influencer has an int value engagement rate tied to their object.
* These int(s) will be compared.
* 
* 
* @author Lucas Lombardi
* @version Apr 17, 2024
*/

public class CompareReachEngagementRate implements Comparator<Influencer>{
  
    /*
     * Compare two influencer's reach engagement rates (ints)
     * @param left the left-side to compare
     * @para right the right-side to compare
     * @return A negative number if the value of the left reach
     *         engagement rate is less than the right;
     *         A positive number if the value of the left reach
     *         engagement rate is more than the right;
     *         0 if both engagement rates (of left and right)
     *         are equal
     */
    public int compare(Influencer left, Influencer right) {
        return Double.compare(left.reachEngagementRate(), 
            right.reachEngagementRate());
    }
}
